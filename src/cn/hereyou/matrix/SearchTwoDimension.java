package cn.hereyou.matrix;

//74. 搜索二维矩阵
//        中等
//        相关标签
//        相关企业
//
//        给你一个满足下述两条属性的 m x n 整数矩阵：
//
//        每行中的整数从左到右按非严格递增顺序排列。
//        每行的第一个整数大于前一行的最后一个整数。
//
//        给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
//
public class SearchTwoDimension {

    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1, col = matrix[0].length - 1;
        int left = 0, right = row;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == row + 1)
            return false;
        int left1 = 0, right1 = col;
        while (left1 <= right1) {
            int mid = left1 + (right1 - left1) / 2;
            if (matrix[left][mid] < target) {
                left1 = mid + 1;
            } else {
                right1 = mid - 1;
            }
        }
        if (left1 == col + 1 || matrix[left][left1] != target)
            return false;
        return true;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int left = 0;
        int n = matrix[0].length;
        int right = matrix.length * n - 1;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            int value = matrix[mid / n][mid % n];
            if(target == value){
                return true;
            }else if(target > value){
                left = ++mid;
            }else{
                right = --mid;
            }
        }
        return false;
    }
}
