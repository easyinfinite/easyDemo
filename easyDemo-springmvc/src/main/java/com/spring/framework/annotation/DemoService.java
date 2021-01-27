package com.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: DemoServer
 * @Description //逻辑处理注解
 * @Author: chenyunxuan
 * @Date: 2021/1/27 2:24 下午
 * @version: 1.0.0
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DemoService {
    String value() default "";
}
