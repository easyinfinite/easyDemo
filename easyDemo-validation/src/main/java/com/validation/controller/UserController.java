package com.validation.controller;

import com.validation.base.BaseController;
import com.validation.base.BaseCrud;
import com.validation.entity.user.User;
import com.validation.entity.user.UserSearch;
import com.validation.result.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Description 会员相关控制器
 * @Author: chenyunxuan
 * @Date: 2020/12/18 2:46 下午
 * @version: 1.0.0
 **/
@RestController
@RequestMapping("user")
@Validated
public class UserController extends BaseController implements BaseCrud<User, UserSearch> {

    @Override
    public R selectList(UserSearch userSearch) {
        request.getRequestURI();
        return null;
    }

    @Override
    public R selectOne(String id) {
        return null;
    }

    @Override
    public R add(User user) {
        return null;
    }

    @Override
    public R upp(String id, User user) {
        return null;
    }

    @Override
    public R del(String id) {
        return null;
    }
}
