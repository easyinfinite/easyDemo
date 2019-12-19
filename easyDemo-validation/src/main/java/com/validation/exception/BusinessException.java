package com.validation.exception;

import com.validation.constant.ResultUtil;
import lombok.Data;

/**
 * @className: BusinessException
 * @description 自定义异常
 * @author: chenyunxuan
 * @date: 2019-12-19 14:28
 * @version: 1.0.0
 **/
@Data
public class BusinessException extends RuntimeException {
    private int code;
    private String msg;

    /**
     * @description: 只传code
     * @author: chenyunxuan
     * @updateTime: 2019-12-19 15:44
     */
    public BusinessException(int code) {
        super(ResultUtil.getMsg(code));
        this.code = code;
        this.msg = ResultUtil.getMsg(code);
    }

    /**
     * @description: 传code和msg
     * @author: chenyunxuan
     * @updateTime: 2019-12-19 15:44
     */
    public BusinessException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
