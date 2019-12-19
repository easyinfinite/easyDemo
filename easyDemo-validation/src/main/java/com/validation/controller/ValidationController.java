package com.validation.controller;

import com.validation.entity.User;
import com.validation.result.R;
import com.validation.util.ResultUtil;
import com.validation.valiNote.group.App;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName:ValidationController
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2019-12-18 16:50
 * @version: 1.0.0
 **/
@Controller
@Log4j2

public class ValidationController {

    @PostMapping(value = "save")
    @ResponseBody
    public R saveUser(@RequestBody @Validated(App.class) User user) {
        log.info("Good" + user.getBirthday());
        return ResultUtil.data(user);
    }
}
