package com.debris.controller;

import com.debris.initbean.BeanInitProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DemoCotroller
 * @Description 测试控制类
 * @Author: chenyunxuan
 * @Date: 2021/2/4 5:56 下午
 * @version: 1.0.0
 **/
@RestController
public class DemoController {
    @Autowired
    @Qualifier("BeanInitProcessNew")//多个bean实例需要用方法区分或者编辑别名
    BeanInitProcess beanInitProcess;
}