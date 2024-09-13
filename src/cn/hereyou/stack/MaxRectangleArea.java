package cn.hereyou.stack;

import java.util.Stack;

/**
 *
 *
 * [84]84. 柱状图中最大的矩形
 */
public class MaxRectangleArea {
    public static void main(String[] args) {
//        int[] heights = {1, 2, 10, 3,20,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] heights = {1, 2, 5, 6,7,1};
        System.out.println(maxRectangleArea(heights));  // 输出 10
    }


    public static int maxRectangleArea(int[] heights) {
        // 如果输入数组为空，返回 0
        if (heights == null || heights.length == 0) {
            return 0;
        }

        // 创建一个栈来存储柱子的索引
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;

        // 遍历每个柱子
        while (index < heights.length) {
            // 如果当前柱子的高度大于栈顶柱子的高度，入栈
            if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
                stack.push(index++);
            } else {
                // 计算以栈顶柱子为最矮柱子的矩形面积
                int topOfStack = stack.pop();
                int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        // 处理剩余的柱子
        while (!stack.isEmpty()) {
            int topOfStack = stack.pop();
            int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

}
