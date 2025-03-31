package com.example.demo.interceptor;



import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 检测全局 session 对象是否有 uid 数据，如果有则执行，如果没有重定向到登录
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器（url+Controller：映射）
     * @return 如果返回值为 true 表示放行当前的请求，如果为 false 则表示拦截当前
    的请求
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//HttpServletRequest 对象来获取 session 对象
        Object obj = request.getSession().getAttribute("uid");
       // Object id = request.getSession().getAttribute("id");
        if (obj == null){
//说明用户没有登录过系统，则重定向到 login.html 页面
            response.sendRedirect("/web/login.html");
//结束后续的调用
            return false;
        }
//请求放行
        return true;
    }


}
