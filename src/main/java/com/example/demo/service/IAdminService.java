package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Score;

import java.util.List;

public interface IAdminService {
    void add(Admin admin);


    //获取所有
    List < Admin > findAll();
}
