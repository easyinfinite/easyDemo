package com.validation.controller;

import com.core.redis.cache.CacheClient;
import com.validation.base.BaseController;
import com.validation.base.BaseCrud;
import com.validation.constant.ResultUtil;
import com.validation.entity.teacher.Teacher;
import com.validation.entity.teacher.TeacherDo;
import com.validation.entity.teacher.TeacherSearch;
import com.validation.result.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @Resource
    CacheClient cacheClient;

    @Override
    public R selectList(TeacherSearch teacherSearch) {
        cacheClient.demo();
        System.out.println(cacheClient.demo2());
        return ResultUtil.success("成功");
    }

    @Override
    public R selectOne(String id) {
        return ResultUtil.success("成功");
    }

    @Override
    public R add(Teacher teacher) {
        //转换为数据库操作对象
        TeacherDo userDo = copyToDo(teacher, TeacherDo.builder().build());
        return ResultUtil.success("成功");
    }

    @Override
    public R upp(String id, Teacher teacher) {
        //转换为数据库操作对象
        TeacherDo userDo = copyToDo(teacher, TeacherDo.builder().build());
        return ResultUtil.success("成功");
    }

    @Override
    public R del(String id) {
        return ResultUtil.success("成功");
    }
}
