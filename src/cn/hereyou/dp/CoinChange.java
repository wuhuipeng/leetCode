package cn.hereyou.dp;

import java.util.Arrays;

/**
 *
 *
 * 背包问题-完全】 [322]. 零钱兑换
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            // For each coin denomination, check if it can contribute to the current amount
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    public static void main(String[] args) {

        CoinChange coinChange=new CoinChange();
        coinChange.coinChange(new int[]{1,2,5},13);
    }
}
