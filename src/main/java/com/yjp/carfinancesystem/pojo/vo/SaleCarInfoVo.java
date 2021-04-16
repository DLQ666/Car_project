package com.yjp.carfinancesystem.pojo.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *@program: car-finance-system
 *@description:
 *@author: Hasee
 *@create: 2021-04-15 14:20
 */
@Data
public class SaleCarInfoVo {

    /**
     * 车辆类型型号id
     */
    private String carId;

    private Integer staffNum;

    /**
     * 销售人员
     */
    private String saleName;

    /**
     * 交易类型
     */
    private String tranType;

    /**
     * 成交额
     */
    private BigDecimal turnover;

    /**
     * 销售量
     */
    private Integer snum;

    /**
     * 销售额
     */
    private BigDecimal smoney;

    /**
     * 销售日期
     */
    private LocalDate saleDate;


}
