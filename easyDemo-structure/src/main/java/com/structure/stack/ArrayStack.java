package com.structure.stack;

import com.structure.arr.Array;
import com.structure.base.Stack;

/**
 * @ClassName:ArrayStack
 * @Description 栈的实现
 * @Author: chenyunxuan
 * @Date: 2019-12-10 19:05
 * @version: 1.0.0
 **/
public class ArrayStack<E> implements Stack<E> {

    /**
     * @description: 基础array
     * @author: chenyunxuan
     * @updateTime: 2019-12-10 19:07
     */
    private Array<E> array;


    /**
     * @description: 有上限的栈
     * @author: chenyunxuan
     * @updateTime: 2019-12-10 19:08
     */
    public ArrayStack(int limit) {
        this.array = new Array<E>(limit);
    }

    /**
     * @description: 栈是否为空
     * @author: chenyunxuan
     * @updateTime: 2019-12-25 11:53
     */
    public boolean isEmpty() {
        return array.getSize() == 0;
    }

    /**
     * @description: 有默认上限的栈
     * @author: chenyunxuan
     * @updateTime: 2019-12-10 19:08
     */
    public ArrayStack() {
        this.array = new Array<E>();
    }

    /**
     * @description: 获取栈的上限
     * @author: chenyunxuan
     * @updateTime: 2019-12-10 19:10
     */
    public int getLimit() {
        return this.array.getLimit();
    }

    /**
     * @description: 往栈末尾添加元素
     * @author: chenyunxuan
     * @updateTime: 2019-12-10 19:12
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * @description: 取出栈末尾的元素
     * @author: chenyunxuan
     * @updateTime: 2019-12-10 19:13
     */
    @Override
    public E pop() {
        return array.removeLast();
    }


    /**
     * @description: 返回栈末尾的函数
     * @author: chenyunxuan
     * @updateTime: 2019-12-10 19:13
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("stack:{");
        for (int a = 0; a < array.getSize(); a++) {
            sb.append(array.get(a));
            if (a != array.getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("} top");
        return sb.toString();
    }
}
