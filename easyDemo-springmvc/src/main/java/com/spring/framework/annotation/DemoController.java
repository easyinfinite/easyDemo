package com.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: DemoController
 * @Description //j控制器注解
 * @Author: chenyunxuan
 * @Date: 2021/1/27 2:23 下午
 * @version: 1.0.0
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DemoController {
}
