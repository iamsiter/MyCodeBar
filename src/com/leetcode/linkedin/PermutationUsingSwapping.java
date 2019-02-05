package com.leetcode.linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationUsingSwapping {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list,0, nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, int start, int[] nums) {
        if(start==nums.length){
            list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for(int i=start;i<nums.length;i++){
            swap(nums,i,start);
            backtrack(list,start+1,nums);
            swap(nums,i,start);
        }
    }

    private static void swap(int[] nums, int i, int start) {
        int temp=nums[i];
        nums[i]=nums[start];
        nums[start]=temp;
    }
}
