package structure.tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        threeSum(nums);
//        int[] index = {0, 1, 2, 3, 0};
//        int[][] indexs = {{1, 1}, {3, 4}, {-1, 0}};
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
//        System.out.println(createTargetArray(nums, index));
//        System.out.println(minTimeToVisitAllPoints(indexs));

//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
//        sort(arr);

//        int[] coins = {2, 3, 10};
//        System.out.println(minCount(coins));


//        System.out.println(balancedStringSplit("RLRRLLRLRL"));
//        int[] a = {3, 12, 24, 37, 45, 53, 61, 78, 90, 100};
//        int m = binarysearch(a, 10, 100);


//        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
//        int target = 0;
//        System.out.println(search(nums1, target));

//        int[] a = {-1, -2, 1, 2, 3};
////        System.out.println(moveZeroes(a));
//        System.out.println(maximumProduct(a));
//        int[] numss = {1,12,-5,-6,50,3};
//        System.out.println(findMaxAverage(numss, 4));

//        int[] a = {2, 3, 5, 1, 3};
//        int b = 3;
//        System.out.println(kidsWithCandies(a, b));

//        int[] a = {2, 5, 1, 3, 4, 7};
//        int[] b = shuffle(a, 3);
//        for (int i : b) {
//            System.out.println(i);
//        }

//        String text = "To be or not to be";
//        System.out.println(arrangeWords(text));
//        int n=4;
//        System.out.println(climbStairs(n));
//        int[] arr = {400};
//        Arrays.stream(replaceElements(arr)).boxed().forEach(System.out::println);
//        String[] strings = {"c", "acc", "ccc"};
//        System.out.println(longestCommonPrefix(strings));
//        int[] nums = {8,4,6,2,3};
//        Arrays.stream(finalPrices(nums)).boxed().forEach(System.out::println);

//        String s = "(()())(())(()(()))";
//        System.out.println(removeOuterParentheses(s));

//        int[][] a = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
//        System.out.println(countNegatives(a));
//        String s = "HELLO";
//        System.out.println(toLowerCase(s));

//        Arrays.stream(sumZero(5)).boxed().forEach(System.out::println);

