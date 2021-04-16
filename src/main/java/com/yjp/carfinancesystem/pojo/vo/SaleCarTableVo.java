package com.yjp.carfinancesystem.pojo.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *@program: car-finance-system
 *@description:
 *@author: Hasee
 *@create: 2021-04-15 15:05
 */
@Data
public class SaleCarTableVo {

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

    private String carType;

    /**
     * 型号的名字
     */
    private String modelName;

    /**
     * 进价
     */
    private BigDecimal purPrice;

    /**
     * 销售量
     */
    private Integer snum;

    /**
     * 销售额
     */
    private BigDecimal smoney;

    /**
     * 日期
     */
    private LocalDate sdate;

    private BigDecimal profits;

    private BigDecimal royalties;

    private BigDecimal royaltiesRate = new BigDecimal(0.05);

    private BigDecimal salary = new BigDecimal(8000);
}
