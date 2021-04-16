package com.yjp.carfinancesystem.controller;

import com.yjp.carfinancesystem.mapper.SaletableMapper;
import com.yjp.carfinancesystem.pojo.Applytable;
import com.yjp.carfinancesystem.pojo.Carmodel;
import com.yjp.carfinancesystem.pojo.Usertable;
import com.yjp.carfinancesystem.pojo.vo.SaleCarTableVo;
import com.yjp.carfinancesystem.pojo.vo.SaleInfoVo;
import com.yjp.carfinancesystem.pojo.vo.SaleProfitsVo;
import com.yjp.carfinancesystem.service.ApplytableService;
import com.yjp.carfinancesystem.service.CarmodelService;
import com.yjp.carfinancesystem.service.UsertableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *@program: car-finance-system
 *@description:
 *@author: yjp
 *@create: 2021-04-14 16:33
 */
@Controller
public class AuthController {

    @Autowired
    private UsertableService usertableService;
    @Autowired
    private CarmodelService carmodelService;
    @Autowired
    private SaletableMapper saletableMapper;
    @Autowired
    private ApplytableService applytableService;

    @GetMapping("/personManage.html")
    public String personManage(HttpSession httpSession, Model model) {
        Object loginRootUser = httpSession.getAttribute("loginRootUser");
        Object loginAdminUser = httpSession.getAttribute("loginAdminUser");
        if (loginRootUser == null && loginAdminUser == null) {
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        List<Usertable> list = usertableService.list();
        model.addAttribute("userList", list);
        return "personManage";
    }

    @GetMapping("/adminManage.html")
    public String adminManage(HttpSession httpSession, Model model) {
        Object loginRootUser = httpSession.getAttribute("loginRootUser");
        Object loginAdminUser = httpSession.getAttribute("loginAdminUser");
        if (loginRootUser == null && loginAdminUser == null) {
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        List<Usertable> list = usertableService.list();
        model.addAttribute("userList", list);
        return "adminManage";
    }

    @GetMapping("/rootSale.html")
    public String rootSale(HttpSession httpSession, Model model) {
        Object loginRootUser = httpSession.getAttribute("loginRootUser");
        Object loginAdminUser = httpSession.getAttribute("loginAdminUser");
        if (loginRootUser == null && loginAdminUser == null) {
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        List<SaleInfoVo> saleInfoVos = saletableMapper.selectSaleInfoList();
        model.addAttribute("saleInfoList", saleInfoVos);
        return "rootSale";
    }
    @GetMapping("/adminSale.html")
    public String adminSale(HttpSession httpSession, Model model) {
        Object loginRootUser = httpSession.getAttribute("loginRootUser");
        Object loginAdminUser = httpSession.getAttribute("loginAdminUser");
        if (loginRootUser == null && loginAdminUser == null) {
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        List<SaleInfoVo> saleInfoVos = saletableMapper.selectSaleInfoList();
        model.addAttribute("saleInfoList", saleInfoVos);
        return "adminSale";
    }

    @GetMapping("/carInfo.html")
    public String carInfo(HttpSession httpSession, Model model) {
        Object loginRootUser = httpSession.getAttribute("loginRootUser");
        Object loginAdminUser = httpSession.getAttribute("loginAdminUser");
        if (loginRootUser == null && loginAdminUser == null) {
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        List<Carmodel> list = carmodelService.list();
        model.addAttribute("carList", list);
        return "carInfo";
    }
    @GetMapping("/adminCarInfo.html")
    public String adminCarInfo(HttpSession httpSession, Model model) {
        Object loginRootUser = httpSession.getAttribute("loginRootUser");
        Object loginAdminUser = httpSession.getAttribute("loginAdminUser");
        if (loginRootUser == null && loginAdminUser == null) {
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        List<Carmodel> list = carmodelService.list();
        model.addAttribute("carList", list);
        return "adminCarInfo";
    }
    @GetMapping("/saleCarInfo.html")
    public String saleCarInfo(HttpSession httpSession, Model model) {
        List<Carmodel> list = carmodelService.list();
        model.addAttribute("carList", list);
        return "saleCarInfo";
    }
    @GetMapping("/applyList.html")
    public String applyList(HttpSession httpSession, Model model) {
        Object loginAdminUser = httpSession.getAttribute("loginAdminUser");
        if (loginAdminUser == null) {
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        List<Applytable> applytableList = applytableService.list();
        model.addAttribute("applyList", applytableList);
        return "applyList";
    }

    @GetMapping("/approve.html")
    public String approve(HttpSession httpSession, Model model) {
        Object loginRootUser = httpSession.getAttribute("loginRootUser");
        if (loginRootUser == null) {
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        List<Applytable> list = applytableService.list();
        model.addAttribute("approveList",list);
        return "approve";
    }

    @GetMapping("/applyMoney.html")
    public String applyMoney(HttpSession httpSession, Model model) {
        Object loginAdminUser = httpSession.getAttribute("loginAdminUser");
        if (loginAdminUser == null) {
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        List<Applytable> list = applytableService.list();
        model.addAttribute("approveList",list);
        return "applyMoney";
    }

    @GetMapping("/saleProfits.html")
    public String saleProfits(HttpSession httpSession, Model model) {
        Object loginRootUser = httpSession.getAttribute("loginRootUser");
        if (loginRootUser == null) {
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        List<SaleProfitsVo> saleProfitsVos = saletableMapper.selectSaleProfitsList();
        model.addAttribute("saleProfitsList",saleProfitsVos);
        return "saleProfits";
    }

    @GetMapping("/saleInfo.html")
    public String saleInfo(HttpSession httpSession, Model model) {
        Object loginSaleUser = httpSession.getAttribute("loginSaleUser");
        if (loginSaleUser == null) {
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        List<Carmodel> list = carmodelService.list();
        model.addAttribute("saleCarList",list);
        return "saleInfo";
    }

    @GetMapping("/saleCarTable.html")
    public String saleCarTable(HttpSession httpSession ,Model model){
        Usertable usertable = (Usertable) httpSession.getAttribute("loginSaleUser");
        if (usertable == null) {
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        List<SaleCarTableVo> saleCarTableVos = saletableMapper.selectSaleInfoById(usertable.getJobNumber());
        model.addAttribute("saleCarTableList",saleCarTableVos);
        return "saleCarTable";
    }

    @GetMapping("/royaltiesInfo.html")
    public String royaltiesInfo(HttpSession httpSession ,Model model){
        Usertable usertable = (Usertable) httpSession.getAttribute("loginSaleUser");
        if (usertable == null) {
            model.addAttribute("msg", "没有权限！！！");
            //回到登录页
            return "login";
        }
        List<SaleCarTableVo> royaltiesList = saletableMapper.selectroyaltiesInfoById(usertable.getJobNumber());
        model.addAttribute("royaltiesList",royaltiesList);
        return "royaltiesInfo";
    }

}
