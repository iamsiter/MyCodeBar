package com.mana.solutions.arrays;

import java.util.Arrays;

public class FirstLastPosInSorted {

    public static int[] searchRange(int[] nums, int target) {
        int left = findFirst(nums, target);
        int right = findLast(nums, target);
        return new int[]{left, right};
    }

    public static int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target && (mid == 0 || nums[mid] > nums[mid - 1]))
                return mid;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid] < nums[mid + 1] ))
                return mid;
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] result = searchRange(new int[]{}, 2);
        Arrays.stream(result).forEach(System.out::println);
    }
}
