package com.yjp.carfinancesystem.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 销售表
 * </p>
 *
 * @author yjp
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Saletable implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer staffNum;
    /**
     * 销售人员
     */
    private String saleName;

    /**
     * 销售日期
     */
    private LocalDate saleDate;

    /**
     * 车辆类型型号id
     */
    private String carId;

    /**
     * 交易类型
     */
    private String tranType;

    /**
     * 成交额
     */
    private BigDecimal turnover;


}
