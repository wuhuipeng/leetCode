package cn.hereyou.sort;

import java.util.TreeSet;


/**
 *
 *
 * [414]. 第三大的数
 *
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。Java
 */
public class ThirdMax {
    public int thirdMax(int[] nums) {
        // 使用 TreeSet 来存储不重复的数字
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);
            // 限制集合的大小为 3
            if (set.size() > 3) {
                set.pollFirst(); // 删除最小的元素
            }
        }

        // 如果集合的大小小于 3，返回最大值
        if (set.size() < 3) {
            return set.last(); // 返回最大值
        }

        // 返回第三大的数
        return set.first(); // 返回最小的元素，即第三大的数
    }

    public static void main(String[] args) {
        ThirdMax tm = new ThirdMax();

        int[] nums3 = {4, 2, 3, 1,20,1,23,230,100};
        System.out.println(tm.thirdMax(nums3)); // 输出 1
    }
}
