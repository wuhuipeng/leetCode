package cn.hereyou.greedy;

/**
 *
 * Leetcode [55]：跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        //最远可到达的距离
        int range = 0;
        for(int i=0; i < nums.length; i++){
            if(i <= range){
                range = Math.max(range, i + nums[i]);
                if(range >= nums.length-1){
                    return true;
                }
            }

        }
        return false;
    }

}
