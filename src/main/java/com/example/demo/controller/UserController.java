package com.example.demo.controller;


import com.example.demo.controller.ex.*;

import com.example.demo.entity.User;

import com.example.demo.service.IUserService;

import com.example.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@Controller//用于指示 Spring 类的实例是一个控制器。表示当前类交给 spring 管理


@RestController //@Controller+@ResponseBody
@RequestMapping("users")//什么样的请求会被拦截到此类中


public class UserController extends  BaseController{

    @Autowired
    private IUserService iUserService;

    @RequestMapping("reg")
    //@ResponseBody//表示此方法的响应结果以 json 格式进行数据的响应到前端
    public JsonResult<Void> reg(User user){


        iUserService.reg(user);
        return new JsonResult<Void>(ok);
    }


        //文档5==》1.在 UserController 类中添加处理登录请求的 login(String username, String password)方
        @RequestMapping("login")
        public JsonResult<User> login(String username, String password, HttpSession session){
//调用业务对象的方法执行登录，并获取返回值
            User data = iUserService.login(username, password);

            //向 session 对象中完成用户数据的绑定（session 是全局的）
            session.setAttribute("uid",data.getUid());
            session.setAttribute("username",data.getUsername());
           //将以上返回值和状态码 ok 封装到响应结果中并返回

            //将以上返回值和状态码 ok 封装到响应结果中并返回
            return new JsonResult<User>(ok,data);


    }
    //文档7==》.在UserController类中添加处理请求的changePassword(String oldPassword, String newPassword,
    //HttpSession session)方法。


    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword,
                                           HttpSession session) {
        // 调用session.getAttribute("")获取uid和username
        Integer uid = getUidFromSession(session);

        String username = getUsernameFromSession(session);
          // 调用业务对象执行修改密码
        iUserService.changePassword(uid, username, oldPassword, newPassword);
         // 返回成功
        return new JsonResult<Void>(ok);
    }



      //处理获取用户信息请求
      //1.在UserController类中添加处理请求的getByUid()方法，并导入
       //org.springframework.web.bind.annotation.GetMapping包。

    @GetMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
     // 从HttpSession对象中获取uid
        Integer uid = getUidFromSession(session);
     // 调用业务对象执行获取数据
        User data = iUserService.getByUid(uid);
      // 响应成功和数据
        return new JsonResult<>(ok, data);
    }


    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
    // 从HttpSession对象中获取uid和username

        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);

    // 调用业务对象执行修改用户资料
        iUserService.changeInfo(uid, username, user);
    // 响应成功
        return new JsonResult<>(ok);
    }

//文档8
    /** 头像文件大小的上限值(10MB) */
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;
    /** 允许上传的头像的文件类型 */
    public static final List<String> AVATAR_TYPES = new ArrayList<String>();
    /** 初始化允许上传的头像的文件类型 */
    static {
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/bmp");
        AVATAR_TYPES.add("image/gif");
    }
@PostMapping("change_avatar")
public JsonResult<String> changeAvatar(@RequestParam("file") MultipartFile file,
                                       HttpSession session ) {
    // 判断上传的文件是否为空
    if (file.isEmpty()) {
    // 是：抛出异常
        throw new FileEmptyException("上传的头像文件不允许为空");
    }
    // 判断上传的文件大小是否超出限制值
    if (file.getSize() > AVATAR_MAX_SIZE) { // getSize()：返回文件的大小，以字节为单位
        // 是：抛出异常
        throw new FileSizeException("不允许上传超过" + (AVATAR_MAX_SIZE / 1024) + "KB的头像文件");
    }
    // 判断上传的文件类型是否超出限制
    String contentType = file.getContentType();
     // public boolean list.contains(Object o)：当前列表若包含某元素，返回结果为true；若不包含该元素，返回结果为false。
    if (!AVATAR_TYPES.contains(contentType)) {
     // 是：抛出异常
        throw new FileTypeException("不支持使用该类型的文件作为头像，允许的文件类型：\n"
                + AVATAR_TYPES);
    }
      // 获取当前项目的绝对磁盘路径
    String parent = session.getServletContext().getRealPath("upload");
      // 保存头像文件的文件夹

    File dir = new File(parent);
    if (!dir.exists()) {
        dir.mkdirs();
    }
    // 保存的头像文件的文件名
    String suffix = "";

    String originalFilename = file.getOriginalFilename();//获取原始文件名

    int beginIndex = originalFilename.lastIndexOf(".");//最后出现的位置索引

    if (beginIndex > 0) {
        suffix = originalFilename.substring(beginIndex);
    }
    //UUID生成工具将生成的字符串作为文件名

    String filename = UUID.randomUUID().toString() + suffix;


          // 创建文件对象，表示保存的头像文件

    File dest = new File(dir, filename);
        // 执行保存头像文件
    try {
        file.transferTo(dest);

    } catch (IllegalStateException e) {
       // 抛出异常
        throw new FileStateException("文件状态异常，可能文件已被移动或删除");
    } catch (IOException e) {
          // 抛出异常
        throw new FileUploadIOException("上传文件时读写错误，请稍后重尝试");
    }
       // 头像路径
    String avatar = "/upload/" + filename;
        // 从Session中获取uid和username
    Integer uid = getUidFromSession(session);
    String username = getUsernameFromSession(session);
       // 将头像写入到数据库中
    iUserService.changeAvatar(uid, username, avatar);
        // 返回成功头像路径
    return new JsonResult<String>(ok, avatar);
}
}
