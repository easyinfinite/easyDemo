package com.validation.controller;

import com.validation.constant.ErrorCode;
import com.validation.constant.ResultUtil;
import com.validation.entity.User;
import com.validation.exception.BusinessException;
import com.validation.result.R;
import com.validation.valiNote.group.App;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @ClassName:ValidationController
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2019-12-18 16:50
 * @version: 1.0.0
 **/
@Controller
@Log4j2
@Validated
public class ValidationController {
    //1. application/x-www-form-urlencoded，这种情况的数据@RequestParam、@ModelAttribute可以处理，@RequestBody也可以处理。
    //2. multipart/form-data，@RequestBody不能处理这种格式的数据。（form表单里面有文件上传时，必须要指定enctype属性值为multipart/form-data，意思是以二进制流的形式传输文件。）
    //3. application/json、application/xml等格式的数据，必须使用@RequestBody来处理。
    @PostMapping(value = "save")
    @ResponseBody
    //分组传参
    public R saveUser(@RequestBody @Validated(App.class) User user) {
        if (null != user) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR.getCode());
        }
        return ResultUtil.data(user);
    }

    @GetMapping(value = "save1")
    @ResponseBody
    //?传参
    public R getUser(@NotEmpty @Min(2) String name) {
        return ResultUtil.data(name);
    }

    @PostMapping(value = "save3")
    @ResponseBody
    //直接form提交参数
    public R getUser(@Validated User user) {
        return ResultUtil.data(user);
    }
}
