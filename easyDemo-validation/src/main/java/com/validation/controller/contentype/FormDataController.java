package com.validation.controller.contentype;

import com.validation.constant.ResultUtil;
import com.validation.entity.test.Test;
import com.validation.result.R;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: FormDataController
 * @Description 测试 multipart/form-data 请求头
 * @Author: chenyunxuan
 * @Date: 2019-12-18 16:50
 * @version: 1.0.0
 **/
@RestController
@Log4j2
@RequestMapping(value = "form", headers = "content-type=multipart/form-data")
public class FormDataController {
    /**
     * multipart/form-data form表单的扩展传输格式
     * 为此传输格式时,浏览器会把整个表单以控件为单位分割，并为每个部分加上Content-Disposition(form-data或者file),Content-Type(默认为text/plain),name(控件name)等信息，并加上分割符(boundary)。
     * 当为GET请求时,入参对象或者单属性均可与传入的name键值对一一对应
     * 当为POST请求时,浏览器把form数据封装到http body中,不可用@RequestBody注解修饰接收实体.
     */

    //    此为一个完整multipart/form-data提交产生的数据
    //    POST /urlencoded/test3 HTTP/1.1
    //    Host: 127.0.0.1:8080
    //    Content-Length: 542
    //    Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
    //
    //    ----WebKitFormBoundary7MA4YWxkTrZu0gW
    //    Content-Disposition: form-data; name="a"
    //
    //    a
    //    ----WebKitFormBoundary7MA4YWxkTrZu0gW
    //    Content-Disposition: form-data; name=""; filename="xxxx.jpg"
    //    Content-Type: image/jpeg
    //
    //            (data)
    //    ----WebKitFormBoundary7MA4YWxkTrZu0gW
    //    Content-Disposition: form-data; name=""; filename="xxx.mp3"
    //    Content-Type: audio/mpeg
    //
    //            (data)
    //    ----WebKitFormBoundary7MA4YWxkTrZu0gW
    //    Content-Disposition: form-data; name=""; filename="xxxx.zip"
    //    Content-Type: application/zip
    //
    //            (data)
    //    ----WebKitFormBoundary7MA4YWxkTrZu0gW


    //GET请求 传参没有注解修饰,实体接收,直接用form传输过来,即可与实体中的字段一一对应
    @GetMapping(value = "test1")
    public R test1(Test test) {
        return ResultUtil.data(test);
    }

    //GET请求 传参没有注解修饰
    //直接用form传输,与入参字段名相同即可接收到值
    //也可用 @RequestParam 取别名
    @GetMapping(value = "test2")
    public R test2(@RequestParam(value = "test1", required = false) String test) {
        return ResultUtil.data(test);
    }

    //POST请求 传参没有注解修饰
    //传入Body里,参数名为入参的属性名称,文件传输可分开指定字段,也可直接在实体中定义.
    @PostMapping(value = "test3")
    public R test3(Test test,@RequestParam("files") MultipartFile[] files) {
        return ResultUtil.data(test);
    }

}
