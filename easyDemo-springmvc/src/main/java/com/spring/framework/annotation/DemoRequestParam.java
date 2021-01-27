package com.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: DemoRequestParam
 * @Description //参数接收注解
 * @Author: chenyunxuan
 * @Date: 2021/1/27 7:45 下午
 * @version: 1.0.0
 **/
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DemoRequestParam {
    String value() default "";
}
