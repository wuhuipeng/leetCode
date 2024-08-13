package cn.hereyou.matrix;

/**
 *
 * [240]. 搜索二维矩阵 II
 */
public class SearchTwoDimensionU {

    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 从矩阵的右上角开始
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // 向左移动
            } else {
                row++; // 向下移动
            }
        }

        return false; // 未找到目标值
    }
}