//        int[] a = {-4, -1, 10, 3, 0};
//        Arrays.stream(sortedSquares1(a)).boxed().forEach(System.out::println);
//        System.out.println(missingNumber(a));
//        System.out.println(maxScoreSightseeingPair(a));
//        System.out.println(maximum(1, 2));
//        String s = "0P";
//        System.out.println(isPalindrome(s));
        String num = "Let's take LeetCode contest";
        sortString("eaimykhkgxr");

    }


    //数据左移
    public static String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n));
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
        List<String> copylist = new ArrayList<>();
        int count = 0;
        char[] strs = s.toCharArray();
        int length = strs.length;
        int beginIndex = 0;
        for (int i = 0; i <= length - 1; i++) {
            beginIndex = list.indexOf(strs[i] + "");
            if (beginIndex > -1) {
                if (count < list.size()) {
                    count = list.size();
                }
                for (int j = beginIndex + 1; j <= list.size() - 1; j++) {
                    copylist.add(list.get(j));
                }
                list = new ArrayList<>();
                list.addAll(copylist);
                copylist = new ArrayList<>();
            }
            list.add(strs[i] + "");
            if (i == length - 1) {
                if (count < list.size()) {
                    count = list.size();
                }
            }
        }
        return count;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        List<Integer> leftList = rightSideView(root.left);//左子树生成的列表
        List<Integer> rightList = rightSideView(root.right);//右子树生成的列表

        int max = Math.max(leftList.size(), rightList.size());//左右子树列表的最大长度
        List<Integer> list = new ArrayList<Integer>(max);//最终合成的列表
        list.add(root.val);//先把当前节点加入最终列表
        for (int i = 0; i < max; i++) {//优先加入右子树的列表元素，若右子树加完了，则开始加入左子树列表
            if (i < rightList.size()) {
                list.add(rightList.get(i));
            } else {
                list.add(leftList.get(i));
            }
        }
        return list;
    }

    static int total;

    public static int fib01(int n) {
        if (n == 0)
            return 1;
        if (n == 1 || n == 2)
            return n;
        int result = (int) Math.floor(
                1 / Math.sqrt(5) * (Math.pow((1 + Math.sqrt(5)) / 2, n + 1) - Math.pow((1 - Math.sqrt(5)) / 2, n + 1)));
        return result;
    }

    //给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
    //目标数组 target 最初为空。
    //按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
    //重复上一步，直到在 nums 和 index 中都没有要读取的元素。
    //请你返回目标数组。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/create-target-array-in-the-given-order
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int[] createTargetArray(int[] nums, int[] index) {
        int length = nums.length;
        int[] result = new int[nums.length];
        if (length == 0) {
            return result;
        }

        //解法1:利用list的add特性
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i <= length - 1; i++) {
//            list.add(index[i], nums[i]);
//        }
//        for (int i = 0; i <= list.size() - 1; i++) {
//            result[i] = list.get(i);
//        }

        //解法2:先排好index的数列
        for (int i = 0; i <= length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (index[i] <= index[j] && i != j) {
                    index[j] = index[j] + 1;
                }
            }
        }
        for (int i = 0; i <= length - 1; i++) {
            result[index[i]] = nums[i];
        }
        return result;
    }

    //平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
    //你可以按照下面的规则在平面上移动：
    //每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
    //必须按照数组中出现的顺序来访问这些点。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/minimum-time-visiting-all-points
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int minTimeToVisitAllPoints(int[][] points) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < points.length - 1; i++) {
            a = Math.abs(points[i + 1][0] - points[i][0]);
            b = Math.abs(points[i + 1][1] - points[i][1]);
            c += Math.max(a, b);
        }
        return c;
    }


    //归并排序
    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);//左边归并排序，使得左子序列有序
            sort(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
            merge(arr, left, mid, right, temp);//将两个有序子数组合并操作
            System.out.println(left + "---" + right + "-----" + mid);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            System.out.println("i==" + i);
            System.out.println("j==" + j);
            if (arr[i] <= arr[j]) {
                System.out.println("step1");
                temp[t++] = arr[i++];
            } else {
                System.out.println("step2");
                temp[t++] = arr[j++];
            }
        }


        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }

        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }


        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }

        for (int a : arr) {
            System.out.println(a);
        }
    }

    //桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
    public static int minCount(int[] coins) {
        int length = coins.length;
        int count = 0;
        for (int i = 0; i <= length - 1; i++) {
            //如果是基数
            if ((coins[i] & 1) == 1) {
                count += (coins[i] >> 1) + 1;
            } else {
                count += coins[i] >> 1;
            }
        }
        return count;
    }

    //在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
    //给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
    //返回可以通过分割得到的平衡字符串的最大数量。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int balancedStringSplit(String s) {
        int num = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L')
                num++;
            else
                num--;
            if (num == 0)
                res++;
        }
        return res;
    }


    //二分查找
    static int binarysearch(int a[], int n, int value) {
        int left = 0;
        int right = n - 1;
        while (left <= right)     //注意等号，当查询为最后一个元素时需要用到等号
        {
            int middle = left + ((right - left) >> 1);   //位移运算防溢出（借鉴）
            //理解是(left+right)/2,会超过int型范围
            if (value < a[middle])
                right = middle - 1;            //在前半区
            else if (value > a[middle])
                left = middle + 1;            //在后半区
            else
                return middle;
        }
        return -1;        //没有找到
    }


    //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    //搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    //你可以假设数组中不存在重复的元素。
    //你的算法时间复杂度必须是 O(log n) 级别。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            //在左边
            if (nums[left] <= nums[mid]) {
                //如果目标数字大于等于当前数且小于等于中位数
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                //在右边
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    //
    public static List<Integer> moveZeroes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        //第二遍扫描，找到所有非负数，非负数所在的下标+1，即为缺失的数字
        for (int i = 1; i <= nums.length; ++i) {
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        return result;
    }


    //给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
    public static int maximumProduct(int[] nums) {
        TreeSet<Integer> integers = new TreeSet<>((a, b) -> {
            return a - b;
        });
        int multiplication = 1;
        for (int a : nums) {
            integers.add(a);
            if (integers.size() > 3) {
                integers.remove(integers.first());
            }
        }

        for (int a : integers) {
            multiplication *= a;
        }
        return multiplication;
    }

    //给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
    public static double findMaxAverage(int[] nums, int k) {
//        int count = 0, maxCount = 0;
//        int compareCount = 0;
//        //算出K个数的和
//        for (int i = 0; i < k; i++) {
//            count += nums[i];
//            maxCount = count;
//        }
//        for (int j = k; j < nums.length; j++) {
//            compareCount = count - nums[j - k] + nums[j];
//            if (Math.max(count, compareCount) > maxCount) {
//                maxCount = Math.max(count, compareCount);
//            }
//            count = compareCount;
//        }
//        return (double) maxCount / k;
        for (int i = 1; i < k; i++) {//前面k-1个元素和单独计算
            nums[i] += nums[i - 1];
        }
        int sum = nums[k - 1];//此时第k-1号元素即前k-1(包括k-1)个元素的和
        for (int i = k; i < nums.length; i++) {
            nums[i] += nums[i - 1];//前i个元素的和赋值给nums[i]
            sum = Math.max(sum, nums[i] - nums[i - k]);//判断比较记录最大sum值
        }
        return sum * 1.0 / k;
    }


    //给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
    //对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> booleans = new ArrayList<>();
        if (candies.length == 0) {
            return booleans;
        }
        int[] copyCandies = candies.clone();
        Arrays.sort(copyCandies);
        int length = candies.length;
        for (int i = 0; i < length; i++) {
            int count = candies[i] + extraCandies;
            booleans.add(copyCandies[copyCandies.length - 1] <= count);
        }
        return booleans;
    }

    //    请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//    例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
