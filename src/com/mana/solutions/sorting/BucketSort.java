package com.mana.solutions.sorting;

import java.util.ArrayList;
import java.util.Arrays;

/*
* Technically same as count sort just that buckets are kept for processed later
* */

public class BucketSort {
    static int BUCKETS=10;
    public static void main(String[] args) {
        int nums[] = new int[]{4, 3, 5, 7, 3, 2, 0, 9};
        bucketSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private static void bucketSort(int[] nums) {
        int i,j,k;
        int [] buckets = new int[BUCKETS];

        for(i=0;i<nums.length;i++){
            buckets[nums[i]]++;
        }

        for(j=0,i=0;j<BUCKETS;j++){
            for(k=buckets[j];k>0;k--){
                nums[i++]=j;
            }
        }
    }
}
