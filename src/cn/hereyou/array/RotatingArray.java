package cn.hereyou.array;

/**
 *
 * [189]题. 轮转数组
 */
public class RotatingArray {


    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // 确保 k 小于数组长度
        reverse(nums, 0, n - 1); // 反转整个数组
        reverse(nums, 0, k - 1); // 反转前 k 个元素
        reverse(nums, k, n - 1); // 反转剩余的元素
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
