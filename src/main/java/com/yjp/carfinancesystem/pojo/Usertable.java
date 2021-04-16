package com.yjp.carfinancesystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 数据库管理员表
 * </p>
 *
 * @author yjp
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Usertable implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    /**
     * 工号
     */
    private Integer jobNumber;

    /**
     * 登录密码
     */
    private Long password;

    /**
     * 管理员类型
     */
    private String usertype;


}
