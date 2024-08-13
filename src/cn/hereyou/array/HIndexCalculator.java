package cn.hereyou.array;

import java.util.Arrays;

public class HIndexCalculator {

    public static int hIndex(int[] citations) {
        // 将引用次数从高到低排序
        Arrays.sort(citations);

        int n = citations.length;
        for (int i = 0; i < n; i++) {
            // 计算当前的 h 指数
            int h = n - i;
            // 如果当前论文的引用次数小于等于当前的 h 指数，则返回 h 指数
            if (citations[i] >= h) {
                return h;
            }
        }
        // 如果没有找到符合条件的 h 指数，返回 0
        return 0;
    }

    public static void main(String[] args) {
        // 示例使用
        int[] citations = {6, 5, 3, 1, 0};
        System.out.println(hIndex(citations));  // 输出: 3
    }
}
