package com.mana.solutions.backtrack;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // not necessary
        backtrack(list,0, nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, int start, int[] nums) {
        if(start==nums.length){
            list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        Set<Integer> used=new HashSet<>();
        for(int i=start;i<nums.length;i++){
           if(i!=start && used.contains(nums[i]))
                continue;

            used.add(nums[i]);
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


    public static void main(String[] args) {
        List<List<Integer>> res=permute(new int []{0,0,0,1,9});
        System.out.println(res.size());
        System.out.println(res);

    }

}
