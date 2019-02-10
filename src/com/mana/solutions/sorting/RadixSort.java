package com.mana.solutions.sorting;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int nums[] = new int[]{4, 3, 5, 7, 3, 2, 0, 10};
        radixSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    /*
    * This sorting algorithm runs on each digit and maximum of that is max no of digits
    * in any no....for each digit position we run count sort which is O(K) where K is max no
    * used in that radix eg decimal -10, hexadecimal -16 etc
    *
    * So complexity is O(n*K)
    *
    *
    * */

    private static void radixSort(int[] nums) {
        int m = getMaxNo(nums); // To get how many times to run it......no padding work as explained in theory

        for(int exp=1; m/exp>0;exp*=10){
            //Perform count sort on ith digit from last
            countSort(nums, nums.length, exp);
        }
    }

    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }


    private static int getMaxNo(int[] nums) {
        int mx = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > mx)
                mx = nums[i];
        return mx;
    }

}
