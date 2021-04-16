package com.yjp.carfinancesystem.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *@program: SpringBoot2
 *@description: 登录检查
 *@author: Hasee
 *@create: 2021-03-31 12:18
 *   登录检查
 *   1、配置好拦截器要拦截哪些请求
 *   2、把这些配置放在容器中
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("拦截的路径：{}", requestURI);
        HttpSession session = request.getSession();
        Object loginRootUser = session.getAttribute("loginRootUser");
        if (loginRootUser != null){
            return true;
        }
        Object loginAdminUser = session.getAttribute("loginAdminUser");
        if (loginAdminUser != null){
            return true;
        }
        Object loginSaleUser = session.getAttribute("loginSaleUser");
        if (loginSaleUser != null){
            return true;
        }

        request.setAttribute("msg", "请先登陆！！！");
        //response.sendRedirect("/");
        System.out.println("aaaaaaaaaaaaa");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }

    /**
     * 目标方法执行完成以后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行了");
    }

    /**
     * 页面渲染以后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行了");

    }
}
