package com.mana.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class kSmallets {

//
//    public List<List<Integer>> optimalUtilization(int deviceCapacity, List<List<Integer>> foreGround, List<List<Integer>> backGround) {
//
//        List<List<Integer>> res = new ArrayList<>();
//
//        Collections.sort(foreGround,(a,b)->b.get(1)-a.get(1));
//        Collections.sort(backGround,(a,b)->b.get(1)-a.get(1));
//
//        PriorityQueue<List<List<Integer>>> heap = new PriorityQueue<List<List<Integer>>>((List<Integer> a, List<Integer> b) -> a.get(0).get(1) + a.get(1).get(1) - b.get(0).get(1) + b.get(1).get(1));
//
//        if (foreGround.size() == 0 || backGround.size() == 0) return res;
//
//        for (int i = 0; i < foreGround.size(); i++) {
//            List<List<Integer>> list = new ArrayList<>();
//            list.add(foreGround.get(0));
//            list.add(backGround.get(i));
//            heap.offer(list);
//        }
//
//        int indexOnFore = 0;
//
//        while (!heap.isEmpty()) {
//            int indexOnBack=0;
//            List<List<Integer>> top = heap.poll();
//            int currCap = top.get(0).get(1) + top.get(1).get(1);
//            if (currCap > deviceCapacity) {
//                continue;
//            }
//            List<Integer> resList = new ArrayList<>();
//            indexOnBack=top.get(1).get(0)+1;
//            resList.add(top.get(0).get(0));
//            resList.add(top.get(1).get(0));
//            res.add(resList);
//
//            deviceCapacity = deviceCapacity - currCap;
//
//            if (indexOnFore++ < backGround.size())
//                break;
//
//            List<List<Integer>> new_list = new ArrayList<>();
//            new_list.add(foreGround.get(indexOnFore));
//            new_list.add(backGround.get(indexOnBack));
//            heap.offer(new_list);
//        }
//
//        return res;
//    }
//

}
