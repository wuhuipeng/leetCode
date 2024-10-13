package cn.hereyou.dp;

/**
 *
 * [746]. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];

        // dp[i] 表示到达第 i 个台阶的最低花费
        int[] dp = new int[n + 1];
        dp[0] = 0; // 从地面开始
        dp[1] = cost[0]; // 从第0个台阶到第1个台阶的费用

        for (int i = 2; i <= n; i++) {
            // 如果 i = n，cost[n-1] 不存在，所以只考虑到 dp[n-1]
            int stepCost = (i == n) ? 0 : cost[i - 1];
            dp[i] = Math.min(dp[i - 1] + stepCost, dp[i - 2] + stepCost);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs solution = new MinCostClimbingStairs();
        int[] cost = {10, 15, 20,1,400,1,1,232,1,233};
        int minCost = solution.minCostClimbingStairs(cost);
        System.out.println("Minimum cost to reach the top: " + minCost); // 输出: 15
    }
}
