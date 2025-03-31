package com.example.demo.controller;


import com.example.demo.entity.Astract;
import com.example.demo.service.IAstractService;
import com.example.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;


@RestController //@Controller+@ResponseBody
@RequestMapping("us")//什么样的请求会被拦截到此类中


public class AstractController  extends  BaseController {

    @Autowired
    private IAstractService iAstractService;

    @RequestMapping("re")

    public JsonResult<Void> re(Astract astract) {
     //创建响应结果对象
          //调用业务对象执行添加
            iAstractService.re(astract);
          //响应成功
    return  new JsonResult<Void>(ok);

    }

//查询
    @GetMapping("xun")
    public List < Astract > xun() {
        //通过 astract 参数来获取传递过来的 id,word....
        return iAstractService.findAll();
    }



    @GetMapping("get")
    public JsonResult<Astract> getId(HttpSession session) {
        //从HttpSession对象中获取id
       Integer id = getidSession(session);

// 调用业务对象执行获取数据
       Astract data = iAstractService.getId(id);
// 响应成功和数据
        return new JsonResult< >(ok, data);
    }



    @RequestMapping("change")
    public JsonResult<Void> changeInfo(Astract astract, HttpSession session) {

        //获取id
       Integer id = getidSession(session);

        // 调用业务对象执行修改用户资料
        iAstractService.change(id, astract);
// 响应成功
        return new JsonResult< >(ok);
    }






    //删除
    @PostMapping("delete")
    public JsonResult<Void> del(  HttpSession session) {

        //获取id

        Integer id = getidSession(session);
//        通过 astract 参数来获取传递过来的 id,word....

        return iAstractService.delete(id);

    }

}


