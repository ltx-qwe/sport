package com.example.demo.service;

import com.example.demo.entity.Admin;

import com.example.demo.service.adex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminServiceTests {
    @Autowired
    private IAdminService iAdminService;

    @Test
    public void add(){
        try {
            Admin admin = new Admin();

            admin.setGlname("wang");
            iAdminService .add(admin);

            System.out.println("ok");
        }catch (ServiceException e){
//获取类的对象，再获取类的名称
            System.out.println("添加失败！"+e.getClass().getSimpleName());
//获取类的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    //查询

    @Test
    public void findAll(){
        try {
            Integer id= 1;
            iAdminService.findAll();
            System.out.println("ok");
        }catch (ServiceException e){
//获取类的对象，再获取类的名称
            System.out.println("查询失败！"+e.getClass().getSimpleName());
//获取类的具体描述信息
            System.out.println(e.getMessage());
        }
    }

}


