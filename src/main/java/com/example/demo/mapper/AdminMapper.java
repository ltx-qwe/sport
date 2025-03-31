package com.example.demo.mapper;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Score;

import java.util.List;

public interface AdminMapper {

//添加
    Integer findAdd(Admin admin);

    Score findName(String glname);

    //查询
    List < Admin > findAll();
}
