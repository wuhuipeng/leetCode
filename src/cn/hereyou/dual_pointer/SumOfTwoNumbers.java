package cn.hereyou.dual_pointer;

/**
 *
 *
 * [167]. 两数之和 II - 输入有序数组
 */
public class SumOfTwoNumbers {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 }; // 因为下标从 1 开始
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // 如果没有找到合适的解，返回空数组或抛出异常
        throw new IllegalArgumentException("No two sum solution");
    }

}
