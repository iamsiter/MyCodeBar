package com.leetcode.linkedin;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduling {

    public static boolean canFinish(int n, int[][] preqs) {
        if(n==0)
            return true;

        int count = 0;
        int inDeg[] = new int[n];

        for (int[] preq : preqs) {
            inDeg[preq[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<inDeg.length;i++) {
            if (inDeg[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            Integer first = queue.poll();
            count++;
            for (int[] preq : preqs) {
                if (preq[0] == first) {
                    inDeg[preq[1]]--;
                    if (inDeg[preq[1]] == 0) {
                        queue.offer(preq[1]);
                    }
                }
            }
        }

        return count == n;
    }


    public static void main(String[] args) {
        int[][] courses = new int[][]{{0, 1}, {1, 4}, {2, 4}, {3, 2}};
        System.out.println(canFinish(5, courses));

    }


}
