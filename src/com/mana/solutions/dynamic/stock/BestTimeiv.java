package com.mana.solutions.dynamic.stock;

public class BestTimeiv {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length <= 1)
            return 0;

        if (k >= prices.length / 2) {
            int maxPro = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    maxPro += prices[i] - prices[i - 1];
            }
            return maxPro;
        }


        int T[][] = new int[k + 1][prices.length];

        for (int i = 1; i < T.length; i++) {
            int max = 0;
            for (int j = 1; j < T[0].length; j++) {
                max = 0;
                for (int b = 0; b < j; b++) {
                    max = Math.max(max, prices[j] - prices[b] + T[i - 1][b]);

                    //Can be changed to
                    //max =  prices[j]+ Math.max(max, T[i - 1][b] - prices[b]);
                }
                T[i][j] = Math.max(T[i][j - 1], max);
            }
        }
        return T[k][prices.length - 1];
    }
}
