package com.mana.solutions;

public class LongestPalindromicSubsequence {


    public static void main(String[] args) {
        System.out.println(lps("bbab"));
    }

    private static int lps(String str) {
        char[] input = str.toCharArray();
        int n = input.length;
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            memo[i][i] = 1;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (input[i] == input[j]) {
                    memo[i][j] = 2 + memo[i + 1][j - 1];
                }
                memo[i][j] = Math.max(memo[i][j],Math.max(memo[i + 1][j],memo[i][j - 1]));
            }
        }

        return memo[0][n - 1];
    }
}
