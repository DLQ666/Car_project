package com.yjp.carfinancesystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *@program: car-finance-system
 *@description:
 *@author: Hasee
 *@create: 2021-04-14 22:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Applytable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer aname;

    private BigDecimal amoney;

    private String reason;

    private String approval;

    private LocalDate sdate;
}
