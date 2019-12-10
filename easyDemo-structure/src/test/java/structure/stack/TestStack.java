package structure.stack;

import com.structure.stack.ArrayStack;

/**
 * @ClassName:TestStack
 * @Description 测试栈
 * @Author: chenyunxuan
 * @Date: 2019-12-10 19:20
 * @version: 1.0.0
 **/
public class TestStack {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        for (int a = 0; a < 10; a++) {
            arrayStack.push(a);
        }
        System.out.println(arrayStack);

        arrayStack.pop();
        arrayStack.pop();
        System.out.println(arrayStack);
    }

}
