package com.yjp.carfinancesystem.pojo.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *@program: car-finance-system
 *@description:
 *@author: Hasee
 *@create: 2021-04-15 13:36
 */
@Data
public class SaleProfitsVo {

    /**
     * 日期
     */
    private LocalDate sdate;

    /**
     * 销售量
     */
    private Integer saleNum;

    private BigDecimal profits;
}
