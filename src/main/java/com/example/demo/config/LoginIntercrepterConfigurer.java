package com.example.demo.config;

import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


/**
 * 处理拦截器的注册
 */

@Configuration//用于加载当前的拦截器
public class LoginIntercrepterConfigurer implements WebMvcConfigurer {
    /**
     * 配置拦截器
     * @param registry */
    @Override
    public  void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor = new LoginInterceptor();

        List<String> patterns = new ArrayList<>();

        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
      //  patterns.add("/web/abstract.html");
        patterns.add("/web/b.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/us/re");
        patterns.add("/us/xun");

        patterns.add("/us/delete");
        patterns.add("/us/get");
        patterns.add("/aa/add");
        patterns.add("/ad/a");

//完成拦截器的注册
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);//表示要拦截的 url 是什么
    }

}
