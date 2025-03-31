package com.example.demo.mapper;


import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * 自定义测试类需要声明注解：@SpringBootTest：表示当前的类是一个测试类，不会
 随项目一块打包
 */

@SpringBootTest
public class UserMapperTests {

    // idea 有检测的功能，接口是不能直接创建 Bean
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tom1");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }
    @Test
    public void findByUserName(){

        User user = userMapper.findByUserName("tom1");
        System.out.println(user);

    }

//文档7

    @Test
    public void updatePasswordByUid() {
        Integer uid = 2;
        String password = "123456";
        String modifiedUser = "超级管理员";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }
    @Test
    public void findByUid() {
        Integer uid = 7;
        User result = userMapper.findByUid(uid);
        System.out.println(result);
    }

    @Test
    public void updateInfoByUid() {
        User user = new User();
        user.setUid(20);
        user.setPhone("17858802222");
        user.setEmail("admin@cy.com");
        user.setGender(1);
        user.setModifiedUser("系统管理员");
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        System.out.println("rows=" + rows);
    }


    //文档8
    @Test
    public void updateAvatarByUid() {
        Integer uid = 3;
        String avatar = "/upload/avatar.png";
        String modifiedUser = "超级管理员";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, modifiedUser,
                modifiedTime);
        System.out.println("rows=" + rows);
    }

}
