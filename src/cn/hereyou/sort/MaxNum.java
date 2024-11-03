package cn.hereyou.sort;


import java.util.Arrays;
import java.util.Comparator;

/**
 * [179]
 *给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 */
public class MaxNum {


    public String largestNumber(int[] nums) {
        // 将整数转换为字符串数组
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // 自定义排序规则
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // 先比较 a + b 和 b + a 的大小
                return (b + a).compareTo(a + b);
            }
        });

        // 特殊情况：如果最大的数字是 0，则返回 "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // 拼接排序后的字符串
        StringBuilder largestNum = new StringBuilder();
        for (String num : strNums) {
            largestNum.append(num);
        }

        return largestNum.toString();
    }

    public static void main(String[] args) {
        MaxNum ln = new MaxNum();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(ln.largestNumber(nums)); // 输出 "9534330"
    }

}
