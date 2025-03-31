package com.example.demo.service.impl;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Score;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.service.IAdminService;
import com.example.demo.service.adex.tjException;
import com.example.demo.service.adex.AdminException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//Service 注解，将当前类的对象交给 spring 来管理，自动创建类的对象以及对象的维护
public class AdminServiceImpl implements IAdminService{


    @Autowired
    private AdminMapper adminMapper;
    //添加成绩
    @Override
    public void add(Admin admin) {

        String glname = admin.getGlname();
        //调用 findBySportName（name）判断是否被add过
        Score result = adminMapper.findName(glname);

        if (result != null){
            //抛出异常
            throw new AdminException("用户名被占用");
        }
        //执行注册业务功能的实现（rows==1）
        Integer rows = adminMapper.findAdd(admin);
        if (rows != 1){
            throw new tjException("在用户添加过程中产生了未知的异常");
        }

    }






    @Override
    public List < Admin > findAll() {

        return adminMapper.findAll();
    }
}
