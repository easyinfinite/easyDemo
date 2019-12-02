package com.staging.base.util;


import com.staging.base.result.R;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: 返回类封装
 *
 * @auther: chenyunxuan
 * @date: 2019-12-02 18:28
 */
public class ResultUtil<T> {

    private static Map<Integer, String> messageMap = new HashMap<>();
    private int successCode = 200;
    private String successMessage = "成功";

    //初始化状态码与文字说明
    static {
        /* 服务器错误 */
        messageMap.put(1000, "服务器错误");

        /* 参数错误：10001-19999 */
        messageMap.put(10001, "参数无效");
        messageMap.put(10002, "参数为空");
        messageMap.put(10003, "参数类型错误");
        messageMap.put(10004, "参数缺失");

        /* 用户错误：20001-29999*/
        messageMap.put(20001, "用户未登录");
        messageMap.put(20002, "账号不存在或密码错误");
        messageMap.put(20003, "账号已被禁用");
        messageMap.put(20004, "用户不存在");
        messageMap.put(20005, "用户已存在");

        /* 业务错误：30001-39999 */
        messageMap.put(30001, "某业务出现问题");

        /* 系统错误：40001-49999 */
        messageMap.put(40001, "系统繁忙，请稍后重试");

        /* 数据错误：50001-599999 */
        messageMap.put(50001, "数据未找到");
        messageMap.put(50002, "数据有误");
        messageMap.put(50003, "数据已存在");
        messageMap.put(50004, "查询出错");

        /* 接口错误：60001-69999 */
        messageMap.put(60001, "内部系统接口调用异常");
        messageMap.put(60002, "外部系统接口调用异常");
        messageMap.put(60003, "该接口禁止访问");
        messageMap.put(60004, "接口地址无效");
        messageMap.put(60005, "接口请求超时");
        messageMap.put(60006, "接口负载过高");

        /* 权限错误：70001-79999 */
        messageMap.put(70001, "token过期");
        messageMap.put(70003, "验证码过期,请重新获取");
        messageMap.put(70004, "无效验证码,请核对");
        messageMap.put(70005, "该号码已与其他微信号绑定,请更换号码");
        messageMap.put(70008, "余额不足");
        messageMap.put(70009, "存在退款订单");
        messageMap.put(70012, "存在押金订单");
        messageMap.put(70010, "存在进行中订单");
        messageMap.put(70011, "陪护床正在使用");
        messageMap.put(70013, "订单超过十分钟");
        messageMap.put(70014, "存在待退还预付款");
        messageMap.put(70015, "未激活的陪护床");
        messageMap.put(70016, "禁用时段");


        /* 商品模块 */
        messageMap.put(1001, "账号或密码错误");

    }


    private R<T> r;

    private ResultUtil() {
        r = new R<>();
        r.setSuccess(true);
        r.setMessage(successMessage);
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
        this.r.setMessage(messageMap.get(code));
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

    //灵活自定义
    public static <T> R<T> error(Integer code, String msg) {
        return new ResultUtil<T>().setErrorMsg(code, msg);
    }
}
