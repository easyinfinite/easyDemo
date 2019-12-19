package com.validation.config;

import com.validation.result.R;
import com.validation.util.ResultUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName:GlobalExceptionHandler
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2019-12-18 16:29
 * @version: 1.0.0
 **/
@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    /**
     * @title: 登陆异常
     * @description:
     * @param:
     * @return:
     * @author: chenyunxuan
     * @date: 2019-12-18 16:38
     * @version: 1.0.0
     * @updateTime: 2019-12-18 16:38
     */
    @ExceptionHandler(value = AuthException.class)
    @ResponseBody
    public R handleAuthException(HttpServletRequest req, AuthException e) throws AuthException {
        log.info("AuthException", e.getMessage());
        return ResultUtil.error(70001);
    }

    /**
     * @title: 参数异常
     * @description:
     * @param:
     * @return:
     * @author: chenyunxuan
     * @date: 2019-12-18 16:37
     * @version: 1.0.0
     * @updateTime: 2019-12-18 16:37
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public R handleMethodArgumentNotValidException(HttpServletRequest req, MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder sb = new StringBuilder();
        sb.append("url=");
        sb.append(req.getRequestURI().replace("/", ""));
        sb.append(",");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append("field=");
            sb.append(fieldError.getObjectName());
            sb.append(".");
            sb.append(fieldError.getField());
            sb.append(",error=");
            sb.append(fieldError.getDefaultMessage());
            sb.append(";");
        }
        String msg = sb.toString();
        log.error("参数异常:{}", msg);
        return ResultUtil.error(1001, msg);
    }

    /**
     * @title: 全局异常
     * @description:
     * @param:
     * @return:
     * @author: chenyunxuan
     * @date: 2019-12-18 16:41
     * @version: 1.0.0
     * @updateTime: 2019-12-18 16:41
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R handleException(HttpServletRequest req, Exception e) throws Exception {
        log.error(e.getMessage(), e);
        return ResultUtil.error(111, "异常");
    }

    /**
     * @title: 其他异常
     * @description:
     * @param:
     * @return:
     * @author: chenyunxuan
     * @date: 2019-12-18 16:41
     * @version: 1.0.0
     * @updateTime: 2019-12-18 16:41
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public R handleBindException(BindException e) throws BindException {
        // ex.getFieldError():随机返回一个对象属性的异常信息。如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
        FieldError fieldError = e.getFieldError();
        StringBuilder sb = new StringBuilder();
        sb.append(fieldError.getField()).append("=[").append(fieldError.getRejectedValue()).append("]")
                .append(fieldError.getDefaultMessage());
        // 生成返回结果
        log.info("BindException", e);
        return ResultUtil.error(10001, sb.toString());
    }
}
