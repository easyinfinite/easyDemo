package structure.tree;

import java.util.*;

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


//        String s = "abcdefg";
//        int k = 2;

//        System.out.println(reverseLeftWords(s, k));

//        System.out.println(numberOfSteps(8));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
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

    //给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
    public static int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            product *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return product - sum;
    }

    //给你一个整数数组 nums 和一个整数 k。
    //如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
    //请返回这个数组中「优美子数组」的数目。
    public static int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length, res = 0, feed = 0, arr[] = new int[len + 2];
        for (int i = 0; i < len; i++) {
            // if it is odd
            if ((nums[i] & 1) == 1) {
                arr[++feed] = i;
            }
        }
        arr[0] = -1;
        arr[feed + 1] = len;
        for (int i = 1; i + k < feed + 2; i++) {
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }
        return res;
    }

    //给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            String numForString = String.valueOf(num);
            if ((numForString.length() & 1) == 0) {
                count++;
            }
        }
        return count;
    }

    //给你一个以行程长度编码压缩的整数列表 nums 。
    //考虑每对相邻的两个元素 freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
    //请你返回解压后的列表。
    public static int[] decompressRLElist(int[] nums) {
        int[] arr = new int[0];
        int arrIndex = 0, beforeIndex = 1;
        if ((nums.length & 1) == 1) {
            return arr;
        }
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            //如果下标是奇数
            if (((i + 1) & 1) == 1) {
                arrIndex += nums[i];
            }
        }
        arr = new int[arrIndex];
        for (int i = 0; i < length - 1; i++) {
            //如果下标是奇数
            if (((i + 1) & 1) == 1) {
                for (int j = 0; j < nums[i]; j++) {
                    arr[beforeIndex - 1 + j] = nums[i + 1];
                }
                beforeIndex += nums[i];
            }
        }
        return arr;
    }

    //给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
    //换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int length = nums.length;
        int[] greatNums = new int[nums.length];
        int[] numsClone = nums.clone();
        Arrays.sort(nums);
        List<Integer> numList = new ArrayList<Integer>(nums.length);
        for (int num : nums) {
            numList.add(num);
        }
        for (int i = 0; i < length; i++) {
            greatNums[i] = numList.indexOf(numsClone[i]);
        }
        return greatNums;
    }

    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        List<String> list = new ArrayList<>();
        int count = 0;
        char[] strs = s.toCharArray();
        int length = strs.length;
        char lastOne = 0;
        for (int i = 0; i <= length - 1; i++) {
            if (list.indexOf(strs[i] + "") > -1) {
                if (count < list.size()) {
                    count = list.size();
                    if (list.indexOf(strs[i] + "") == 0) {
                        count++;
                    }
                }
                list = new ArrayList<>();
                if (strs[i] != lastOne) {
                    list.add(lastOne + "");
                }
            }
            list.add(strs[i] + "");
            lastOne = strs[i];
            if (i == length - 1) {
                if (count < list.size()) {
                    count = list.size();
                }
            }
        }
        return count;
    }
}
