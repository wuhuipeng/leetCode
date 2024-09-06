package cn.hereyou.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. 有效的数独
 */
public class EffectiveSudoku {
    public static boolean isValidSudoku(char[][] board) {
        // 检查每一行、每一列和每个 3x3 宫
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i) || !isValidBox(board, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidRow(char[][] board, int row) {
        Set<Character> seen = new HashSet<>();
        for (int col = 0; col < 9; col++) {
            char num = board[row][col];
            if (num != '.' && !seen.add(num)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidColumn(char[][] board, int col) {
        Set<Character> seen = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            char num = board[row][col];
            if (num != '.' && !seen.add(num)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidBox(char[][] board, int boxIndex) {
        Set<Character> seen = new HashSet<>();
        int startRow = (boxIndex / 3) * 3;
        int startCol = (boxIndex % 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char num = board[startRow + i][startCol + j];
                if (num != '.' && !seen.add(num)) {
                    return false;
                }
            }
        }
        return true;
    }
}
