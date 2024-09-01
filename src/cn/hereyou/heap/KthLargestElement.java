package cn.hereyou.heap;

import java.util.PriorityQueue;

/**
 *
 *
 *
 代码


 测试用例
 测试结果
 测试结果
 [215]. 数组中的第K个最大元素
 中等
 相关标签
 相关企业
 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。


 *
 *
 */
public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        // 创建一个最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // 遍历数组中的每个元素
        for (int num : nums) {
            // 如果堆中的元素数量小于 k，直接加入
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (num > minHeap.peek()) {
                // 如果当前元素大于堆顶元素，弹出堆顶元素并加入当前元素
                minHeap.poll();
                minHeap.add(num);
            }
        }

        // 堆顶元素即为第 k 个最大的元素
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("The " + k + "th largest element is " + findKthLargest(nums, k));  // Output: 5
    }
}
