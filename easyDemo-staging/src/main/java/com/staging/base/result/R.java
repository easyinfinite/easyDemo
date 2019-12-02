package com.staging.base.result;


import lombok.Data;

import java.io.Serializable;

/**
 *
 * 功能描述: 返回类R
 * @auther: chenyunxuan
 * @date: 2019-12-02 18:29
 */
@Data
public class R<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 消息
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
    private T result;
}
