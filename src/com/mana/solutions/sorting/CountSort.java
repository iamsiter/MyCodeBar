package com.mana.solutions.sorting;

import java.util.Arrays;


/*
* Total Complexity: O(K) + O(n) + O(K) + O(n) = O(n) if K =O(n). Space Complexity: O(n) if K=O(n).
Note: Counting works well if K =O(n). Otherwise, the complexity will be greater.

## Works only in integer array and when range is small

*
* */

public class CountSort {
    public static void main(String[] args) {
        int nums[] = new int[]{4, 3, 5, 7, 3, 2, 0, 9};
        int output[] = new int[nums.length];
        countSort(nums, output, 10); //range is [0...K-1]
        Arrays.stream(output).forEach(System.out::println);
    }

    public static void countSort(int[] A, int[] B, int K) {

        int[] C = new int[K];

        for (int i = 0; i < A.length; i++) {
            C[A[i]]++;
        }

        for (int j = 1; j < K; j++) {//count=count+count prev
            C[j] = C[j] + C[j - 1];
        }

        for (int j = 0; j < K; j++) {//Adjust the counts(see difference on worked example on paper)
            C[j] = C[j] - 1; //Or could have moved the value right by one place
        }

        //C array now has indices that element should have..consult C and place the element at right position
        for (int k = A.length - 1; k >= 0; k--) {
            B[C[A[k]]] = A[k];
            C[A[k]] -= 1;
        }
    }
}
