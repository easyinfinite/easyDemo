package com.staging.base.aspect;


import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述: 记录程序时间的切面
 *
 * @param:
 * @return: com.staging.base.aspect.RuntimeMethod
 * @author: chenyunxuan
 * @date: 2019-12-02 21:52
 */
@Aspect
@Component
@Configuration
@Log4j2
public class RuntimeMethod {
    /**
     * 定义程序开始时长
     */
    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Pointcut("@annotation(com.staging.base.aspect.Runtime)")
    private void aopPoint() {
    }

    /**
     *
     * 功能描述: 环绕通知
     *
     * @param: [joinPoint]
     * @return: com.staging.base.aspect.RuntimeMethod
     * @author: chenyunxuan
     * @date: 2019-12-02 22:07
     */
    @Around("aopPoint()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取目标：类名、方法名
        String clazzName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();


        // 计算时间逻辑
        startTime.set(System.currentTimeMillis());
        // 调用目标方法
        Object result = joinPoint.proceed();
        log.info("方法路径为:{}/{}()", clazzName, methodName);
        log.info("处理时间为:{}s", (System.currentTimeMillis() - startTime.get()) / (1000 * 1.0));


        //打印请求体
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("请求地址:{}," +
                 "请求方式:{}," +
                 "请求类方法:{}," +
                 "请求类方法参数:{}," +
                 "RemoteHost:{}," +
                 "Content-type:{}," +
                 "User-Agent:{}",
                 request.getRequestURL(),
                 request.getMethod(),
                 joinPoint.getSignature(),
                 request.getRemoteHost(),
                 request.getHeader("Content-type"),
                 request.getHeader("User-Agent"));
    }

}
