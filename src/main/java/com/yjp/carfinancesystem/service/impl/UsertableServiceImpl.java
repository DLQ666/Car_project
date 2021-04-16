package com.yjp.carfinancesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yjp.carfinancesystem.pojo.Usertable;
import com.yjp.carfinancesystem.mapper.UsertableMapper;
import com.yjp.carfinancesystem.service.UsertableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据库管理员表 服务实现类
 * </p>
 *
 * @author yjp
 * @since 2021-04-14
 */
@Service
public class UsertableServiceImpl extends ServiceImpl<UsertableMapper, Usertable> implements UsertableService {

    @Override
    public Usertable login(Usertable user) {
        if (user.getUsername() == null){
            return null;
        }
        QueryWrapper<Usertable> usertableQueryWrapper = new QueryWrapper<>();
        usertableQueryWrapper.eq("username", user.getUsername());
        return baseMapper.selectOne(usertableQueryWrapper);
    }
}
