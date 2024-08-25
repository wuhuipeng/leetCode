package cn.hereyou.chart;

import java.util.LinkedList;
import java.util.Queue;

/***\
 * [994]题目
 *
 *
 *
 */

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all the rotten oranges and count fresh oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    freshOranges++;
                } else if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        if (freshOranges == 0) {
            return 0; // No fresh oranges to rot
        }

        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // BFS to spread the rot
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenOccurred = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // Mark the orange as rotten
                        queue.offer(new int[]{newX, newY});
                        freshOranges--;
                        rottenOccurred = true;
                    }
                }
            }

            if (rottenOccurred) {
                minutes++;
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        RottenOranges ro = new RottenOranges();

        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        System.out.println(ro.orangesRotting(grid1)); // Output: 4
        System.out.println(ro.orangesRotting(grid2)); // Output: -1
    }

}


