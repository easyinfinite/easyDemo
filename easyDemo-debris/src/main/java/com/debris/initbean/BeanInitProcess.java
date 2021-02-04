package com.debris.initbean;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName: BeanInitProcess
 * @Description 演示bean初始化与销毁方法
 * @Author: chenyunxuan
 * @Date: 2021/2/4 10:03 上午
 * @version: 1.0.0
 **/
@Log4j2
public class BeanInitProcess implements InitializingBean, DisposableBean {

    public BeanInitProcess() {
        log.info("进入构造方法");
    }

    public BeanInitProcess(String name) {
        log.info("进入有参方法");
    }

    static {
        log.info("进入静态代码块");
    }

    @PostConstruct
    private void jdkInitMethod() {
        log.info("进入jdk封装注解 PostConstruct");
    }

    @PreDestroy
    private void jdkDestroyMethod() {
        log.info("进入jdk封装注解 PreDestroy");
    }

    private void initBeanMethod() {
        log.info("进入@bean 注解的 initBean 方法");
    }

    private void destroyBeanMethod() {
        log.info("进入@bean 注解的 destroyBean 方法");
    }

    @Override
    public final void afterPropertiesSet() throws Exception {
        log.info("进入 InitializingBean 接口实现的 afterPropertiesSet 方法");
    }

    @Override
    public final void destroy() throws Exception {
        log.info("进入 DisposableBean 接口实现的 destroy 方法");
    }
}
