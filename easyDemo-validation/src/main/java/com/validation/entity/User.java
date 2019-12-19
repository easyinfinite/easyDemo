package com.validation.entity;

import com.validation.valiNote.group.App;
import com.validation.valiNote.group.Pc;
import com.validation.valiNote.mobile.MobileVail;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;


/**
 * @ClassName:User
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2019-12-18 16:48
 * @version: 1.0.0
 **/
@Data
public class User {
    /**
     * @Null 被注解的元素必须为null
     * @NotNull 被注解的元素必须不为null
     * @AssertTure 被注解的元素必须为ture
     * @AssertFalse 被注解的元素必须为false
     * @Min(value) 被注解的元素必须是数字且必须大于等于指定值
     * @Max(value) 被注解的元素必须是数字且必须小于等于指定值
     * @DecimalMin(value) 被注解的元素必须是数字且必须大于等于指定值
     * @DecimalMax(value) 被注解的元素必须是数字且必须小于等于指定值
     * @Size(max, min)	被注解的元素必须在指定的范围内
     * @Digits(integer, fraction)	被注解的元素必须是数字且其值必须在给定的范围内
     * @Past 被注解的元素必须是一个过去的日期
     * @Future 被注解的元素必须是一个将来的日期
     * @Pattern(value) 被注解的元素必须符合给定正则表达式
     * @Email 被注解的元素必须是Email地址
     * @Length(min, max)	被注解的元素长度必须在指定的范围内
     * @NotEmpty 被注解的元素必须
     * @Range 被注解的元素(可以是数字或者表示数字的字符串)必须在给定的范围内
     * @URL 被注解的元素必须是URL
     */

    /**
     * @description: 自定义参数效验
     * @author: chenyunxuan
     * @updateTime: 2019-12-18 17:30
     */
    @MobileVail(groups = {Pc.class})
    private String mobile;

    @Size(min = 2, max = 30, groups = {App.class,Pc.class})
    private String name;

    /**
     * @description: 自定义错误信息
     * @author: chenyunxuan
     * @updateTime: 2019-12-18 17:30
     */
    @NotEmpty(message = "自定义错误信息，Email不能为空")
    @Email
    private String email;

    @NotNull
    @Min(18)
    @Max(100)
    private Integer age;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull
    @Past
    private LocalDateTime birthday;


}
