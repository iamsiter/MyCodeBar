package com.mana.solutions.dynamic.strings;

public class LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        char arr[] = s.toCharArray();
        int low = 0, high = 0;
        int max = 0;
        boolean[][] memo = new boolean[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            memo[i][i] = true;
            if (i > 0) {
                memo[i - 1][i] = (arr[i] == arr[i - 1]); //If both same them set true
                if (memo[i - 1][i]) {
                    max = 2;
                    high = i;
                    low = i - 1;
                }
            }
        }

        for (int len = 3; len <= arr.length; len++) {
            for (int i = 0; i < arr.length - len + 1; i++) {
                int j = i + len - 1;
                if (arr[i] == arr[j] && memo[i + 1][j - 1]) {
                    memo[i][j] = true;
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        low = i;
                        high = j;
                    }
                } else {
                    memo[i][j] = false;
                }
            }
        }

        return s.substring(low, high + 1);
    }
}
