package com.mana.solutions.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int nums[] = new int[]{4, 3, 5, 7, 3, 2, 0, 10};
        quickSortTraditional(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);

    }

    private static void quickSortTraditional(int[] nums, int low, int high) {

        if (low<high) {
            //int p = partition(nums, low, high);//Mtd1
            int p = partition2(nums, low, high);//Mtd2

            quickSortTraditional(nums, low, p - 1);
            quickSortTraditional(nums, p + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i=low;
        for (int j = i+1; j <= high; j++) {
            if (nums[j] <= pivot) {
                i++; //COMES BEFORE
                swap(nums, j, i);
            }
        }
        swap(nums, low, i);
        return i;
    }

    private static int partition2(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i=low-1;
        int j=high+1;

        while (true)
        {
            // Find leftmost element greater
            // than or equal to pivot
            do
            {
                i++;
            } while (nums[i] < pivot);

            // Find rightmost element smaller
            // than or equal to pivot
            do
            {
                j--;
            } while (nums[j] > pivot);

            // If two pointers met.
            if (i >= j)
                return j;

            swap(nums, i, j);
        }
    }



    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

// Imagine this way that one position is reserved to be swapped by final partition element
//For all other elements that are less than pivot make one more space....so i is incremented before swap
// Also make sure your use high and low carefully and not initialize as pivot= nums[0]
