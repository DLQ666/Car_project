package com.yjp.carfinancesystem.config;

import com.yjp.carfinancesystem.interceptor.LoginInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *@author: Hasee
 *@create: 2021-03-31 12:40
 *  1、编写一个拦截器实现HandlerInterceptor接口
 *  2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 *  3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //所有请求都会被拦截
                .excludePathPatterns("/","/login","/assets/**"); //放行的请求
    }
}
