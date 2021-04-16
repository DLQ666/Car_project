package com.yjp.carfinancesystem.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *@program: car-finance-system
 *@description:
 *@author: yjp
 *@create: 2021-04-14 14:57
 */
@MapperScan("com.yjp.carfinancesystem.mapper")
@ComponentScan({"com.yjp.carfinancesystem"})
@Configuration
public class MybatisConfig {
}
