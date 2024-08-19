package cn.hereyou.stack;

import java.util.Stack;

/**
 * [739]. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 们需要找到它后面第一个比它温度高的天数差值。单调栈可以帮助我们有效地找到下一个更高温度的位置。
 *
 * 解法步骤：
 * 初始化一个栈和结果数组：栈中存储的是数组下标，结果数组初始化为0。
 * 从后往前遍历温度数组：
 * 如果栈不为空且当前温度大于栈顶所指的温度，说明当前温度比栈顶温度要高，所以我们可以弹出栈顶元素。
 * 这样确保栈顶元素的温度总是比当前温度高。
 * 如果栈不为空，说明栈顶元素就是下一个比当前温度高的温度，我们可以计算它们之间的天数差。
 * 将当前温度的下标压入栈中。
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                answer[i] = stack.peek() - i;
            } else {
                answer[i] = 0;
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result1 = dailyTemperatures(temperatures1);
        for (int r : result1) {
            System.out.print(r + " ");
        }
        // 输出: [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println();

        int[] temperatures2 = {30, 40, 50, 60};
        int[] result2 = dailyTemperatures(temperatures2);
        for (int r : result2) {
            System.out.print(r + " ");
        }
        // 输出: [1, 1, 1, 0]
        System.out.println();

        int[] temperatures3 = {30, 60, 90};
        int[] result3 = dailyTemperatures(temperatures3);
        for (int r : result3) {
            System.out.print(r + " ");
        }
        // 输出: [1, 1, 0]
        System.out.println();
    }
}
