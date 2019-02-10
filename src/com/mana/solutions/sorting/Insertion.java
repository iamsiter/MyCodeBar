package com.mana.solutions.sorting;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int nums[] = new int[]{4, 3, 5, 7, 3, 2, 0, 10};
        insertionSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private static void insertionSort(int[] nums) {

        for(int j=1;j<nums.length;j++){
            int currVal = nums[j];
            int i=j;
            while(i>0 && nums[i-1]>currVal){
                nums[i]=nums[i-1];
                i--;
            }
            nums[i]=currVal;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
