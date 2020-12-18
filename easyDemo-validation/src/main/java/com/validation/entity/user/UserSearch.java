package com.validation.entity.user;

import com.validation.valiNote.mobile.MobileVail;
import lombok.Data;

import javax.validation.constraints.*;


/**
 * @ClassName: UserSearch
 * @Description 会员搜索类
 * @Author: chenyunxuan
 * @Date: 2019-12-18 16:48
 * @version: 1.0.0
 **/
@Data
public class UserSearch {

    /**
     * @description: 分页页码
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 2:45 下午
     */
    @Min(-1)
    private Integer pageNum;
    /**
     * @description: 手机号
     * @author: chenyunxuan
     * @updateTime: 2019-12-18 17:30
     */
    @MobileVail
    private String mobile;

    /**
     * @description: 名称搜索
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 2:44 下午
     */
    @Size(min = 2, max = 30)
    private String name;

    /**
     * @description: 邮箱搜索
     * @author: chenyunxuan
     * @updateTime: 2019-12-18 17:30
     */
    @NotEmpty(message = "自定义错误信息，Email不能为空")
    @Email
    private String email;


}
