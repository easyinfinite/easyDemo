package com.validation.controller.contentype;

import com.validation.constant.ResultUtil;
import com.validation.entity.test.Test;
import com.validation.result.R;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: JsonController
 * @Description 测试 application/json 请求头
 * @Author: chenyunxuan
 * @Date: 2019-12-18 16:50
 * @version: 1.0.0
 **/
@RestController
@Log4j2
@RequestMapping(value = "json", headers = "content-type=application/json")
public class JsonController {
    /**
     * application/json
     * 为此传输格式时,数据主体是序列化后的JSON字符串
     * 当为GET请求时,?传参方式可传值,参数名为实体内的属性值,用@RequestBody注解修饰,可直接获取到参数名对应的入参
     * 当为POST请求时候,body中,不可用@RequestBody注解修饰接收实体.
     */

    //GET请求 传参没有注解修饰,实体接收,?传参方式可传值,参数名为实体内的属性值
    //传参用@RequestBody注解修饰,可在body中获取到值,参数名为入参的属性名称
    @GetMapping(value = "test1")
    public R test1(@RequestBody Test test) {
        return ResultUtil.data(test);
    }

    //GET请求 传参没有注解修饰
    //?传参方式可传值,参数名为入参的属性名称
    //也可用 @RequestParam 取别名
    @GetMapping(value = "test2")
    public R test2(@RequestParam(value = "test1", required = false) String test) {
        return ResultUtil.data(test);
    }

    //POST请求,实体必须用@RequestBody注解修饰
    //传入Body里,参数名为入参的属性名称
    @PostMapping(value = "test3")
    public R test3(@RequestBody Test test) {
        return ResultUtil.data(test);
    }
}
