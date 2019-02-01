package com.mana.solutions;

public class Knapsack {
    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }


    private static int knapSack(int W, int[] wt, int[] val, int n) {
        int memo[][]=new int[n+1][W+1];

        for(int i =0;i<=n;i++){
            for(int w=0;w<=W;w++){
                if(i==0||w==0)
                    memo[i][w]=0;
                else if(w>=wt[i-1]){
                    memo[i][w]=Math.max(memo[i-1][w],memo[i-1][w-wt[i-1]]+val[i-1]);
                }else{
                    memo[i][w]=memo[i-1][w];
                }
            }
        }
        return memo[n][W];
    }
}
