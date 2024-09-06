package cn.hereyou.dp;

/**
 * [53]. 最大子数组和
 */
public class MaxSubArrSum {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < nums.length; i++) {
            sum=Math.max(sum+nums[i],nums[i]); // 取和还是取单个元素
             max=Math.max(sum,max); //记录最大值
        } return max;

    }
}
