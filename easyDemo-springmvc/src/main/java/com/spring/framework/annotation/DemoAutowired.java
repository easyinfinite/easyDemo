package com.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: DemoAutowired
 * @Description //注入注解
 * @Author: chenyunxuan
 * @Date: 2021/1/27 2:56 下午
 * @version: 1.0.0
 **/
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DemoAutowired {
    String value() default "";
}
