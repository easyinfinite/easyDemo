package com.validation.base;

import com.validation.result.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: BaseCrud
 * @Description 基础增删查改控制器
 * @Author: chenyunxuan
 * @Date: 2020/12/18 11:34 上午
 * @version: 1.0.0
 **/
public interface BaseCrud<T, S> {

    /**
     * @description: 分页查询接口
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 11:40 上午
     */
    @GetMapping
    R selectList(@Validated @ModelAttribute S s);

    /**
     * @description: 根据id查询单条数据
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 11:44 上午
     */
    @GetMapping("{id}")
    R selectOne(@PathVariable String id);

    /**
     * @description: 新增单条数据
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 1:39 下午
     */
    @PostMapping
    R add(@RequestBody T t);

    /**
     * @description: 修改单条数据
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 1:39 下午
     */
    @PutMapping("{id}")
    R upp(@PathVariable String id, @RequestBody T t);

    /**
     * @description: 删除单条数据
     * @author: chenyunxuan
     * @updateTime: 2020/12/18 1:40 下午
     */
    @DeleteMapping("{id}")
    R del(@PathVariable String id);
}
