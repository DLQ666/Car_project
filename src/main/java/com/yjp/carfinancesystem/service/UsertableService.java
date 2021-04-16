package com.yjp.carfinancesystem.service;

import com.yjp.carfinancesystem.pojo.Usertable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 数据库管理员表 服务类
 * </p>
 *
 * @author yjp
 * @since 2021-04-14
 */
public interface UsertableService extends IService<Usertable> {

    Usertable login(Usertable user);
}
