package com.coin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisPlusConfig
 * @Description: TODO
 * @Author shiyawei
 * @Date 2021/5/6
 * @Version V1.0
 **/
@Configuration
@MapperScan("com.coin.repository.mapper")
public class MybatisPlusConfig {

}