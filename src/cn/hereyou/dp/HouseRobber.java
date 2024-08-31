package cn.hereyou.dp;

/**
 * [198]打家劫舍
 */
public class HouseRobber {


    public static int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        // dp数组初始化
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            // 选择不偷窃当前房屋 i，即最大金额为 dp[i-1]
            // 或选择偷窃当前房屋 i，即最大金额为 dp[i-2] + nums[i]
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] houses = {2, 12, 9, 9, 13,2};
        System.out.println("Maximum amount that can be robbed: " + rob(houses));
    }
}
