package com.leetcode.linkedin;

public class WordSearch {

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'a','b'},{'c','d'}},"cdba"));
    }

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0)
            return false;

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && find(board, word, 0, visited, i, j))
                    return true;
            }
        }

        return false;
    }

    public static boolean find(char[][] board, String word, int pos, boolean[][] visited, int i, int j) {

        if (word.charAt(pos) != board[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (pos == word.length() - 1) {
            return true;
        }


        boolean flag = false;
        int[] delta = new int[]{1, -1, 0, 0};
        for (int x = 0, y = delta.length - 1; x < delta.length; x++, y--) {
            if (isValid(board, i + delta[x], j + delta[y]) && !visited[i + delta[x]][j + delta[y]]) {
                if (find(board, word, pos + 1, visited, i + delta[x], j + delta[y]))
                    flag = true;
            }
        }
        visited[i][j] = false;

        return flag;
    }

    public static boolean isValid(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        if (i >= 0 && i < m && j >= 0 && j < n)
            return true;
        return false;
    }
}
