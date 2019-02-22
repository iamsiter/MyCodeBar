package com.mana.solutions.dynamic.strings;

public class PalindromePartitioning {

    public static int minPalPartion(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        boolean P[][] = new boolean[n][n];
        int C[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            P[i][i] = true;
            C[i][i] = 0;
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;
                if (L == 2)
                    P[i][j] = (str.charAt(i) == str.charAt(j));
                else
                    P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i + 1][j - 1];


                if (P[i][j] == true)
                    C[i][j] = 0;
                else {
                    // Make a cut at every possible
                    // location starting from i to j,
                    // and get the minimum cost cut.
                    C[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++)
                        C[i][j] = Integer.min(C[i][j], C[i][k] + C[k + 1][j] + 1);
                }
            }
        }

        return C[0][n - 1];
    }

    public static void main(String args[]) {
        String str = "ababc";
        System.out.println("Min cuts needed for " +
                "Palindrome Partitioning" +
                " is " + minPalPartion(str));
    }

}
