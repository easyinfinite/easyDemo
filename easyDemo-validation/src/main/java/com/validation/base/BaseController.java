package com.validation.base;

import org.springframework.beans.BeanUtils;
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

    /**
     * @description: copy对象方法(T为需要copy的对象, S为转换后的对象)
     * @author: chenyunxuan
     * @updateTime: 2020/12/24 5:21 下午
     */
    protected <T, S> S copyToDo(T t, S s) {
        BeanUtils.copyProperties(t, s);
        return s;
    }

}