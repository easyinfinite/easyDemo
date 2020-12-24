package com.validation.entity.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * @ClassName: UserDo
 * @Description 会员实体类(数据库操作对象)
 * @Author: chenyunxuan
 * @Date: 2019-12-18 16:48
 * @version: 1.0.0
 **/
@Data
@Builder
public class UserDo {
    private Long userId;
    private String mobile;
    private String name;
    private String email;
    private Integer age;
    private LocalDateTime birthday;
}