//    提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/daily-temperatures
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int[] dailyTemperatures(int[] T) {
//        int length = T.length;
//        int[] dailyTemperatures = new int[length];
//        for (int i = 0; i < length - 1; i++) {
//            int day = 1;
//            for (int j = i + 1; j < length; j++) {
//                if (T[i] >= T[j]) {
//                    day++;
//                } else {
//                    dailyTemperatures[i] = day;
//                    break;
//                }
//            }
//        }
//        return dailyTemperatures;

        //2 堆栈解法
//        Stack<Integer> stack = new Stack<>();
//        int[] ret = new int[T.length];
//        for (int i = 0; i < T.length; i++) {
//            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
//                int idx = stack.pop();
//                ret[idx] = i - idx;
//            }
//            stack.push(i);
//        }
//        return ret;
        int[] res = new int[T.length];
        //从后面开始查找
        for (int i = res.length - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < res.length) {
                if (T[j] > T[i]) {
                    //如果找到就停止while循环
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    //如果没找到，并且res[j]==0。说明第j个元素后面没有
                    //比第j个元素大的值，因为这一步是第i个元素大于第j个元素的值，
                    //那么很明显这后面就更没有大于第i个元素的值。直接终止while循环。
                    break;
                } else {
                    //如果没找到，并且res[j]！=0说明第j个元素后面有比第j个元素大的值，
                    //然后我们让j往后挪res[j]个单位，找到那个值，再和第i个元素比较
                    j += res[j];
                }
            }
        }
        return res;
    }


    //    给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
//    请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/shuffle-the-array
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n << 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            ans[index++] = nums[i];
            ans[index++] = nums[n + i];
        }
        return ans;
    }


    //    「句子」是一个用空格分隔单词的字符串。给你一个满足下述格式的句子 text :
//    句子的首字母大写
//    text 中的每个单词都用单个空格分隔。
//    请你重新排列 text 中的单词，使所有单词按其长度的升序排列。如果两个单词的长度相同，则保留其在原句子中的相对顺序。
//    请同样按上述格式返回新的句子。
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/rearrange-words-in-a-sentence
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static String arrangeWords(String text) {
//        String[] arrays = text.toLowerCase().split(" ");
//        List<String> stringList = Stream.of(arrays).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
//        String newString = String.join(" ", stringList);
//        return newString.substring(0, 1).toUpperCase().concat(newString.substring(1));
        //2
        if (text.length() == 0) {
            return text;
        }
        // 寻找一种稳定算法
        final String s = text.toLowerCase();
        final String[] words = s.split(" ");
        if (words.length <= 1) {
            return text;
        }
        // 构建一个SortedMap
        final TreeMap<Integer, LinkedList<String>> map = new TreeMap<>();
        for (String word : words) {
            map.putIfAbsent(word.length(), new LinkedList<>());
            final LinkedList<String> list = map.get(word.length());
            list.add(word);
        }
        int i = 0;
        for (Map.Entry<Integer, LinkedList<String>> entry : map.entrySet()) {
            final LinkedList<String> value = entry.getValue();
            for (String s1 : value) {
                words[i] = s1;
                i++;
            }
        }
        // 将word[0]的首字母大小
        words[0] = words[0].substring(0, 1).toUpperCase() + (words[0].length() > 1 ? words[0].substring(1) : "");
        return String.join(" ", words);
    }


