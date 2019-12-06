package structure.arr;

import com.structure.arr.Array;

/**
 * @ClassName:TestArray
 * @Description 数组测试类
 * @Author: chenyunxuan
 * @Date: 2019-12-06 17:26
 * @version: 1.0.0
 **/
public class TestArray {
    public static void main(String[] args) {
        //初始化数组(不可用基本类型)
        Array<Integer> intArr = new Array<>();
        System.out.println("size=" + intArr.getSize());
        System.out.println("limit=" + intArr.getLimit());
        intArr.addLast(2);
        intArr.addFirst(5);
        intArr.add(2, 11);
        System.out.println(intArr.remove(2));
        System.out.println(intArr.romoveLast());
        System.out.println(intArr);
    }
}
