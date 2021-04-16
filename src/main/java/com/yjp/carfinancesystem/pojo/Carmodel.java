package com.yjp.carfinancesystem.pojo;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 车辆型号表
 * </p>
 *
 * @author yjp
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Carmodel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String carType;
    /**
     * 型号的名字
     */
    private String modelName;

    /**
     * 库存数量
     */
    private Integer modelNum;

    /**
     * 进价
     */
    private BigDecimal purPrice;

    /**
     * 售价
     */
    private BigDecimal selPrice;


}
