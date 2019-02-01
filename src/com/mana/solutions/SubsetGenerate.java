package com.mana.solutions;

import java.util.ArrayList;
import java.util.List;

public class SubsetGenerate {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private static void helper(List<List<Integer>> res, int[] nums, List<Integer> currList, int start) {
        if (start == nums.length){
            res.add(currList);
            return;
        }
        res.add(currList);// init list
        helper(res, nums, new ArrayList<>(currList), start + 1);

        List<Integer> newList = new ArrayList<>(currList);
        newList.add(nums[start]);
        helper(res, nums, newList, start + 1);

    }

    public static void main(String[] args) {
        List<List<Integer>> list = subsets(new int[]{1, 2, 3});
        System.out.println(list);
    }
}
