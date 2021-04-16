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
 * 员工表
 * </p>
 *
 * @author yjp
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Stafftable implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 工号
     */
    private Integer staffNum;

    /**
     * 姓名
     */
    private String sname;

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


}
