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
 * 收益表
 * </p>
 *
 * @author yjp
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Profittable implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 日期
     */
    private LocalDate proDate;

    /**
     * 销售量
     */
    private Integer salesNum;

    /**
     * 收益
     */
    private BigDecimal profit;


}
