package cn.hereyou.dp;

/**
 *
 * [70]动态规划经典例题算法
 *
 */
public class ClimbingStairs {


    public static void main(String[] args) {
        int n = 10; // 假设楼顶有 10 个台阶
        System.out.println("Total number of ways to climb to the top: " + climbStairs(n));
    }

    public static int climbStairs(int n) {
        // 如果楼梯是 0 级或 1 级，只有一种方法
        if (n == 0) return 0;
        if (n == 1) return 1;

        // 创建一个数组 dp 来存储到达每个台阶的方法数
        int[] dp = new int[n + 1];

        // 初始化前两个台阶的方法数
        dp[0] = 1; // 只有一种方法到达台阶 0（什么都不做）
        dp[1] = 1; // 只有一种方法到达台阶 1（一次爬 1 个台阶）

        // 从台阶 2 开始计算到达每个台阶的方法数
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}










}
