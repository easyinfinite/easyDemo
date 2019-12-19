package com.validation.constant;


import com.validation.result.R;

/**
 * 功能描述: 返回类封装
 *
 * @author: chenyunxuan
 * @date: 2019-12-02 18:28
 */
public class ResultUtil<T> {

    private int successCode = 200;

    private R<T> r;

    private ResultUtil() {
        r = new R<>();
        r.setSuccess(true);
        r.setMessage("成功");
        r.setCode(successCode);
    }

    private R<T> setData(T t) {
        this.r.setResult(t);
        this.r.setCode(successCode);
        return this.r;
    }

    private R<T> setSuccessMsg(String msg) {
        this.r.setSuccess(true);
        this.r.setMessage(msg);
        this.r.setCode(successCode);
        this.r.setResult(null);
        return this.r;
    }

    private R<T> setData(T t, String msg) {
        this.r.setResult(t);
        this.r.setCode(successCode);
        this.r.setMessage(msg);
        return this.r;
    }

    private R<T> setErrorMsg(Integer code) {
        this.r.setSuccess(false);
        this.r.setMessage(ErrorCode.getMessage(code));
        this.r.setCode(code);
        return this.r;
    }

    private R<T> setErrorMsg(Integer code, String msg) {
        this.r.setSuccess(false);
        this.r.setMessage(msg);
        this.r.setCode(code);
        return this.r;
    }

    public static <T> R<T> data(T t) {
        return new ResultUtil<T>().setData(t);
    }

    public static <T> R<T> data(T t, String msg) {
        return new ResultUtil<T>().setData(t, msg);
    }

    public static <T> R<T> success(String msg) {
        return new ResultUtil<T>().setSuccessMsg(msg);
    }

    public static <T> R<T> error(Integer code) {
        return new ResultUtil<T>().setErrorMsg(code);
    }

    public static String getMsg(int code) {
        return ErrorCode.getMessage(code);
    }

    //灵活自定义
    public static <T> R<T> error(Integer code, String msg) {
        return new ResultUtil<T>().setErrorMsg(code, msg);
    }
}
