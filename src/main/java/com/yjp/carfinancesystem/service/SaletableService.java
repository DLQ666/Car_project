package com.yjp.carfinancesystem.service;

import com.yjp.carfinancesystem.pojo.Saletable;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yjp.carfinancesystem.pojo.Usertable;
import com.yjp.carfinancesystem.pojo.vo.SaleCarInfoVo;

/**
 * <p>
 * 销售表 服务类
 * </p>
 *
 * @author yjp
 * @since 2021-04-14
 */
public interface SaletableService extends IService<Saletable> {

    void saveSaleinfo(SaleCarInfoVo saleCarInfoVo, Usertable usertable);

}
