package com.mana.solutions.findTopK;

import java.util.PriorityQueue;

public class KthLargestNumber {
    /*Three methods
     * 1)Using QuickSelect
     * Avg - O(n)   Worst-O(n^2)
     *
     * 2)Using heap
     * Which heap to keep- MIN or MAX ??
     * We keep MIN HEAP HERE...
     * O(NlogK)
     *
     * 3)Using Priority queue in Java
     *O(NlogK)
     * */

    public static void main(String[] args) {
        System.out.println(findKthLargestPriorityQueue(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 3));
        System.out.println(findKthLargestQuickSelect(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 3));

    }

    private static int findKthLargestPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int i = 0;
        for (i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }

        for (; i < nums.length; i++) {
            if (nums[i] < heap.peek())
                continue;
            else {
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap.poll();
    }

    private static int findKthLargestQuickSelect(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        int index = nums.length - k; //Kth largest element is (n-k)th smallest from beginning
        while (low < high) {
            int pivot = partition(nums, low, high);
            if (pivot == index)
                return nums[index];
            else if (pivot < index) {
                low = pivot+1;
            } else {
                high = pivot-1;
            }
        }

        return 0;
    }


    public static int partition(int [] nums, int low, int high){
           int pivot = nums[low];
           int i=low;
           for(int j=low;j<nums.length;j++){
               if(nums[i]<=pivot){
                   i++;
                   swap(nums,i,j);
               }
           }
            swap(nums,low,i);
            return  i;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
