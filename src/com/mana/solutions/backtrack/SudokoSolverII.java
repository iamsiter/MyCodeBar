package com.mana.solutions.backtrack;

//MY VERSION
public class SudokoSolverII {
    public static void main(String[] args) {
        solveSudoku(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
    }

    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;


        if (solve(board, 0, 0)) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No result");
        }
    }

    private static boolean solve(char[][] board, int i, int j) {
        if (i >= 9 || j >= 9)
            return true;

        int i_next = 0, j_next = 0;
        if (j + 1 >= 9) {
            j_next = 0;
            i_next = i + 1;
        } else {
            i_next = i;
            j_next = j + 1;
        }

        if (board[i][j] == '.') {
            for (char c = '1'; c <= '9'; c++) {
                if (isValid(board, i, j, c)) {
                    board[i][j] = c;
                    if (solve(board, i_next, j_next))
                        return true;
                }
                board[i][j] = '.';
            }
            return false;
        } else {
            return solve(board, i_next, j_next);
        }
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false; //check row
            if (board[row][i] != '.' && board[row][i] == c) return false; //check column
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}
