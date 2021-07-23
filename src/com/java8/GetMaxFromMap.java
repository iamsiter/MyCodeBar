package com.java8;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GetMaxFromMap {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 4, 5, 3, 2, 1, 2, 3, 4, 5};
        Map<Integer, Integer> mymap = new HashMap<>();

        int key = Collections.max(mymap.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(key);
    }

}
