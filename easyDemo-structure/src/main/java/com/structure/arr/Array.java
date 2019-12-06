package com.structure.arr;

import com.google.common.base.Preconditions;

/**
 * @ClassName:Array
 * @Description 实现一个数组操作类
 * @Author: chenyunxuan
 * @Date: 2019-12-06 16:59
 * @version: 1.0.0
 **/
public class Array<E> {

    /**
     * @description: 定义一个泛型数组
     * @author: chenyunxuan
     * @updateTime: 2019-12-06 17:04
     */
    private E[] data;

    /**
     * @description: 数组的长度
     * @author: chenyunxuan
     * @updateTime: 2019-12-06 17:05
     */
    private int size;


    /**
     * @title: 构造方法
     * @description:
     * @param: limit为数组容量上限
     * @return: null
     * @author: chenyunxuan
     * @date: 2019-12-06 17:21
     * @version: 1.0.0
     * @updateTime: 2019-12-06 17:21
     */
    public Array(int limit) {
        data = (E[]) new Object[limit];
        size = 0;
    }

    /**
     * @title: 默认构造方法
     * @description:
     * @param: null
     * @return: null
     * @author: chenyunxuan
     * @date: 2019-12-06 17:24
     * @version: 1.0.0
     * @updateTime: 2019-12-06 17:24
     */
    public Array() {
        this(10);
    }


    /**
     * @title: 返回数组长度
     * @author: chenyunxuan
     * @date: 2019-12-06 17:42
     * @version: 1.0.0
     * @updateTime: 2019-12-06 17:42
     */
    public int getSize() {
        return size;
    }

    /**
     * @title: 返回当前容量
     * @author: chenyunxuan
     * @date: 2019-12-06 17:43
     * @version: 1.0.0
     * @updateTime: 2019-12-06 17:43
     */
    public int getLimit() {
        return data.length;
    }


    /**
     * @title: 追加元素到最后
     * @author: chenyunxuan
     * @date: 2019-12-06 17:48
     * @version: 1.0.0
     * @updateTime: 2019-12-06 17:48
     */
    public void addLast(E item) {
        add(size, item);
    }


    /**
     * @description: 追加元素到最前
     * @author: chenyunxuan
     * @updateTime: 2019-12-06 18:36
     */
    public void addFirst(E item) {
        add(0, item);
    }

    /**
     * @description: 追加元素到任意位置
     * @author: chenyunxuan
     * @updateTime: 2019-12-06 18:36
     */
    public void add(int index, E item) {
        Preconditions.checkArgument(data.length != size, "size limit : %s", data.length);
        Preconditions.checkArgument(index >= 0, "index %s Less than 0 ", index);
        Preconditions.checkArgument(index <= size, "index > size ");
        //逐个往后延伸一个单位
        for (int a = size - 1; a >= index; a--) {
            data[a + 1] = data[a];
        }
        //替换
        data[index] = item;
        //下标追加1
        size++;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (E e : data) {
            if (null != e) {
                builder.append(e);
                builder.append(",");
            }
        }
        builder.append("}");
        return builder.toString();
    }

}
