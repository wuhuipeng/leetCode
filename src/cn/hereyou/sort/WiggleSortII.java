package cn.hereyou.sort;

import java.util.Arrays;

/**
 * 算是技巧题
 * [324] 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        int n = nums.length;
        int[] result = new int[n];

        // 用两个指针来填充结果数组
        int left = (n - 1) / 2; // 中间位置
        int right = n - 1; // 右边界

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result[i] = nums[left--]; // 从中间向左取
            } else {
                result[i] = nums[right--]; // 从右边取
            }
        }

        // 将结果复制回原数组
        System.arraycopy(result, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        WiggleSortII solution = new WiggleSortII();
        int[] nums = {1, 2, 3, 4, 5, 6};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums)); // 输出结果
    }

}