//    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
//    注意：答案中不可以包含重复的三元组。
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/3sum
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //最外层循环数组主体
        List<List<Integer>> resultIntList = new ArrayList<>();
        for (int startPoint = 0; startPoint < nums.length - 2; startPoint++) {
            //如果取出最小的头指针大于0直接跳出
            if (nums[startPoint] > 0) break;
            //如果头指针大于0且头指针递增后发现和递增前相同
            if (startPoint > 0 && nums[startPoint] == nums[startPoint - 1]) continue;
            //定义左指针(头指针+1)和右指针(默认尾部)
            int rightPoint = nums.length - 1, leftPoint = startPoint + 1;
            while (leftPoint < rightPoint) {
                //得到和
                int sum = nums[startPoint] + nums[leftPoint] + nums[rightPoint];
                //如果和小于0则表示左指针需要加一位,同时判断是否与之前元素相等,相等就再后移一位
                if (sum < 0) {
                    while (startPoint < rightPoint && nums[startPoint] == nums[++startPoint]) ;
                } else if (sum > 0) {
                    while (startPoint < rightPoint && nums[rightPoint] == nums[--rightPoint]) ;
                } else {
                    //如果等于0就加入列表,并同时执行左右指针前后各移动一位
                    resultIntList.add(new ArrayList<Integer>(Arrays.asList(nums[startPoint], nums[leftPoint], nums[rightPoint])));
                    while (startPoint < rightPoint && nums[startPoint] == nums[++startPoint]) ;
                    while (startPoint < rightPoint && nums[rightPoint] == nums[--rightPoint]) ;
                }
            }
        }
        return resultIntList;
    }

    //    给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
    //    题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
    //    来源：力扣（LeetCode）
    //    链接：https://leetcode-cn.com/problems/destination-city
    //    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static String destCity(List<List<String>> paths) {
        Set<String> begin = paths.stream().map(x -> x.get(0)).collect(Collectors.toSet());
        Set<String> end = paths.stream().map(x -> x.get(1)).collect(Collectors.toSet());
        end.removeAll(begin);
        String[] a = new String[1];
        end.toArray(a);
        return a[0];
    }


    // 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    // 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //1299. 将每个元素替换为右侧最大元素
    //给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
    //完成所有替换操作后，请你返回这个数组。
    public static int[] replaceElements(int[] arr) {
        int length = arr.length;
        int[] resultInt = new int[length];
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            resultInt[i] = max;
            max = Math.max(arr[i], max);
        }
        return resultInt;
    }

    //14. 最长公共前缀
    //    编写一个函数来查找字符串数组中的最长公共前缀。
    //    如果不存在公共前缀，返回空字符串 ""。
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0 || strs[0].length() == 0) {
            return "";
        }
        int countLength = strs[0].length();
        int i = 1;
        while (i < length && countLength > 0)
            if (!strs[i].startsWith(strs[0].substring(0, countLength))) {
                countLength--;
            } else {
                i++;
            }
        return strs[0].substring(0, countLength);
    }

    //    给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
    //    请返回 nums 的动态和。
    //    来源：力扣（LeetCode）
    //    链接：https://leetcode-cn.com/problems/running-sum-of-1d-array
    //    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] resultInt = new int[nums.length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            count += nums[i];
            resultInt[i] = count;
        }
        return resultInt;
    }

    //    给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
//    商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
//    请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int[] finalPrices(int[] prices) {
        int length = prices.length;
        for (int i = 0; i < length; i++) {
            int min = 0;
            int j = i + 1;
            while (j < length) {
                if (prices[i] >= prices[j]) {
                    min = prices[j];
                    break;
                }
                j++;
            }
            prices[i] = prices[i] - min;
        }
        return prices;
    }


    //    有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
