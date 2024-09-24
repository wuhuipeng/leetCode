package cn.hereyou.ske;

/**
 * [136]136. 只出现一次的数字
 */
public class OnlyNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}
