package com.mana.solutions.findTopK;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFreqWords {
    public static void main(String[] args) {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        for (String s : topKFrequent(words, 2)) {
            System.out.println(s);
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = map.entrySet().stream().sorted((c1, c2) -> {
            if (c1.getValue() == c2.getValue()) {
                return c1.getKey().compareTo(c2.getKey());
            } else {
                return c2.getValue() - c1.getValue();
            }
        }).collect(Collectors.toList());
        
        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            result.add(entry.getKey());
        }
        return result;
    }

}
