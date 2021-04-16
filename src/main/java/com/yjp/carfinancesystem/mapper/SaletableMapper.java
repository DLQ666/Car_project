package com.yjp.carfinancesystem.mapper;

import com.yjp.carfinancesystem.pojo.Saletable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjp.carfinancesystem.pojo.vo.SaleCarTableVo;
import com.yjp.carfinancesystem.pojo.vo.SaleInfoVo;
import com.yjp.carfinancesystem.pojo.vo.SaleProfitsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 销售表 Mapper 接口
 * </p>
 *
 * @author yjp
 * @since 2021-04-14
 */
public interface SaletableMapper extends BaseMapper<Saletable> {

    List<SaleInfoVo> selectSaleInfoList();

    List<SaleCarTableVo> selectSaleInfoById(@Param("id") Integer id);

    List<SaleProfitsVo> selectSaleProfitsList();

    List<Saletable> selectAll();

    List<SaleCarTableVo> selectroyaltiesInfoById(Integer jobNumber);
}
