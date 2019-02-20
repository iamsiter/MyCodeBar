package com.mana.solutions.dynamic.strings;

public class LongestCommonSubsequence {
    int lcs(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

    public static int lcsSpaceOptimized(String X,
                                        String Y) {

        // Find lengths of two strings
        int m = X.length(), n = Y.length();

        int L[][] = new int[2][n + 1];

        // Binary index, used to index
        // current row and previous row.
        int bi = 0;

        for (int i = 0; i <= m; i++) {

            // Compute current binary index
            bi = i & 1;

            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[bi][j] = 0;

                else if (X.charAt(i - 1) ==
                        Y.charAt(j - 1))
                    L[bi][j] = L[1 - bi][j - 1] + 1;

                else
                    L[bi][j] = Math.max(L[1 - bi][j],
                            L[bi][j - 1]);
            }
        }

        // Last filled entry contains length of
        // LCS for X[0..n-1] and Y[0..m-1]
        return L[bi][n];
    }


    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.lcs(X, Y, m, n));
    }


}