//    如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
//    给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
//    对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
//    来源：力扣（LeetCode）( ()() ) ( () ) ( ()(()) )
//    链接：https://leetcode-cn.com/problems/remove-outermost-parentheses
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static String removeOuterParentheses(String S) {
//        StringBuilder builder = new StringBuilder();
//        int countLeft = 0, countRight = 0, point = 0;
//        for (int i = 0; i < S.length(); i++) {
//            char a = S.charAt(i);
//            if (a == '(') countLeft++;
//            else if (a == ')') countRight++;
//            if (countLeft == countRight) {
//                builder.append(S, point + 1, countRight + countLeft - 1);
//                point = i + 1;
//            }
//        }
//        return builder.toString();
        StringBuilder sb = new StringBuilder();
        int mark = -1;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                mark++;
            }
            if (c == ')') {
                mark--;
            }
            if (mark == 0 && c == '(' || mark == -1 && c == ')') {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    //    给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
//    请你统计并返回 grid 中 负数 的数目。
    //https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/
    public static int countNegatives(int[][] grid) {
        //先把数组加入流中,李咏flatmap扁平化得到intStream流.再过滤小于0的值
        return (int) Arrays.stream(grid).flatMapToInt(Arrays::stream).filter(n -> n < 0).count();
    }

    //实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
    //https://leetcode-cn.com/problems/to-lower-case/
    public static String toLowerCase(String str) {
        StringBuffer StringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            //是否大写c >=65 && c <= 90
            //是否小写c >=97 && c <= 122
            if (a >= 65 && a <= 90) {
                a += 32;
            }
            StringBuffer.append(a);
        }
        return StringBuffer.toString();
    }

    //给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
    //https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero/
    public static int[] sumZero(int n) {
        int[] nums = new int[n];
        //如果n是奇数且不等于2的时候,把n减一
        if ((n & 1) == 1 && n != 2) {
            n -= 1;
        }
        //用无限流生成一个正数递增为2的集合,大小为n/2
        List<Integer> c = Stream.iterate(1, a -> a + 2).limit(n / 2).collect(Collectors.toList());
        //依次赋值到数组取反形成对称
        for (int i = 0; i < c.size(); i++) {
            nums[i] = c.get(i);
            nums[n - 1 - i] = -c.get(i);
        }
        return nums;
    }

    //给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
//    一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
//    返回一对观光景点能取得的最高分。
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-sightseeing-pair
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int maxScoreSightseeingPair(int[] A) {

        //暴力超时方案
//        int minusMax = 0, plusMax = 0;
//        for (int i = 1; i < A.length; i++) {
//            if (A[i] - i >= minusMax || minusMax - A[i] - i < i) {
//                minusMax = A[i] - i;
//                int j = -1;
//                while (++j < i) plusMax = Math.max(minusMax + A[j] + j, plusMax);
//            }
//        }
//        return plusMax;

        //贪心算法
        int leftA = A[0], plusMax = 0;
        for (int i = 1; i < A.length; i++) {
            plusMax = Math.max(plusMax, A[i] - i + leftA);
            leftA = Math.max(leftA, A[i] + i);
        }
        return plusMax;
    }


    //    在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
//    移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
//    注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/robot-return-to-origin
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean judgeCircle(String moves) {
        int count = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'R':
                    count++;
                    break;
                case 'L':
                    count--;
                    break;
                case 'U':
                    count += 2;
                    break;
                case 'D':
                    count -= 2;
                    break;
            }
        }
        return count == 0;
    }


    //    一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int missingNumber(int[] nums) {
        //二分查找
        int startPoint = 0, endPoint = nums.length - 1;
        while (startPoint <= endPoint) {
            int midPoint = startPoint + ((endPoint - startPoint) >> 1);
            if (nums[midPoint] == midPoint) startPoint = midPoint + 1;
            else endPoint = midPoint - 1;
        }
        return startPoint;
    }

    //    给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/array-partition-i
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        Long a = IntStream.range(0, nums.length)
                .filter(i -> i % 2 != 0)
                .mapToLong(i -> nums[i]).sum();
        return a.intValue();
    }

    //给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
    //https://leetcode-cn.com/problems/squares-of-a-sorted-array/
    public int[] sortedSquares(int[] A) {
        return Arrays.stream(A).mapToLong(n -> n * n).boxed().sorted().mapToInt(Long::intValue).toArray();
    }

    //给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
    //https://leetcode-cn.com/problems/squares-of-a-sorted-array/
    public static int[] sortedSquares1(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int[] temp = new int[A.length];
        int currentIndex = right;
        while (left <= right) {
            if (Math.abs(A[left]) <= Math.abs(A[right])) {
                temp[currentIndex--] = (int) Math.pow(A[right], 2);
                right--;
            } else {
                temp[currentIndex--] = (int) Math.pow(A[left], 2);
                left++;
            }
        }
        return temp;
    }

    //    面试题 16.07. 最大数值
