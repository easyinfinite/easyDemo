package com.validation.config;

import com.validation.constant.ResultUtil;
import com.validation.exception.BusinessException;
import com.validation.result.R;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description 全局异常处理类
 * @Author: chenyunxuan
 * @Date: 2019-12-18 16:29
 * @version: 1.0.0
 **/
@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    /**
     * @title: JSON传值出现异常
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
     * @title: 单个参数参数异常
     * @description:
     * @param:
     * @return:
     * @author: chenyunxuan
     * @date: 2019-12-18 16:37
     * @version: 1.0.0
     * @updateTime: 2019-12-18 16:37
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public R handleMethodArgumentNotValidException(HttpServletRequest req, ConstraintViolationException e) {
        log.error("参数异常:{}", e);
        return ResultUtil.error(1001, e.toString());
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
        if (e instanceof NullPointerException) {
            log.error("{} error", req.getRequestURI());
        } else if (e instanceof BusinessException) {
            log.error("{} own error", req.getRequestURI());
            return ResultUtil.error(((BusinessException) e).getCode(), ((BusinessException) e).getMsg());
        }
        return ResultUtil.error(111, "运行异常");
    }

    /**
     * @title: 提交FORM参数异常
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
