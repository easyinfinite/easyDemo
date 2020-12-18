package com.validation.config;

import com.validation.constant.ResultUtil;
import com.validation.exception.BusinessException;
import com.validation.result.R;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.Objects;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description 全局异常处理类
 * @Author: chenyunxuan
 * @Date: 2019-12-18 16:29
 * @version: 1.0.1
 **/
@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    /**
     * @description: 处理自定义的业务异常
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 2:09 下午
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public R BusinessExceptionHandler(HttpServletRequest req, BusinessException e) {
        log.error(String.format("BusinessException RequestURI::%s", req.getRequestURI()), e);
        return ResultUtil.error(e.getCode(), e.getMessage());
    }

    /**
     * @description: 参数类型转换异常捕捉
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 2:09 下午
     */
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public R MethodArgumentTypeMismatchExceptionHandler(HttpServletRequest req, MethodArgumentTypeMismatchException e) {
        String builder = "参数转换失败，方法：" +
                Objects.requireNonNull(e.getParameter().getMethod()).getName() +
                "，参数：" +
                e.getName() +
                ",信息：" +
                e.getLocalizedMessage();
        log.error("MethodArgumentNotValidException RequestURI:{} msg:{}", req.getRequestURI(), builder);
        return ResultUtil.error(400, "参数" + e.getName() + "类型不正确");
    }

    /**
     * @description: JSON传值出现异常
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
        log.error(String.format("MethodArgumentNotValidException RequestURI:%s msg:%s", req.getRequestURI(), msg), e);
        return ResultUtil.error(400, bindingResult.getFieldError().getDefaultMessage());
    }

    /**
     * @title: 单个参数参数异常
     * @author: chenyunxuan
     * @date: 2019-12-18 16:37
     * @version: 1.0.0
     * @updateTime: 2019-12-18 16:37
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public R handleMethodArgumentNotValidException(HttpServletRequest req, ConstraintViolationException e) {
        log.error(String.format("ConstraintViolationException RequestURI:%s", req.getRequestURI()), e);
        return ResultUtil.error(400, e.getMessage());
    }

    /**
     * @title: 提交FORM参数异常
     * @author: chenyunxuan
     * @date: 2019-12-18 16:41
     * @version: 1.0.0
     * @updateTime: 2019-12-18 16:41
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public R handleBindException(HttpServletRequest req, BindException e) throws BindException {
        // ex.getFieldError():随机返回一个对象属性的异常信息。如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
        FieldError fieldError = e.getFieldError();
        StringBuilder sb = new StringBuilder();
//        sb.append(fieldError.getField()).append("=[").append(fieldError.getRejectedValue()).append("]");
        sb.append(fieldError.getDefaultMessage());
        // 生成返回结果
        log.error("BindException requestURI:{} paramName:{} msg:{}", req.getRequestURI(), e.getObjectName(), fieldError.getDefaultMessage());
        return ResultUtil.error(400, fieldError.getDefaultMessage());
    }

    /**
     * @description: 客户端使用错误的HTTP方法调用rest资源
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 2:20 下午
     */
    @ExceptionHandler(value = ServletRequestBindingException.class)
    @ResponseBody
    public R ServletRequestBindingExceptionHandler(HttpServletRequest req, ServletRequestBindingException e) {
        log.error("ServletRequestBindingException RequestURI:{},{}", req.getRequestURI(), e.getMessage());
        return ResultUtil.error(400, e.getMessage());
    }

    /**
     * @description: 客户端使用错误的Content-Type调用
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 2:20 下午
     */
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public R ServletRequestBindingExceptionHandler(HttpServletRequest req, HttpMediaTypeNotSupportedException e) {
        log.error("HttpMediaTypeNotSupportedException RequestURI:{},{}", req.getRequestURI(), e.getMessage());
        return ResultUtil.error(400,"错误的Content-Type");
    }

    /**
     * @description: 当接收入参为requestBody时传入空值
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 2:20 下午
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public R ServletRequestBindingExceptionHandler(HttpServletRequest req, HttpMessageNotReadableException e) {
        log.error("HttpMessageNotReadableException RequestURI:{},{}", req.getRequestURI(), e.getMessage());
        return ResultUtil.error(400,"请求body为空");
    }


    /**
     * @description: 处理其他异常记录
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 2:08 下午
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R ExceptionHandler(HttpServletRequest req, Exception e) {
        log.error(String.format("Exception requestURI:%s", req.getRequestURI()), e);
        return ResultUtil.error(500, "服务器内部错误");
    }
}
