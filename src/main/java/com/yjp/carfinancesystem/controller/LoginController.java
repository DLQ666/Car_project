package com.yjp.carfinancesystem.controller;

import com.yjp.carfinancesystem.pojo.Usertable;
import com.yjp.carfinancesystem.service.UsertableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *@program: car-finance-system
 *@description:
 *@author: Hasee
 *@create: 2021-04-14 15:16
 */
@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UsertableService usertableService;

    /**
     * 来登录页
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {

        return "login";
    }

    @PostMapping("/login")
    public String indexPage(Usertable user, HttpSession httpSession, Model model) {
        Integer jobNumber = user.getJobNumber();
        Usertable usertable = usertableService.login(user);
        if (usertable == null) {
            model.addAttribute("msg", "账号密码错误！！！");
            return "login";
        }
        if (usertable.getPassword().equals(user.getPassword()) && usertable.getUsertype().equals("老板")) {
            //把登陆成功的用户保存起来====老板登陆
            httpSession.setAttribute("loginRootUser", usertable);
            //登录成功重定向到 root.html；；重定向防止表单重复提交
            return "redirect:/root.html";
        } else if (usertable.getPassword().equals(user.getPassword()) && usertable.getUsertype().equals("管理人员")) {
            //把登陆成功的用户保存起来====管理人员登陆
            httpSession.setAttribute("loginAdminUser", usertable);
            //登录成功重定向到 root.html；；重定向防止表单重复提交
            return "redirect:/admin.html";
        } else if (usertable.getPassword().equals(user.getPassword()) && usertable.getUsertype().equals("销售人员")) {
            //把登陆成功的用户保存起来====销售人员登陆
            httpSession.setAttribute("loginSaleUser", usertable);
            //登录成功重定向到 root.html；；重定向防止表单重复提交
            return "redirect:/sale.html";
        } else {
            model.addAttribute("msg", "账号密码错误！！！");
            //回到登录页
            return "login";
        }
    }

    /**
     * 去 root 页面
     * @return
     */
    @GetMapping("/root.html")
    public String mainPage(HttpSession httpSession,Model model) {
        log.info("当前方式是：{}", "mainPage");
        Object loginRootUser = httpSession.getAttribute("loginRootUser");
        if (loginRootUser == null){
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        //是否登陆，    采用拦截器  过滤器
        return "root";
    }

    @GetMapping("/admin.html")
    public String adminPage(HttpSession httpSession,Model model) {
        log.info("当前方式是：{}", "mainPage");
        Object loginAdminUser = httpSession.getAttribute("loginAdminUser");
        if (loginAdminUser == null){
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        //是否登陆，    采用拦截器  过滤器
        return "admin";
    }

    @GetMapping("/sale.html")
    public String salePage(HttpSession httpSession,Model model) {
        log.info("当前方式是：{}", "mainPage");
        Object loginSaleUser = httpSession.getAttribute("loginSaleUser");
        if (loginSaleUser == null){
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        //是否登陆，    采用拦截器  过滤器
        return "sale";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        if (httpSession.getAttribute("loginRootUser") != null){
            httpSession.removeAttribute("loginRootUser");
        }
        if (httpSession.getAttribute("loginAdminUser") != null){
            httpSession.removeAttribute("loginAdminUser");
        }
        if (httpSession.getAttribute("loginSaleUser") != null){
            httpSession.removeAttribute("loginSaleUser");
        }
        //回到登录页
        return "login";
    }
}
