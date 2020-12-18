package com.validation.entity.teacher;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @ClassName: Teacher
 * @Description 教师实体类
 * @Author: chenyunxuan
 * @Date: 2019-12-18 16:48
 * @version: 1.0.0
 **/
@Data
public class Teacher {

    @Size(min = 2, max = 30)
    private String name;

    /**
     * @description: 所教科目
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 3:40 下午
     */
    @NotNull
    private String subjects;

    /**
     * @description: 教龄
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 3:41 下午
     */
    @NotNull
    @Min(0)
    @Max(100)
    private Integer year;

}
