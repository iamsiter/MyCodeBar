package com.mana.solutions.dynamic.coin;

import java.util.Arrays;

public class CoinProbMinCoins {

    public static int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                if(dp[j-coins[i]]!=Integer.MAX_VALUE)
                    dp[j]=Math.min(dp[j],1+dp[j-coins[i]]);
            }
        }
        return (dp[amount]==Integer.MAX_VALUE)?-1:dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2, 3, 4}, 5));
    }


}
