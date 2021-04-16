package com.yjp.carfinancesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yjp.carfinancesystem.pojo.Saletable;
import com.yjp.carfinancesystem.mapper.SaletableMapper;
import com.yjp.carfinancesystem.pojo.Stafftable;
import com.yjp.carfinancesystem.pojo.Usertable;
import com.yjp.carfinancesystem.pojo.vo.SaleCarInfoVo;
import com.yjp.carfinancesystem.service.SaletableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yjp.carfinancesystem.service.StafftableService;
import com.yjp.carfinancesystem.service.UsertableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <p>
 * 销售表 服务实现类
 * </p>
 *
 * @author yjp
 * @since 2021-04-14
 */
@Service
public class SaletableServiceImpl extends ServiceImpl<SaletableMapper, Saletable> implements SaletableService {

    @Autowired
    private StafftableService stafftableService;
    @Autowired
    private UsertableService usertableService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveSaleinfo(SaleCarInfoVo saleCarInfoVo, Usertable usertable) {
        Saletable saletable = new Saletable();
        String carId = saleCarInfoVo.getCarId();
        saletable.setCarId(carId);
        saletable.setStaffNum(usertable.getJobNumber());
        saletable.setSaleName(usertable.getUsername());
        saletable.setSaleDate(LocalDate.now());
        saletable.setTranType(saleCarInfoVo.getTranType());
        saletable.setTurnover(saleCarInfoVo.getTurnover());
        baseMapper.insert(saletable);
        Stafftable stafftable = new Stafftable();
        stafftable.setStaffNum(usertable.getJobNumber());
        stafftable.setSname(usertable.getUsername());
        stafftable.setSnum(saleCarInfoVo.getSnum());
        BigDecimal smoney = saletable.getTurnover().multiply(new BigDecimal(saleCarInfoVo.getSnum()));
        stafftable.setSmoney(smoney);
        stafftable.setSdate(saletable.getSaleDate());
        stafftableService.save(stafftable);
    }
}
