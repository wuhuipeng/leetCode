package cn.hereyou.dp;

/**
 * [509]. 斐波那契数
 */
public class Fibonacci {

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n + 1]; // 创建一个数组来存储结果
        dp[0] = 0; // F(0)
        dp[1] = 1; // F(1)

        // 计算 F(2) 到 F(n)
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n]; // 返回 F(n)
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int n = 10; // 计算 F(10)
        int result = fibonacci.fib(n);
        System.out.println("F(" + n + ") = " + result); // 输出: F(10) = 55
    }
}
