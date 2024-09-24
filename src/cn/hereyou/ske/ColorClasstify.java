package cn.hereyou.ske;

/**
 * 75. 颜色分类
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class ColorClasstify {



    public void sortColors(int[] nums) {
        int zeroIndex = 0; // 指向下一个0的位置
        int twoIndex = nums.length - 1; // 指向下一个2的位置
        int i = 0; // 当前指针

        while (i <= twoIndex) {
            if (nums[i] == 0) {
                swap(nums, i, zeroIndex);
                zeroIndex++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, twoIndex);
                twoIndex--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
