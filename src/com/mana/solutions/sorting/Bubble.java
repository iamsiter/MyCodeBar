package com.mana.solutions.sorting;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int nums[] = new int[]{4, 3, 5, 7, 3, 2, 0, 10};
        bubbleSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    //Can be optimized if after one scan we see if it is fully sorted already or not
    public static void bubbleSort(int[] nums) {

        for (int pass = nums.length - 1; pass >= 0; pass--) {
            for (int i = 0; i < pass; i++) {
                if (nums[i + 1] < nums[i]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
