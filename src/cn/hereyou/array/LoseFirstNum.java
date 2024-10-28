package cn.hereyou.array;


/**
 * [41]. 缺失的第一个正数
 */
public class LoseFirstNum {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 将每个数放到正确的位置上
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // 将 nums[i] 放到正确的位置上，即 nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // 找到第一个位置 i 上的数不为 i + 1 的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果所有位置上的数都正确，则缺失的是 n+1
        return n + 1;
    }

    public static void main(String[] args) {
        LoseFirstNum loseFirstNum=new LoseFirstNum();
        System.out.printf(String.valueOf(loseFirstNum.firstMissingPositive(new int[]{-1,7,9,1})));
    }
}
