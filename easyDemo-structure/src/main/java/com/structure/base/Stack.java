package com.structure.base;

/**
 * @ClassName:Stack
 * @Description 基类
 * @Author: chenyunxuan
 * @Date: 2019-12-10 19:03
 * @version: 1.0.0
 **/
public interface Stack<E> {
    void push(E e);
    E pop();
    E peek();
}
