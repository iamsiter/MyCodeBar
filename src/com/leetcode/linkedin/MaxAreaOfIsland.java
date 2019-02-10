package com.leetcode.linkedin;

public class MaxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        return maxCount;
    }

    public static int dfs(int[][] grid, int i, int j) {
        grid[i][j] = -1;
        int[] delta = new int[]{1, -1, 0, 0};
        int count=0;
        for (int x = 0, y = delta.length - 1; x < delta.length; x++, y--) {
            if (isValid(grid,i + delta[x], j + delta[y]) && grid[i + delta[x]][j + delta[y]] == 1) {
                count +=dfs(grid, i + delta[x], j + delta[y]);
            }
        }
        return count + 1;
    }

    public static boolean isValid(int [][] grid, int i,int j){
        int m=grid.length;
        int n=grid[0].length;

        if(i>=0 && j>=0 && i<m && j<n){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]
                {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }


}
