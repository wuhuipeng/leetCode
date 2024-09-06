package cn.hereyou.array;

import java.util.HashMap;

/**
 * [560]. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 */
public class KsubArray {
    public int subarraySum(int[] nums, int k) {
        // 利用哈希表实现线性寻找
        HashMap <Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int i;
        int sum = 0;
        int count = 0;
        for (i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if (hashMap.containsKey(sum - k))   // 表示连续子数组减去连续子数组，必定为连续子数组
            {
                count += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
