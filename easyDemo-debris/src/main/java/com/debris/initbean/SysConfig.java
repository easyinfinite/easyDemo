package com.debris.initbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: SysConfig
 * @Description //系统配置基类
 * @Author: chenyunxuan
 * @Date: 2021/2/4 10:26 上午
 * @version: 1.0.0
 **/
@Configuration
public class SysConfig {

    /**
     * @description: 初始化bean
     * @author: chenyunxuan
     * @updateTime: 2021/2/4 11:01 上午
     */
    @Bean(initMethod = "initBeanMethod", destroyMethod = "destroyBeanMethod")
    public BeanInitProcess getBeanInitProcessInstance() {
        return new BeanInitProcess();
    }
}
