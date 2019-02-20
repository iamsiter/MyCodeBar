package com.mana.solutions.dynamic.coin;

public class CoinProbCountWays {

    public static void main(String[] args) {
        System.out.println(countWays(new int[]{1,2,3},4));
    }

    private static int countWays(int [] coins, int amount) {
        int [] dp= new int[amount+1];
        dp[0]=1;// BASE CASE VERY 
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]=dp[j]+dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
