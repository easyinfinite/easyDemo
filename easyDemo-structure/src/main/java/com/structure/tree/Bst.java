package com.structure.tree;

/**
 * @ClassName: Bst
 * @Description 定义实现一个二分搜索树
 * @Author: chenyunxuan
 * @Date: 2019-12-24 15:58
 * @version: 1.0.0
 **/
public class Bst<E extends Comparable<E>> {


    /**
     * @description: Node节点内部类
     * @author: chenyunxuan
     * @updateTime: 2019-12-24 16:09
     */
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    /**
     * @description: 构造方法
     * @author: chenyunxuan
     * @updateTime: 2019-12-24 16:13
     */
    public Bst() {
        root = null;
        size = 0;
    }

    /**
     * @description: 二分搜索树数据总数
     * @author: chenyunxuan
     * @updateTime: 2019-12-24 16:17
     */
    public int getSize() {
        return size;
    }

    /**
     * @description: 二分搜索树是否为空
     * @author: chenyunxuan
     * @updateTime: 2019-12-24 16:17
     */
    public boolean isEmpty() {
        return size == 0;
    }

}
