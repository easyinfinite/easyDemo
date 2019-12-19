package com.validation.constant;

/**
 * @ClassName: ErrorCode
 * @Description 异常定义code
 * @Author: chenyunxuan
 * @Date: 2019-12-19 14:47
 * @version: 1.0.0
 **/
public enum ErrorCode {
    /**
     * @description: 系统异常
     * @author: chenyunxuan
     * @updateTime: 2019-12-19 14:56
     */
    SYSTEM_ERROR(1001, "服务器错误");


    int code;
    String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMessage(int code) {
        for (ErrorCode errorCode : values()) {
            if (code == errorCode.code) {
                return errorCode.getMsg();
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}