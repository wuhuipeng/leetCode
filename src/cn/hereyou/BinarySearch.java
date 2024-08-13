package cn.hereyou;


/**
 * [704]. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 */

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left<=right){
            mid = left+(right-left)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid -1;
            }else
                return mid;
           }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch= new BinarySearch();
        binarySearch.search(new int[]{2,3,4,5,6,65,76,324} ,7);
    }



}
