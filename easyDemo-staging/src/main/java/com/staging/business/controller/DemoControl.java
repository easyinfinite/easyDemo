package com.staging.business.controller;


import com.staging.base.aspect.Runtime;
import com.staging.base.result.R;
import com.staging.base.util.ResultUtil;
import com.staging.business.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

/**
 * @param
 * @author chenkuidou
 * @description 文件上传
 * @date 2018/12/3 15:47
 * @return
 **/
@RestController
@RequestMapping("/demo")
@Log4j2
public class DemoControl {

    @Runtime
    @GetMapping("user")
    public R<User> getUser() {
        User u = new User();
        u.setIdCard("123");
        u.setUserName("chen");
        return ResultUtil.data(u);
    }

    /**
     * @title: updateUser
     * @description:
     * @param: []
     * @return: com.staging.base.result.R<com.staging.business.entity.User>
     * @author: chenyunxuan
     * @date: 2019-12-03 11:35
     * @version: 1.0.0
     * @updateTime: 2019-12-03 11:35
     */
    @PostMapping("user")
    @Runtime
    public R<User> updateUser() {
        User u = new User();
        u.setIdCard("123");
        u.setUserName("chen");
        log.info("hahhdhasd");
        log.error("{132131}={}", "大叔大婶大");
        return ResultUtil.error(10001);
    }

    @DeleteMapping("user")
    @Runtime
    public R<User> delUser() {
        int a = 0;
        int c = 1 / a;
        log.info("hahhdhasd");
        log.error("{132131}={}", "大叔大婶大");
        return ResultUtil.error(10001);
    }

}