package com.validation.annotation;

import java.lang.annotation.*;

/**
 * @ClassName:Version
 * @Description 接口版本控制注解
 * @Author: chenyunxuan
 * @Date: 2020/12/16 4:38 下午
 * @version: 1.0.0
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Version {
    /**
     * 版本
     *
     * @return
     */
    String value() default "1.0.0";
}
