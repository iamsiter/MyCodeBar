package com.leetcode.linkedin;

import java.util.*;

public class Permutations {

    //https://leetcode.com/problems/permutations

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, res, new LinkedHashSet<Integer>(), 0);
        return res;
    }

    public static void permute(int[] nums, List<List<Integer>> res, Set<Integer> currSet, int pos) {

        if (pos == nums.length) {
            res.add(new ArrayList<Integer>(currSet));
        }

        for (int i = 0; i < nums.length; i++) {

            if (currSet.contains(nums[i]))
                continue;

            currSet.add(nums[i]);
            permute(nums, res, currSet, pos + 1);
            currSet.remove(nums[i]);
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{1, 2, 3});
        for (List<Integer> a : res) {
            System.out.println(a);
        }
    }
}
