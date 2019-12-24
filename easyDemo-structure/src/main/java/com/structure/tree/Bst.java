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

    /**
     * @description: 根节点
     * @author: chenyunxuan
     * @updateTime: 2019-12-24 17:19
     */
    private Node root;
    /**
     * @description: 元素总数
     * @author: chenyunxuan
     * @updateTime: 2019-12-24 17:19
     */
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

    /**
     * @description: 二分搜索树插入
     * @author: chenyunxuan
     * @updateTime: 2019-12-24 16:56
     */
    public void add(E e) {
        //第一种解法
        //如果根节点为空
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
        root = addPro(root, e);
    }

    /**
     * @description: 递归算法解决搜索树的增加(第一种解法)
     * @author: chenyunxuan
     * @updateTime: 2019-12-24 18:01
     */
    private void add(Node node, E e) {
        //如果元素与节点的元素相等就返回
        if (e.equals(node.e)) {
            return;
            //如果小于该节点且节点的左边为空
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
            //如果小于该节点且节点的右边为空
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        //递归写法
        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }

    }

    /**
     * @description: 简化上面add方法的思路
     * @author: chenyunxuan
     * @updateTime: 2019-12-24 18:19
     */
    private Node addPro(Node node, E e) {
        //node为空时,就肯定会加入一个新的node,写入e
        if (node == null) {
            size++;
            return new Node(e);
        }

        //接下来判断与e元素的大小
        if (e.compareTo(node.e) < 0) {
            addPro(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            addPro(node.right, e);
        }

        //最后经过了所有递归返回参数
        return node;
    }

}
