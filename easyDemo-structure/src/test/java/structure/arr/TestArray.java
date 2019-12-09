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
        System.out.println("limit=" + intArr.getLimit());
        //测试扩容
        int a = 0;
        while (a < 20) {
            intArr.add(a++, a);
        }
        System.out.println("arrLength add=" + intArr.getLimit());
        //测试减少容量
        a = 0;
        while (a < 19) {
            intArr.removeFirst();
            a++;
        }
        System.out.println("arrLength remove=" + intArr.getLimit());
        System.out.println(intArr);
    }
}
