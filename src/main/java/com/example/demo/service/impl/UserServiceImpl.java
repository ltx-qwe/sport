package com.example.demo.service.impl;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import com.example.demo.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

import java.util.UUID;


/**
 * 用户模块业务层的实现类
 */

@Service      //Service 注解，将当前类的对象交给 spring 来管理，自动创建类的对象以及对象的维护

public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void reg(User user) {
         /**
          * 1、根据参数 user 对象获取注册的用户名
           * 2、调用持久层的 User findByUsername(String username)方法，根据用户名
            查询用户数据
          * 3、判断查询结果是否不为 null * 4、是：表示用户名已被占用，则抛出 UsernameDuplicateException 异常
           */
          //通过 user 参数来获取传递过来的 username
        String username = user.getUsername();

          //调用 findByUsername（username）判断用户是否被注册过
        User result = userMapper.findByUserName(username);
        if (result != null){
         //抛出异常
            throw new UsernameDuplicateException("用户名被占用");
        }

        //文档3 ==》
        //补全数据：加密后的密码
/**
 * 密码加密处理实现：md5 加密形式
 * （串 + password + 串）----md5 算法进行加密，连续加载三次，这里的串就
 是盐值
 * （盐值 + password + 盐值）----盐值就是一个随机的字符串
 */
        String userPassword = user.getPassword();
//获取盐值（随机生成一个盐值）
        String salt = UUID.randomUUID().toString().toUpperCase();
//将密码和盐值作为一个整体进行加密处理
        String md5Password = getMd5Password(userPassword, salt);
//补全数据：加密后的密码
        user.setPassword(md5Password);
//补全数据：盐值
        user.setSalt(salt);
        //文档3

        // 补全数据：isDelete(0)
        user.setIsDelete(0);
        // 补全数据：4 项日志属性
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);
/**
 * 1、表示用户名没有被占用，则允许注册
 * 2、调用持久层 Integer insert(User user)方法，执行注册并获取返回值(受影响
 的行数) * 3、判断受影响的行数是否不为 1
 * 4、是：插入数据时出现某种错误，则抛出 InsertException 异常
 */
