package com.yjp.carfinancesystem.controller;


import com.yjp.carfinancesystem.mapper.SaletableMapper;
import com.yjp.carfinancesystem.pojo.Saletable;
import com.yjp.carfinancesystem.pojo.Usertable;
import com.yjp.carfinancesystem.pojo.vo.SaleCarInfoVo;
import com.yjp.carfinancesystem.pojo.vo.SaleCarTableVo;
import com.yjp.carfinancesystem.pojo.vo.SaleInfoVo;
import com.yjp.carfinancesystem.service.SaletableService;
import com.yjp.carfinancesystem.service.StafftableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 销售表 前端控制器
 * </p>
 *
 * @author yjp
 * @since 2021-04-14
 */
@Controller
public class SaletableController {

    @Autowired
    private SaletableService saletableService;
    @Autowired
    private SaletableMapper saletableMapper;

    @PostMapping("/saleInfo")
    public String saleInfo(SaleCarInfoVo saleCarInfoVo, HttpSession httpSession, Model model){
        Usertable usertable = (Usertable) httpSession.getAttribute("loginSaleUser");
        if (usertable == null){
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        saletableService.saveSaleinfo(saleCarInfoVo,usertable);
        return "redirect:/saleCarTable.html";
    }
}

