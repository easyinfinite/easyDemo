package com.staging.base.aspect;


import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import reactor.util.function.Tuple6;
import reactor.util.function.Tuples;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 功能描述: 记录程序时间的切面(目前作用dev环境)
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
@Profile({"dev", "test"})
public class RuntimeMethod {

    private ThreadLocal<Tuple6<String, String, Object[], String, Long, String>> threadLocal = new ThreadLocal<>();

    @Pointcut("execution(* com.staging.business.*.controller.*.*(..))")
    private void aopPoint() {
    }

    /**
     * 功能描述: 前置参数打印
     *
     * @param: [joinPoint]
     * @return: com.staging.base.aspect.RuntimeMethod
     * @author: chenyunxuan
     * @date: 2019-12-02 22:07
     */
    @Before("aopPoint()")
    public void before(JoinPoint joinPoint) throws Throwable {
        //打印请求体
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (null != requestAttributes) {
            loadingThreadLocal(requestAttributes, joinPoint.getArgs());
            log.info("-in- {} {} -{}",
                    threadLocal.get().getT1(),
                    threadLocal.get().getT2(),
                    threadLocal.get().getT6());
            log.info("Method arguments:{} -{}",
                    threadLocal.get().getT3(),
                    threadLocal.get().getT6());
            log.info("Request header:{} -{}",
                    threadLocal.get().getT4(),
                    threadLocal.get().getT6());
        }
    }

    /**
     * 功能描述: 环绕通知
     *
     * @param: [joinPoint]
     * @return: com.staging.base.aspect.RuntimeMethod
     * @author: chenyunxuan
     * @date: 2019-12-02 22:07
     */
    @Around("aopPoint()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 调用目标方法
        Object result = joinPoint.proceed();
        String requestUrl = threadLocal.get().getT2();
        log.info("-out- {} return:{} -time:{}ms -{}", requestUrl, JSONObject.toJSONString(result), System.currentTimeMillis() - threadLocal.get().getT5(), threadLocal.get().getT6());
        //接口出参处理
        return delReturnData(result);
    }


    /**
     * @description: 初始化参数
     * @author: chenyunxuan
     * @updateTime: 2020/8/4 11:17 上午
     */
    private void loadingThreadLocal(ServletRequestAttributes requestAttributes, Object[] args) {
        HttpServletRequest request = requestAttributes.getRequest();
        Enumeration<String> e = request.getHeaderNames();
        JSONObject headers = new JSONObject();
        if (null != e) {
            while (e.hasMoreElements()) {
                String headerName = e.nextElement();
                Enumeration<String> headerValues = request.getHeaders(headerName);
                while (headerValues.hasMoreElements()) {
                    headers.put(headerName, headerValues.nextElement());
                }
            }
        }
        String businessId = IdUtil.getSnowflake(1, 1).nextIdStr();
        //请求方法,请求地址,参数,头参数,调用时间,调用链id
        threadLocal.set(Tuples.of(request.getMethod(), request.getRequestURI(), args, headers.toJSONString(), System.currentTimeMillis(), businessId));
    }

    /**
     * @description: 处理接口出参
     * @author: chenyunxuan
     * @updateTime: 2020/8/4 11:27 上午
     */
    private Object delReturnData(Object result) {
        threadLocal.remove();
        return result;
    }
}
