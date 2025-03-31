package com.example.demo.controller;


import com.example.demo.controller.ex.*;
import com.example.demo.service.adex.AdminException;
import com.example.demo.service.adex.tjException;
import com.example.demo.service.aex.InsException;
import com.example.demo.service.aex.NotException;
import com.example.demo.service.aex.WordException;
import com.example.demo.service.aex.upException;
import com.example.demo.service.ex.*;

import com.example.demo.service.sex.SjException;
import com.example.demo.service.sex.SporterDuplicateException;
import com.example.demo.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * 控制类的基类
 */
@Controller
public class BaseController {
    /**
     * 操作成功的状态码
     */
    public static final int ok = 200;
    /**
     * handleException：请求处理方法，这个方法的返回值就是需要传递给前端的数据
     * @ExceptionHandler：
     * 自动将异常对象传递给此方法的参数列表上
     * 当前项目中产生了异常，被统一拦截到此方法中，这个方法此时就充当的是请求处理方法，方
    法的返回值直接给前端
     */
    @ExceptionHandler(ServiceException.class)//用于统一处理抛出的异常

    public JsonResult<Void> handleException(Throwable e){

        JsonResult<Void> result = new JsonResult<Void>(e);

        if (e instanceof UsernameDuplicateException)
        {
//用户名被占
      result.setState(4000);
     // result.setMessage("用户名已经被占用");
        }else if (e instanceof InsertException){
            result.setState(5000);
          //  result.setMessage("注册失败，请联系系统管理员");
        }
        else if (e instanceof UpdateException) {

            result.setState(5001);
       }



        //文档5==>>BaseController 类的处理异常的方法中，添加这两个
        //分支进行处理
        else if(e instanceof UserNotFoundException){
            result.setState(4001);
            //result.setMessage("用户数据不存在");
        }else if (e instanceof PasswordNotMatchException){
            result.setState(4002);
          //  result.setMessage("密码错误！");
        }


        //文档7===》在用户修改密码的业务中抛出了新的UpdateException异常，需要在BaseController类中进行处理。
//   ====》// result.setMessage("用户名已经被占用");-----》result.setMessage("密码错误！");
//  else if (e instanceof UpdateException) {
//
//            result.setState(5001);
//       }

///文档8
        else if (e instanceof InsertException) {
            result.setState(5000);
        } else if (e instanceof UpdateException) {
            result.setState(5001);
        } else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }

        //题目异常
        else if(e instanceof WordException){
            result.setState(6005);
        } else if(e instanceof InsException){
            result.setState(6007);
        }

        //编辑异常

        else if (e instanceof upException) {
            result.setState(6008);
        } else if (e instanceof NotException) {
            result.setState(6009);

            //添加成绩
        }else if (e instanceof SjException){
            result.setState(7000);
            //  result.setMessage("注册失败，请联系系统管理员");
        }
        else if (e instanceof SporterDuplicateException) {
            result.setState(7001);


        //       //管理员添加tj
                }else if (e instanceof tjException){
                    result.setState(7003);
                    //  result.setMessage("注册失败，请联系系统管理员");
                }
                else if (e instanceof AdminException) {
                    result.setState(7004);
                }





        return result;
    }


    //文档6
    /**
     * 获取 session 对象的 uid
     * @param session session 对象
     * @return 当前登录的用户的 uid 值
     */
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 获取 session 对象的 username * @param session session
     * @return 当前登录用户的用户名
     */
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }

//   protected final Integer getidSession(HttpSession session) {
//        return  Integer.valueOf(session.getAttribute("id").toString());
//    }

    final    Integer getidSession(HttpSession session) {
    return  Integer.valueOf(session.getAttribute("id").toString());
}

    /**
     * 获取 session 对象
     * @return
     */
    protected final String findAll(HttpSession session){
        return session.getAttribute("id,word,anwser,diff,num").toString();
    }


}
