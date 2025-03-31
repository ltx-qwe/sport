package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 自定义测试类需要声明注解：@SpringBootTest：表示当前的类是一个测试类，不会
 随项目一块打包
 */
@SpringBootTest
public class UserServiceTests {
    // idea 有检测的功能，接口是不能直接创建 Bean
    @Autowired
    private IUserService iUserService;

    /**
     * 单元测试方法：可以单独独立运行，而不需要启动整个项目，可以做单元测试，
     提升代码的测试效率
     * 1、必须被@Test 注解修饰
     * 2、返回值类型必须是 void 类型，否则会报错
     * 3、方法的参数泪飙不指定任何类型
     * 4、方法的访问修饰符必须是 public */
    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("ad");
            user.setPassword("123456");
            iUserService.reg(user);
            System.out.println("ok");
        } catch (ServiceException e) {
//获取类的对象，再获取类的名称
            System.out.println("注册失败！" + e.getClass().getSimpleName());
//获取类的具体描述信息
            System.out.println(e.getMessage());
        }
    }


    //文档5
    @Test
    public void login() {
        try {
            String username = "lower02";
            String password = "123";
            User user = iUserService.login(username, password);
            System.out.println("登录成功！");
        } catch (ServiceException e) {
            System.out.println("登录失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    //文档7
    @Test
    public void changePassword() {
        try {
            Integer uid = 6;
            String username = "test";
            String oldPassword = "888888";
            String newPassword = "123456";
            iUserService.changePassword(uid, username, oldPassword, newPassword);
            System.out.println("密码修改成功！");
        } catch (ServiceException e) {
            System.out.println("密码修改失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getByUid() {
        try {
            Integer uid = 6;
            User user = iUserService.getByUid(uid);
            System.out.println(user);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void changeInfo() {
        try {
            Integer uid = 6;
            String username = "test";
            User user = new User();

            user.setPhone("15512328888");
            user.setEmail("admin03@cy.cn");
            //setGender性别

            user.setGender(2);
            iUserService.changeInfo(uid, username, user);
            System.out.println("OK.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void changeAvatar() {
        try {
            Integer uid = 3;
            String username = "头像管理员";
            String avatar = "/upload/avatar.png";
            iUserService.changeAvatar(uid, username, avatar);
            System.out.println("OK.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
