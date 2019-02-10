package com.mana.solutions.sorting;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int nums[] = new int[]{4, 3, 5, 7, 3, 2, 0, 10};
        selectionSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private static void selectionSort(int[] nums) {
        for (int start = 0; start < nums.length; start++) {
            int minIndex = start;
            for (int j = start; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, start, minIndex);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
