package com.example.demo.mapper;

import com.example.demo.entity.Astract;
import com.example.demo.entity.User;
import com.example.demo.util.JsonResult;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AstractMapper {


    Integer sert(Astract astract);//通过插入后影响的行数来判断是否插入成功，因此返回值定义为 integer

    Astract findByWord(String word);


//    //查xun 全部题目信息

    /**
     * 查询全部题目
     *
     * @return
     */



    //查询所有数据

    List < Astract > findAll();


    //编辑==>修改

  Astract findId(Integer id);


   Integer updateId(Astract astract);



   Integer deleteId(Integer id);


}