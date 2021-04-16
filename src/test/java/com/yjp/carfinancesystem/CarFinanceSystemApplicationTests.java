package com.yjp.carfinancesystem;

import com.yjp.carfinancesystem.mapper.CarmodelMapper;
import com.yjp.carfinancesystem.mapper.SaletableMapper;
import com.yjp.carfinancesystem.pojo.Carmodel;
import com.yjp.carfinancesystem.pojo.vo.SaleInfoVo;
import com.yjp.carfinancesystem.pojo.vo.SaleProfitsVo;
import com.yjp.carfinancesystem.service.CarmodelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class CarFinanceSystemApplicationTests {

    @Autowired
    CarmodelService carmodelService;
    @Autowired
    SaletableMapper saletableMapper;

    @Test
    void contextLoads() {
        Carmodel carmodel = carmodelService.getById(1L);
        System.out.println(carmodel);
    }

    @Test
    public void test() {
        List<SaleInfoVo> saleInfoVos = saletableMapper.selectSaleInfoList();
        saleInfoVos.forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<SaleProfitsVo> saleProfitsVos = saletableMapper.selectSaleProfitsList();
        System.out.println(saleProfitsVos);

    }

}
