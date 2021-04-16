package com.yjp.carfinancesystem.pojo.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *@program: car-finance-system
 *@description:
 *@author: Hasee
 *@create: 2021-04-14 20:50
 */
@Data
public class SaleInfoVo {

    private Integer id;

    /**
     * 工号
     */
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

    private Integer carId;

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
     * 性别
     */
    private String sex;

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


}
