package com.example.demo.service;

import com.example.demo.entity.User;


//业务层接口


/** 处理用户数据的业务层接口 */
public interface IUserService {

    /**
     * 用户注册
     * @param user 用户数据
     */

    void reg(User user);

    /**
     * 用户登录方法
     * @param username 用户名
     * @param password 密码
     * @return 登录成功的用户数据
     */
    User login(String username,String password);


    //文档7
    //在IUserService中添加changePassword(Integer uid, String username, String oldPassword, String
    //newPassword)抽象方法。===》在UserServiceImpl类中实现changePassword()抽象方法
    /**
     * 修改密码
     * @param uid 当前登录的用户id
     * @param username 用户名
     * @param oldPassword 原密码
     * @param newPassword 新密码
     */
     void changePassword(Integer uid, String username, String oldPassword,
                               String newPassword);

    /**
     * 获取当前登录的用户的信息
     * @param uid 当前登录的用户的id
     * @return 当前登录的用户的信息
     */
    User getByUid(Integer uid);

    /**
     * 修改用户资料
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @param user 用户的新的数据
     */
    void changeInfo(Integer uid, String username, User user);


    //文档8
    /**
     * 修改用户头像==>无返回值
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @param avatar 用户的新头像的路径
     */
    //在IUserService中添加changeAvatar(Integer uid, String username, String avatar)抽象方法。==》
    //在UserServiceImpl类中实现changeAvatar(
    void changeAvatar(Integer uid, String username, String avatar);

}
