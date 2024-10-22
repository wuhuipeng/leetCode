package cn.hereyou.sort;

import java.util.Arrays;

/**
 * [455]. 分发饼干
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // 排序孩子的胃口值
        Arrays.sort(s); // 排序饼干的尺寸

        int childIndex = 0; // 孩子指针
        int cookieIndex = 0; // 饼干指针
        int count = 0; // 满足的孩子数量

        // 遍历孩子和饼干
        while (childIndex < g.length && cookieIndex < s.length) {
            if (s[cookieIndex] >= g[childIndex]) { // 如果饼干满足孩子
                count++; // 满足一个孩子
                childIndex++; // 移动到下一个孩子
            }
            cookieIndex++; // 移动到下一个饼干
        }

        return count; // 返回满足的孩子数量
    }

    public static void main(String[] args) {
        AssignCookies solution = new AssignCookies();
        int[] g = {7, 2, 6}; // 孩子的胃口值
        int[] s = {6, 5}; // 饼干的尺寸
        int result = solution.findContentChildren(g, s);
        System.out.println("满足的孩子数量: " + result);
    }

}
