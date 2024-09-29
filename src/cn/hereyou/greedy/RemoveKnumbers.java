package cn.hereyou.greedy;


import java.util.Stack;

/**
 *
 *

 [402] 移掉 K 位数字
 中等
 相关标签
 相关企业
 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。

 *
 */
public class RemoveKnumbers {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            // 当我们仍然可以移除数字并且栈顶数字大于当前数字时
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // 如果仍有数字需要移除，从栈的末尾移除
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 构建结果
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        // 因为我们是从栈中弹出数字，顺序是反的，所以需要反转
        result.reverse();

        // 去掉前导零
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        // 如果结果为空，返回 "0"
        return result.length() == 0 ? "0" : result.toString();
    }
    public static void main(String[] args) {
        RemoveKnumbers solution = new RemoveKnumbers();
        String num = "1432219";
        int k = 3;
        System.out.println(solution.removeKdigits(num, k));  // 输出: "1219"
    }





}
