package com.example.demo.service;


import com.example.demo.entity.Astract;
import com.example.demo.util.JsonResult;
//import com.github.pagehelper.PageInfo;

import java.util.List;

/** 处理用户数据的业务层接口 */
public interface IAstractService {

    /**
     * 添加题目
     * @param// word 用户数据
     */

    void re(Astract astract);


    /**
     * 查询
     * @return
     */
    //查询所有数据


    List<Astract> findAll();
//编辑

 Astract getId(Integer id);

    void change(Integer id,Astract astract);
//删除
  JsonResult < Void > delete(Integer id);

  //  JsonResult< Void> delete();
}
