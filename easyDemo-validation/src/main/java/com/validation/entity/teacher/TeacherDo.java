package com.validation.entity.teacher;

import lombok.Builder;
import lombok.Data;


/**
 * @ClassName: TeacherDo
 * @Description 教师实体类(数据库操作对象)
 * @Author: chenyunxuan
 * @Date: 2019-12-18 16:48
 * @version: 1.0.0
 **/
@Data
@Builder
public class TeacherDo {

    private Long id;
    private String name;
    private String subjects;
    private Integer year;

}
