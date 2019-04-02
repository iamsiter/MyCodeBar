package com.mana.solutions.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetGenerateLeetcode {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public static void helper(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i=start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1]) continue; // uncomment if you need to skip duplicates
            tempList.add(nums[i]);
            helper(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = subsets(new int[]{1,1, 2, 3});
        System.out.println(list);
    }
}
