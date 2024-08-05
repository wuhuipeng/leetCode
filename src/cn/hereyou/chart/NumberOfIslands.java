package cn.hereyou.chart;


/**
 * 第200题 岛屿数量
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands += dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private int dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check boundary conditions and if the current cell is water
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return 0;
        }

        // Mark the cell as visited by setting it to '0'
        grid[i][j] = '0';

        // Visit all adjacent cells (up, down, left, right)
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

        return 1;
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution.numIslands(grid));  // Output: 1
    }

}
