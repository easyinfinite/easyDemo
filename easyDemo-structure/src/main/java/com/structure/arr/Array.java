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
        //Preconditions.checkArgument(data.length != size, "size limit : %s", data.length);
        //如果超出范围,扩容
        if (data.length == size) {
            resetArray(2 * data.length);
        }
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


    /**
     * @description: 删除开始元素
     * @author: chenyunxuan
     * @updateTime: 2019-12-06 18:59
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * @description: 删除末端元素
     * @author: chenyunxuan
     * @updateTime: 2019-12-06 19:00
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * @description: 删除任意位置元素
     * @author: chenyunxuan
     * @updateTime: 2019-12-06 19:00
     */
    public E remove(int index) {
        Preconditions.checkArgument(size > 0, "size must be more then 0");
        Preconditions.checkArgument(index >= 0, "index %s Less than 0 ", index);
        Preconditions.checkArgument(index < size, "index > size ");
        E removeItem = data[index];
        //逐个往前缩减一个单位
        for (int a = index; a < data.length - 1; a++) {
            data[a] = data[a + 1];
        }
        //把站位去掉
        data[data.length - 1] = null;
        //下标追加1
        size--;
        //减少容量
        if (data.length != 0 && data.length / 4 == size) {
            //缩小为容量的二分之一
            resetArray(data.length / 2);
        }
        return removeItem;
    }

    /**
     * @description: 获取某个位置的元素
     * @author: chenyunxuan
     * @updateTime: 2019-12-09 15:22
     */
    public E get(int index) {
        Preconditions.checkArgument(index >= 0, "index %s Less than 0 ", index);
        Preconditions.checkArgument(index < size, "index > size ");
        return data[index];
    }

    /**
     * @description: 在数组某个位置替换元素
     * @author: chenyunxuan
     * @updateTime: 2019-12-09 15:22
     */
    public void set(int index, E e) {
        Preconditions.checkArgument(index >= 0, "index %s Less than 0 ", index);
        Preconditions.checkArgument(index < size, "index > size ");
        data[index] = e;
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


    /**
     * @description: 重新定义数组长度
     * @author: chenyunxuan
     * @updateTime: 2019-12-09 15:52
     */
    private void resetArray(int reSize) {
        E[] newData = (E[]) new Object[reSize];
        for (int a = 0; a < size; a++) {
            newData[a] = data[a];
        }
        data = newData;
    }

}
