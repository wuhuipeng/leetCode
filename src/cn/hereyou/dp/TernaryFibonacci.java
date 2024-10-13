package cn.hereyou.dp;

/**
 *
 * [1137]. 第 N 个泰波那契数
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 泰波那契序列 Tn 定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 */
public class TernaryFibonacci {
    public int tib(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // 创建数组来存储泰波那契数
        int[] T = new int[n + 1];
        T[0] = 0;
        T[1] = 1;
        T[2] = 1;

        // 计算 T(n) 值
        for (int i = 3; i <= n; i++) {
            T[i] = T[i - 1] + T[i - 2] + T[i - 3];
        }

        return T[n];
    }

    public static void main(String[] args) {
        TernaryFibonacci tf = new TernaryFibonacci();
        int n = 4; // 计算 T(4)
        int result = tf.tib(n);
        System.out.println("T(" + n + ") = " + result); // 输出: T(4) = 4
    }
}
