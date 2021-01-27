package com.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: DemoRequestMapping
 * @Description //网络请求映射注解
 * @Author: chenyunxuan
 * @Date: 2021/1/27 2:24 下午
 * @version: 1.0.0
 **/
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DemoRequestMapping {
    String value() default "";
}
