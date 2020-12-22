package com.validation.controller.contentype;

import com.validation.constant.ResultUtil;
import com.validation.entity.test.Test;
import com.validation.result.R;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: UrlencodedController
 * @Description 测试 application/x-www-form-urlencoded 请求头
 * @Author: chenyunxuan
 * @Date: 2019-12-18 16:50
 * @version: 1.0.0
 **/
@RestController
@Log4j2
@RequestMapping(value = "urlencoded", headers = "content-type=application/x-www-form-urlencoded")
public class UrlencodedController {
    /**
     * application/x-www-form-urlencoded form表单的默认传输格式,常会在后面跟上编码,即:application/x-www-form-urlencoded;charset=utf-8
     * 为此传输格式时,数据会以键值对的形式传输
     * 当为GET请求时,浏览器用x-www-form-urlencoded的编码方式把form数据转换成一个字串（name1=value1&name2=value2...),然后把这个字串append到url后面，用?分割，加载这个新的url。需要对参数进行 urlencode 编码和序列化
     * 当为POST请求时,浏览器把form数据封装到http body中,不可用@RequestBody注解修饰接收实体.
     */

    //GET请求 传参没有注解修饰,实体接收,?传参方式可传值,参数名为实体内的属性值
    @GetMapping(value = "test1")
    public R test1(Test test) {
        return ResultUtil.data(test);
    }

    //GET请求 传参没有注解修饰
    //?传参方式可传值,参数名为入参的属性名称
    //也可用 @RequestParam 取别名
    @GetMapping(value = "test2")
    public R test2(@RequestParam(value = "test1", required = false) String test) {
        return ResultUtil.data(test);
    }

    //POST请求 传参没有注解修饰
    //传入Body里,参数名为入参的属性名称
    @PostMapping(value = "test3")
    public R test3(Test test) {
        return ResultUtil.data(test);
    }
}
