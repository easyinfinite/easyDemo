package com.validation.base;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 控制层基类
 * @author: chenyunxuan
 * @updateTime: 2020/12/18 3:36 下午
 */
public abstract class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;

}