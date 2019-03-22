package com.java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortTheMap {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 4, 5, 3, 2, 1, 2, 3, 4, 5};
        Map<Integer, Integer> mymap = new HashMap<>();
        mymap.put(3,4);
        mymap.put(6,5);
        mymap.put(1,7);
        mymap.put(8,3);
        mymap.put(5,90);
        mymap.put(13,54);

        //--------------------------------------------------------------------------------------------


        //Use of getOrDefault
        //Also see computeIfAbsent and putIfAbsent (& why it can't be used here)
        for (int i = 0; i < nums.length; i++) {
            mymap.put(nums[i], mymap.getOrDefault(nums[i], 0) + 1);
        }
        //Print the map
        mymap.forEach((K, V) -> System.out.println(K + "-->" + V));

        //--------------------------------------------------------------------------------------------

        //Sort the map
        Map<Integer, Integer> sortedMap = mymap.entrySet().stream().sorted(Map.Entry.comparingByValue()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (c1, c2) -> c1, LinkedHashMap::new));
        //Print the sorted map
        sortedMap.entrySet().stream().forEach(System.out::println);

        //--------------------------------------------------------------------------------------------

        List<Map.Entry> res = mymap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        res.stream().forEach(E-> System.out.println(E.getKey()+" "+E.getValue()));


    }
}
