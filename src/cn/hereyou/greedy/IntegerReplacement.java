package cn.hereyou.greedy;


/**
 * [397]. 整数替换
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * 返回 n 变为 1 所需的 最小替换次数 。
 */
public class IntegerReplacement {


    public int integerReplacement(int n) {
        int steps = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n == 3 || ((n >>> 1) & 1) == 0) {
                n--; // 对于3或下一个是偶数的奇数，减1
            } else {
                n++; // 对于其他奇数，加1
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        IntegerReplacement ir = new IntegerReplacement();
        System.out.println(ir.integerReplacement(397)); // 输出最小替换次数
    }
}