//    编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
    //https://leetcode-cn.com/problems/maximum-lcci/
    public static int maximum(int a, int b) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(a, a);
        map.put(b, b);
        return map.firstKey();
    }


    //    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//    说明：本题中，我们将空字符串定义为有效的回文串。
//    https://leetcode-cn.com/problems/valid-palindrome/
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char a = s.charAt(left);
            char b = s.charAt(right);
            //不为数字,大小写字母
            if (!(a >= 48 && a <= 57 || a >= 65 && a <= 90 || a >= 97 && a <= 122)) {
                left++;
                continue;
            }
            //不为数字,大小写字母
            if (!(b >= 48 && b <= 57 || b >= 65 && b <= 90 || b >= 97 && b <= 122)) {
                right--;
                continue;
            }
            if (Character.toUpperCase(a) != Character.toUpperCase(b)) {
                return Boolean.FALSE;
            } else {
                left++;
                right--;
            }
        }
        return Boolean.TRUE;
    }

    //给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
    //https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        for (String x : s.split(" ")) {
            if (result.length() != 0) {
                result.append(" ");
            }
            result.append(new StringBuilder(x).reverse());
        }
        return result.toString();
    }


    //    我们把符合下列属性的数组 A 称作山脉：
//    A.length >= 3
//    存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
//    给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            //如果中点前一个山峰高度<=中点且它小于后一个,说明在右边
            if (A[mid - 1] <= A[mid] && A[mid] <= A[mid + 1]) {
                left = mid + 1;
                //如果中点前一个山峰高度<=中点且它小于后一个,说明在右边
            } else if (A[mid - 1] >= A[mid] && A[mid] >= A[mid + 1]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

//    给你一个字符串 s ，请你根据下面的算法重新构造字符串：
//    从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
//    从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
//    重复步骤 2 ，直到你没法从 s 中选择字符。
//    从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
//    从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
//    重复步骤 5 ，直到你没法从 s 中选择字符。
//    重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
//    在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
//    请你返回将 s 中字符重新排序后的 结果字符串 。
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/increasing-decreasing-string
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    输入：s = "aaaabbbbcccc"
//    输出："abccbaabccba"
//    解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
//    第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
//    第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
//    第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
//    第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
//
//    输入：s = "leetcode"
//    输出："cdelotee"

    //    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/increasing-decreasing-string
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static String sortString(String s) {
//        StringBuilder sb = new StringBuilder();
//        int[] alphabet = new int['z' - 'a' + 2];
//        //算出每个字母出现的次数
//        for (char c : s.toCharArray())
//            alphabet[c - 'a' + 1]++;
//        int i = 0, n = 1;
//        boolean b = Boolean.TRUE;
//        while (i < s.length()) {
//            //获取第一位
//            if (alphabet[n] > 0) {
//                char a = (char) (n + 'a' - 1);
//                sb.append(a);
//                alphabet[n]--;
//                i++;
//            }
//            if (n == 25) {
//                b = Boolean.FALSE;
//            }
//            if (n == 0) {
//                b = Boolean.TRUE;
//            }
//            n += b ? 1 : -1;
//        }
//        return sb.toString();
        StringBuilder sb = new StringBuilder();
        int[] alphabet = new int[28];
        for (char c : s.toCharArray())
            alphabet[c - 'a' + 1]++;
        int i = 0, n = 1;
        boolean b = true;
        while (i < s.length()) {
            if (alphabet[n] > 0) {
                sb.append((char) (n + 'a' - 1));
                alphabet[n]--;
                i++;
            }
            if (n == 27)
                b = false;
            if (n == 0)
                b = true;
            n += b ? 1 : -1;
        }
        return sb.toString();
    }
}
