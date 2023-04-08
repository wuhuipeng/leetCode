package cn.hereyou;


/**
 *11. 盛最多水的容器
 */

public class ContainerWithMostWater {
    public  static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public static void main(String[] args) {
       int s= maxArea(new int[]{1,2,3,4,5,6,7,8});
        System.out.print(s);
    }


}
