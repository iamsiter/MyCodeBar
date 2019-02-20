package com.mana.solutions.dynamic.stock;

public class BestTimei {
    public int maxProfit(int[] prices) {
        int maxDiff=0;
        if(prices.length<2)
            return 0;

        int min=prices[0];

        for(int i=1;i<prices.length;i++){
            int diff=prices[i]-min;

            if(diff>0 && diff>maxDiff)
                maxDiff=prices[i]-min;

            if(prices[i]<min)
                min=prices[i];
        }

        return maxDiff;
    }
}
