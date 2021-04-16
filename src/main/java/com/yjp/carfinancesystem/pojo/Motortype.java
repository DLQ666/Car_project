package com.yjp.carfinancesystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 车辆的分类表
 * </p>
 *
 * @author yjp
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Motortype implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类别的名字
     */
    private String typeName;

    /**
     * 型号数量
     */
    private Integer number;


}
