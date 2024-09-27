package cn.hereyou.ske;

/**
 * [287]寻找重复数
 *中等
 * 相关标签
 * 相关企业
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 */
public class FinReduceNumber {
    public int findDuplicate(int[] nums) {
        // Phase 1: Finding the intersection point in the cycle
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];               // Move slow by 1 step
            fast = nums[nums[fast]];         // Move fast by 2 steps
        } while (slow != fast);               // Keep moving until they meet

        // Phase 2: Finding the entrance to the cycle
        slow = nums[0];                       // Move slow to the beginning
        while (slow != fast) {
            slow = nums[slow];                // Move both pointers by 1 step
            fast = nums[fast];
        }

        return slow;                          // The entrance to the cycle is the duplicate number
    }

    public static void main(String[] args) {
        FinReduceNumber solution = new FinReduceNumber();
        System.out.println(solution.findDuplicate(new int[]{1, 3, 4, 2, 2})); // 输出: 2
        System.out.println(solution.findDuplicate(new int[]{3, 1, 3, 4, 2})); // 输出: 3
        System.out.println(solution.findDuplicate(new int[]{1, 1}));           // 输出: 1
    }


}
