package com.mana.solutions.findTopK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFreqElements {
    //https://leetcode.com/problems/top-k-frequent-elements/description/
    public static void main(String[] args) {
        for(Integer b:topKFrequent(new int []{2,3,4,4,3,5,6,3,2,4,6,4},4)){
            System.out.println(b);
        }
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        //Map<Integer, Integer> sortedMap=map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        // No need to make new map....we can collect the Entry in list and can traverse top k only

        List<Map.Entry<Integer,Integer>> list=map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).collect(Collectors.toList());

        List<Integer> res=new ArrayList<>();
        for(int i=0;i<k;i++){
            res.add(list.get(i).getKey());
        }
        return res;
    }
}
