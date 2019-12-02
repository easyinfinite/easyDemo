package com.staging.business.controller;


import com.staging.base.result.R;
import com.staging.base.util.ResultUtil;
import com.staging.business.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param
 * @author chenkuidou
 * @description 文件上传
 * @date 2018/12/3 15:47
 * @return
 **/
@RestController
@RequestMapping("/demo")
public class DemoControl {

    @GetMapping("user")
    public R<User> getUser() {
        User u = new User();
        u.setIdCard("123");
        u.setUserName("chen");
        return ResultUtil.data(u);
    }

    @PostMapping("user")
    public R<User> updateUser() {
        User u = new User();
        u.setIdCard("123");
        u.setUserName("chen");
        return ResultUtil.error(10001);
    }

}