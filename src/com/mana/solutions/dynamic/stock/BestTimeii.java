package com.mana.solutions.dynamic.stock;

public class BestTimeii {
    public int maxProfit(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i])
                max+=(prices[i+1]-prices[i]);
        }
        return max;
    }
}
