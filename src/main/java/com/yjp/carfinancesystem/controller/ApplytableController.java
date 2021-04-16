package com.yjp.carfinancesystem.controller;

import ch.qos.logback.core.util.InvocationGate;
import com.yjp.carfinancesystem.pojo.Applytable;
import com.yjp.carfinancesystem.pojo.Carmodel;
import com.yjp.carfinancesystem.pojo.Motortype;
import com.yjp.carfinancesystem.pojo.Usertable;
import com.yjp.carfinancesystem.service.ApplytableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

/**
 *@program: car-finance-system
 *@description:
 *@author: yjp
 *@create: 2021-04-14 22:44
 */
@Controller
public class ApplytableController {

    @Autowired
    private ApplytableService applytableService;

    @PutMapping("/approve/{id}")
    public String updateStatus(@PathVariable("id") Integer id, HttpSession httpSession, Model model) {
        Object loginRootUser = httpSession.getAttribute("loginRootUser");
        if (loginRootUser == null) {
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        Applytable applytable = applytableService.getById(id);
        if (applytable.getApproval().equals("审批中")) {
            applytable.setApproval("已审批");
        }else if (applytable.getApproval().equals("已审批")){
            applytable.setApproval("审批中");
        }
        applytableService.updateById(applytable);
        return "redirect:/approve.html";
    }

    @GetMapping("/applyMoney")
    public String toAddPage(Model model){
        return "applyMoney";
    }

    @PostMapping("/apply")
    public String addEmp(Applytable applytable,HttpSession httpSession){
        Usertable usertable = (Usertable) httpSession.getAttribute("loginAdminUser");
        if (applytable != null){
            Integer jobNumber = usertable.getJobNumber();
            applytable.setAname(jobNumber);
            applytable.setApproval("审批中");
            applytable.setSdate(LocalDate.now());
            applytableService.save(applytable);
        }
        System.out.println("添加成功");
        return "redirect:/applyList.html";
    }
}
