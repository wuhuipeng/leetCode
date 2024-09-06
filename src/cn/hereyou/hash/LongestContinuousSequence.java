package cn.hereyou.hash;

import java.util.HashMap;

/**
 *
 *
 * [128]. 最长连续序列
 *
 *
 *
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 */
public class LongestContinuousSequence {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> lookup = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!lookup.containsKey(num)) {
                // 查看左右两边是否可以相连
                int left = (lookup.containsKey(num - 1)) ? lookup.get(num - 1) : 0;
                int right = (lookup.containsKey(num + 1)) ? lookup.get(num + 1) : 0;
                lookup.put(num, left + right + 1);
                // 改变首尾两个长度(换成更长的长度)
                lookup.put(num - left, left + right + 1);
                lookup.put(num + right, left + right + 1);
                res = Math.max(res, left + right + 1);
            }

        }
        return res;
    }

}






























