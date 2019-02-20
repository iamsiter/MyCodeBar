package com.leetcode.linkedin;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(frequencySort("raaeaedere"));
    }

    private static String frequencySort(String s) {
        Map<Character, Integer> map= new HashMap<>();
        char chars[] = s.toCharArray();
        for(char c : chars)
            map.put(c, map.getOrDefault(c,0)+1);
        List<Map.Entry<Character,Integer>> list=map.entrySet().stream().sorted(Map.Entry.comparingByValue((c1,c2)->c2-c1)).collect(Collectors.toList());

        //map.entrySet().stream().forEach(K->System.out.println(K.getKey()+"::"+K.getValue()));

        StringBuilder sb= new StringBuilder();
        for(Map.Entry c:list){
            int count=map.get(c.getKey());
            for(int i=0;i<count;i++){
                sb.append(c.getKey());
            }
        }
        return sb.toString();
    }
}
