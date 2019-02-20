package com.mana.solutions.dynamic.knapsack;

public class KnapsackSpaceOptimized {
    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }

    private static int knapSack ( int W, int[] wt, int[] val, int n){
            int memo[] = new int[W + 1];
            // Mistakes done:: failed to visualize the index
            for (int i = 0; i < n; i++) {
                for (int w = W; w >= wt[i]; w--) {
                    //Why processing from right to left
                    //Bcoz if processed from left to right it would replace the value in the array
                    //and when higher ones are processed they need values of past which would have
                    //been replaced by now
                   memo[w]=Math.max(memo[w],val[i]+memo[w-wt[i]]);
                }
            }
            return memo[W];
        }
    }
