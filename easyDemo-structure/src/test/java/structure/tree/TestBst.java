package structure.tree;

/**
 * @ClassName:TestStack
 * @Description 测试栈
 * @Author: chenyunxuan
 * @Date: 2019-12-10 19:20
 * @version: 1.0.0
 **/
public class TestBst {

    public static void main(String[] args) {
//        Bst<Integer> bst = new Bst<>();
//        int[] nums = {5, 3, 2, 4, 6, 8};
//
//        for (int num : nums) {
//            bst.add(num);
//        }
////        bst.preOrder(1);
////        System.out.println("[][][][]");
//        bst.afterOrderWithoutRecursive();
//        System.out.println(bst);


        String s = "abcdefg";
        int k = 2;

//        System.out.println(reverseLeftWords(s, k));

        System.out.println(numberOfSteps(8));
    }

    //数据左移
    public static String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n, s.length()));
        sb.append(s.substring(0, n));
        return sb.toString();
    }


    //给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
    public static int numberOfSteps(int num) {
        return numberOfSteps1(num, 0);
    }

    public static int numberOfSteps1(int num, int stepNum) {
        if (num % 2 != 0) {
            num = num - 1;
        } else {
            num = num / 2;
        }
        stepNum++;
        if (num == 0) {
            return stepNum;
        } else {
            return numberOfSteps1(num, stepNum);
        }
    }

}
