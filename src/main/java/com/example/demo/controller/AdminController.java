package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Score;
import com.example.demo.service.IAdminService;
import com.example.demo.service.IScoreService;
import com.example.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("ad")
public class AdminController extends  BaseController{

    @Autowired
    private IAdminService iAdminService;
    @RequestMapping("a")
    //@ResponseBody//表示此方法的响应结果以 json 格式进行数据的响应到前端
    public JsonResult <Void> add(Admin admin) {
        //创建响应结果对象
//创建响应结果对象
        //调用业务对象执行添加
        iAdminService.add(admin);
        //响应成功
        return new JsonResult < Void >(ok);

    }
    //查询
    @GetMapping("x")
    public List < Admin > xun() {
        //通过 astract 参数来获取传递过来的 id,word....

        return iAdminService.findAll();
    }





}
