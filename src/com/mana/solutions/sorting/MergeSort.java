package com.mana.solutions.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int nums[] = new int[]{4, 3, 5, 7, 3, 2, 0, 10};
        mergeSort(nums);
    }

    private static void mergeSort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int temp[] = new int[nums.length];
        mergeSort(nums, low, high, temp);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private static void mergeSort(int[] nums, int low, int high, int[] temp) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid, temp);
            mergeSort(nums, mid + 1, high, temp);
            merge(nums, low, mid, high, temp);
        }
    }

    private static void merge(int nums[], int low, int mid, int high, int temp[]) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k] = nums[i];
                i++;
                k++;
            } else {
                temp[k] = nums[j];
                j++;
                k++;
            }
        }

        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        while (j <= high) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        //Used same temp array and passed it to all calls made...memory optimization
        //This temp array is used to perform merge operation


        int size = high - low + 1;
        //Copy back sorted part into nums
        for (int t = 0; t < size ; t++) {
            nums[low] = temp[t];
            low = low + 1;
        }
    }
}