//执行注册业务功能的实现（rows==1）
        Integer rows = userMapper.insert(user);
        if (rows != 1){
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }
    //文档三
    /**
     * 执行密码加密
     * @param password 原始密码
     * @param salt 盐值
     * @return 加密后的密文
     */
    private String getMd5Password(String password,String salt){
        for (int i=0;i<3;i++){
//md5 加密方法的调用（进行三次调用）
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
//返回加密后的密码
        return password;
    }
    //文档三


    //文档5==》
    // 1.在 UserServiceImpl 类中添加 login(String username, String password)方法并分析业务逻辑。
    //2.login(String username, String password)方法中代码的具体实现。

    @Override
    public User login(String username, String password) {
//根据用户名称来查询用户的数据是否存在，如果不存在则抛出异常
        User result = userMapper.findByUserName(username);
//判断用户查询结果是否 null，是，抛出 UserNotFoundException 异常
        if (result==null){
            throw new UserNotFoundException("用户数据不存在的错误");
        }
        //判断用户查询结果中的 isDelete 是否为 1，是，抛出 UserNotFoundException
        if (result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在的错误");
        }
           //判断密码是否输入错误
           //1、从查询结果中获取盐值
        String salt = result.getSalt();

            //调用 getMd5Password（）方法，将参数 password 和 salt 结合起来进行加密
        String newMd5Password = getMd5Password(password, salt);
         //判断查询结果中的密码，与以上加密得到的密码是否一致
        if (!result.getPassword().equals(newMd5Password)){
            throw new PasswordNotMatchException("密码验证失败的错误");
        }
             //创建新的 user 对象
        User user = new User();
           //将查询结果中的 uid、username、avata 封装到新的 user 对象中，提升系统性能
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
          //返回新的 user 对象
        return user;
    }
         //文档5

    //文档7
    @Override
    public void changePassword(Integer uid, String username, String oldPassword,
                               String newPassword) {
        // 调用userMapper的findByUid()方法，根据参数uid查询用户数据
        User result = userMapper.findByUid(uid);
// 检查查询结果是否为null
        if (result == null) {
// 是：抛出UserNotFoundException异常
            throw new UserNotFoundException("用户数据不存在");
        }
// 检查查询结果中的isDelete是否为1
        if (result.getIsDelete().equals(1)) {
// 是：抛出UserNotFoundException异常
            throw new UserNotFoundException("用户数据不存在");
        }
// 从查询结果中取出盐值
        String salt = result.getSalt();
// 将参数oldPassword结合盐值加密，得到oldMd5Password
        String oldMd5Password = getMd5Password(oldPassword, salt);
// 判断查询结果中的password与oldMd5Password是否不一致
        if (!result.getPassword().contentEquals(oldMd5Password)) {
// 是：抛出PasswordNotMatchException异常
            throw new PasswordNotMatchException("原密码错误");
        }
// 将参数newPassword结合盐值加密，得到newMd5Password
        String newMd5Password = getMd5Password(newPassword, salt);
// 创建当前时间对象
        Date now = new Date();
// 调用userMapper的updatePasswordByUid()更新密码，并获取返回值
        Integer rows = userMapper.updatePasswordByUid(uid, newMd5Password, username,
                now);
// 判断以上返回的受影响行数是否不为1
        if (rows != 1) {
// 是：抛出UpdateException异常
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }


    }

    @Override
    public User getByUid(Integer uid) {
        // 调用userMapper的findByUid()方法，根据参数uid查询用户数据
        User result = userMapper.findByUid(uid);
// 判断查询结果是否为null
        if (result == null) {
// 是：抛出UserNotFoundException异常
            throw new UserNotFoundException("用户数据不存在");
        }
// 判断查询结果中的isDelete是否为1
        if (result.getIsDelete().equals(1)) {
// 是：抛出UserNotFoundException异常
            throw new UserNotFoundException("用户数据不存在");
        }
// 创建新的User对象
        User user = new User();
// 将以上查询结果中的username/phone/email/gender封装到新User对象中
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
// 返回新的User对象
        return user;
    }
    @Override
    public void changeInfo(Integer uid, String username, User user) {

        // 调用userMapper的findByUid()方法，根据参数uid查询用户数据

        User result = userMapper.findByUid(uid);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException异常
            throw new UserNotFoundException("用户数据不存在");
        }
          // 判断查询结果中的isDelete是否为1
        if (result.getIsDelete().equals(1)) {

            // 是：抛出UserNotFoundException异常
            throw new UserNotFoundException("用户数据不存在");
        }

          // 向参数user中补全数据：uid
        user.setUid(uid);
        // 向参数user中补全数据：modifiedUser(username)
        user.setModifiedUser(username);
        // 向参数user中补全数据：modifiedTime(new Date())
        user.setModifiedTime(new Date());

        // 调用userMapper的updateInfoByUid(User user)方法执行修改，并获取返回值
        Integer rows = userMapper.updateInfoByUid(user);
        // 判断以上返回的受影响行数是否不为1
        if (rows != 1) {

            // 是：抛出UpdateException异常
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }

    }


  //文档8 ==》上传用户头像

    @Override
    public void changeAvatar(Integer uid, String username, String avatar) {


        // 调用userMapper的findByUid()方法，根据参数uid查询用户数据
        User result = userMapper.findByUid(uid);
// 检查查询结果是否为null
        if (result == null) {
// 是：抛出UserNotFoundException
            throw new UserNotFoundException("用户数据不存在");
        }
// 检查查询结果中的isDelete是否为1
        if (result.getIsDelete().equals(1)) {
// 是：抛出UserNotFoundException
            throw new UserNotFoundException("用户数据不存在");
        }
// 创建当前时间对象
        Date now = new Date();
// 调用userMapper的updateAvatarByUid()方法执行更新，并获取返回值
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, now);
// 判断以上返回的受影响行数是否不为1
        if (rows != 1) {
// 是：抛出UpdateException
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }

    }


}
