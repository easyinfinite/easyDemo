package com.validation.entity;

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
     * @description: 自定义参数效验
     * @author: chenyunxuan
     * @updateTime: 2019-12-18 17:30
     */
    @MobileVail
    private String mobile;

    @Size(min=2, max=30)
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
    @Min(18) @Max(100)
    private Integer age;

    @DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull @Past
    private LocalDateTime birthday;



}
