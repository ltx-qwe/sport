package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
//持久层接口



public interface UserMapper {
    /**
     * 插入用户的数据
     * @param user 用户的数据
     * @return 受影响的行数（增删改都有受影响的行数作为范围值，可以根据返回
    值判断是否执行成功）
     */
    Integer insert(User user);
    //通过插入后影响的行数来判断是否插入成功，因此返回值定义为 integer
    /**
     * 根据用户明来查询用户的数据
     * @param username 用户名
     * @return 如果找到对应的用户则返回这个用户的数据，如果没有找到则返回 null
    值
     */
    User findByUserName(String username);

//    文档7
    //在UserMapper接口添加updatePasswordByUid(Integer uid,String password,String
    //modifiedUser,Date modifiedTime)抽象方法。
    //用注解来简化xml配置时，@Param注解的作用是给参数命名，参数命名后就能根据名字得到参数
    //值，正确的将参数传入sql语句中。@Param("参数名")注解中的参数名需要和sql语句中的#{参数
    //名}的参数名保持一致
    /**
     * 根据uid更新用户的密码
     * @param uid 用户的id
     * @param password 新密码
     * @param modifiedUser 最后修改执行人
     * @param modifiedTime 最后修改时间
     * @return 受影响的行数
     */
    Integer updatePasswordByUid(
            @Param("uid") Integer uid,
            @Param("password") String password,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);
    /**
     * 根据用户id查询用户数据
     * @param uid 用户id
     * @return 匹配的用户数据，如果没有匹配的用户数据，则返回null
     */
    User findByUid(Integer uid);


    //文档7

    /**
     * 根据uid更新用户资料
     * @param user 封装了用户id和新个人资料的对象
     * @return 受影响的行数
     */
    Integer updateInfoByUid(User user);

    /**
     * 根据uid更新用户的头像
     * @param uid 用户的id
     * @param avatar 新头像的路径
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    Integer updateAvatarByUid(
            @Param("uid") Integer uid,
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

}

