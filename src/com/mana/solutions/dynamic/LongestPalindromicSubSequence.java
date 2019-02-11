package com.mana.solutions.dynamic;

public class LongestPalindromicSubSequence {
    public int longestPalindromeSubseq(String s) {
        char[] input = s.toCharArray();
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
                }else{
                    memo[i][j] = Math.max(memo[i + 1][j],memo[i][j - 1]);
                }
            }
        }

        return memo[0][n - 1];
    }
}

