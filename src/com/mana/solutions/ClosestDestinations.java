package com.mana.solutions;

import java.util.*;

//https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.

class ClosestDestinations {

    private static List<List<Integer>> ClosestXDestinations(int numDestinations, List<List<Integer>> allocations, int numDeliveries) {
        Point center = new Point(0, 0);
        if(numDeliveries<=0)
            return Collections.emptyList();
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(numDeliveries, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return distance(center, o2) - distance(center, o1);
            }
        });
        for (List<Integer> points : allocations) {
            Point p = new Point(points.get(0), points.get(1));
            if (maxHeap.size() < numDeliveries)
                maxHeap.offer(p);
            else if (distance(center, maxHeap.peek()) > distance(center, p)) {
                maxHeap.poll();
                maxHeap.offer(p);
            }
        }
        Iterator<Point> i = maxHeap.iterator();
        List<List<Integer>> sol = new ArrayList<>();
        while (i.hasNext()) {
            Point p = i.next();
            sol.add(Arrays.asList(p.x, p.y));
        }
        return sol;
    }

    public static int distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(1,2));
        list.add(Arrays.asList(1, -1));


        System.out.print(ClosestXDestinations(3, list, 0));

    }


}
