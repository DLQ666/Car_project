package com.yjp.carfinancesystem.controller;


import com.yjp.carfinancesystem.pojo.Usertable;
import com.yjp.carfinancesystem.service.UsertableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 数据库管理员表 前端控制器
 * </p>
 *
 * @author yjp
 * @since 2021-04-14
 */
@Controller
public class UsertableController {

    @Autowired
    private UsertableService usertableService;

    //来到员工添加页面
    @GetMapping("/addEmp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有部门，在页面显示
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Usertable usertable){
        if (usertable != null){
            usertableService.save(usertable);
        }
        System.out.println("添加成功");
        return "redirect:/personManage.html";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Usertable usertable = usertableService.getById(id);
        model.addAttribute("emp",usertable);
        //来到添加页面,查出所有部门，在页面显示
        //回到修改页面（add是修改添加二合一）
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmp(Usertable usertable, HttpSession httpSession){
        Object loginAdminUser = httpSession.getAttribute("loginAdminUser");
        if (loginAdminUser != null &&usertable.getJobNumber() == 1){
            return "redirect:/personManage.html";
        }
        usertableService.updateById(usertable);
        return "redirect:/personManage.html";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        usertableService.removeById(id);
        return "redirect:/personManage.html";
    }

}

