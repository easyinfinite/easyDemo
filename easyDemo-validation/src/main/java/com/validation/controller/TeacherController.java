package com.validation.controller;

import com.validation.base.BaseController;
import com.validation.base.BaseCrud;
import com.validation.entity.teacher.Teacher;
import com.validation.entity.teacher.TeacherSearch;
import com.validation.result.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TeacherController
 * @Description 教师相关控制器
 * @Author: chenyunxuan
 * @Date: 2020/12/18 2:46 下午
 * @version: 1.0.0
 **/
@RestController
@RequestMapping("teacher")
@Validated
public class TeacherController extends BaseController implements BaseCrud<Teacher, TeacherSearch> {

    @Override
    public R selectList(TeacherSearch teacherSearch) {
        return null;
    }

    @Override
    public R selectOne(String id) {
        return null;
    }

    @Override
    public R add(Teacher teacher) {
        return null;
    }

    @Override
    public R upp(String id, Teacher teacher) {
        return null;
    }

    @Override
    public R del(String id) {
        return null;
    }
}
