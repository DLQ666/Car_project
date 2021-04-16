package com.yjp.carfinancesystem.controller;


import com.yjp.carfinancesystem.pojo.Carmodel;
import com.yjp.carfinancesystem.pojo.Motortype;
import com.yjp.carfinancesystem.pojo.Usertable;
import com.yjp.carfinancesystem.service.CarmodelService;
import com.yjp.carfinancesystem.service.MotortypeService;
import com.yjp.carfinancesystem.service.UsertableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 车辆型号表 前端控制器
 * </p>
 *
 * @author yjp
 * @since 2021-04-14
 */
@Controller
public class CarmodelController {

    @Autowired
    private CarmodelService carmodelService;
    @Autowired
    private MotortypeService motortypeService;

    //来到车辆添加页面
    @GetMapping("/addCar")
    public String toAddPage(Model model){
        //来到添加页面,查出所有型号，在页面显示
        List<Motortype> motortypeList = motortypeService.list();
        model.addAttribute("motortypeList",motortypeList);
        return "car/add";
    }

    @PostMapping("/car")
    public String addEmp(Carmodel carmodel){
        if (carmodel != null){
            carmodelService.save(carmodel);
        }
        System.out.println("添加成功");
        return "redirect:/adminCarInfo.html";
    }

    //来到修改页面，查出当前车辆，在页面回显
    @GetMapping("/car/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Carmodel carmodel = carmodelService.getById(id);
        model.addAttribute("car",carmodel);
        //来到添加页面,查出所有部门，在页面显示
        List<Motortype> motortypeList = motortypeService.list();
        model.addAttribute("motortypeList",motortypeList);
        //回到修改页面（add是修改添加二合一）
        return "car/add";
    }

    //车辆修改
    @PutMapping("/car")
    public String updateEmp(Carmodel carmodel, HttpSession httpSession){
        carmodelService.updateById(carmodel);
        return "redirect:/adminCarInfo.html";
    }

    //车辆删除
    @DeleteMapping("/car/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        carmodelService.removeById(id);
        return "redirect:/adminCarInfo.html";
    }
}

