package com.staging.base.aspect;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
/**
 *
 * 功能描述: 用于记录程序时间的注解
 *
 * @param:
 * @return: com.staging.base.aspect.Runtime
 * @author: chenyunxuan
 * @date: 2019-12-02 21:51
 */
public @interface Runtime {
}
