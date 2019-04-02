package com.mana.solutions.bfsdfs;

public class NoOfIslands {
    public static int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    markIslands(grid, visited, i, j);
                }
            }
        }
        return count;
    }


    public static void markIslands(char[][] grid, boolean[][] visited, int i, int j) {

        if (grid[i][j] == '0' || visited[i][j])
            return;
        visited[i][j] = true;
        int incr[] = new int[]{-1, 1, 0, 0};
        for (int l = 0, m = incr.length - 1; l < incr.length && m >= 0; l++, m--) {
            if (isValid(i + incr[l], j + incr[m], grid)) {
                markIslands(grid, visited, i + incr[l], j + incr[m]);
            }
        }
        return;
    }

    public static boolean isValid(int i, int j, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (i >= 0 && i < m && j >= 0 && j < n)
            return true;
        return false;
    }

}
