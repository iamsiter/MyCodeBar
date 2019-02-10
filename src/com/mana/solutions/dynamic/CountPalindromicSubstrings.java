package com.mana.solutions.dynamic;

public class CountPalindromicSubstrings {
    static int CountPS(char str[], int n) {

        int dp[][] = new int[n][n];

        // P[i][j] = true if substring str[i..j] is palindrome,
        // else false
        boolean P[][] = new boolean[n][n];

        // palindrome of single length
        for (int i = 0; i < n; i++)
            P[i][i] = true;

        // palindrome of length 2
        for (int i = 0; i < n - 1; i++) {
            if (str[i] == str[i + 1]) {
                P[i][i + 1] = true;
                dp[i][i + 1] = 1; // Not 3 because palindromes of length >2 are counted here
            }
        }

        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int j = gap + i;

                if (str[i] == str[j] && P[i + 1][j - 1])
                    P[i][j] = true;

                if (P[i][j] == true)
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1] + 1;
                else
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
            }
        }

        // return total palindromic substrings
        return dp[0][n - 1];
    }

    // Driver Method
    public static void main(String[] args) {
        String str = "abaab";
        System.out.println(CountPS(str.toCharArray(), str.length()));
    }
}
