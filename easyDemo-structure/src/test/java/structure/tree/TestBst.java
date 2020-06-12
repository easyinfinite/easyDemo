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
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
        int[] index = {0, 1, 2, 3, 0};
        int[][] indexs = {{1, 1}, {3, 4}, {-1, 0}};
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

}
