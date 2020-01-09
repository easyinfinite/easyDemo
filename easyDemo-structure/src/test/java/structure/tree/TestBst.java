package structure.tree;

import com.structure.tree.Bst;

import java.util.Set;

/**
 * @ClassName:TestStack
 * @Description 测试栈
 * @Author: chenyunxuan
 * @Date: 2019-12-10 19:20
 * @version: 1.0.0
 **/
public class TestBst {

    public static void main(String[] args) {
        Bst<Integer> bst = new Bst<>();
        int[] nums = {5, 3, 2, 4, 6, 8};

        for (int num : nums) {
            bst.add(num);
        }
//        bst.preOrder(1);
//        System.out.println("[][][][]");
        bst.afterOrderWithoutRecursive();
//        System.out.println(bst);
    }

}
