package com.mana.solutions.findTopK;

import java.util.Arrays;

public class TopKClosestToOrigin {
    public static void main(String[] args) {
        int[][] output = kClosest(new int[][]{{1, 3}, {-2, 2}, {2, 4}, {0, 9}, {3, -3}}, 3);
        System.out.println(Arrays.deepToString(output));
    }

    public static int[][] kClosest(int[][] points, int K) {
        if (points.length <= K)
            return points;

        int low = 0, high = points.length-1;
        while (low <= high) { //You put this check bcoz low and high can cross // They can be equal
            int pivot = helper(points, low, high);
            if (pivot < K) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private static int helper(int[][] A, int low, int high) {
        int[] pivot = A[low];
        while (low <high) { //You put this check bcoz low and high can cross  /They can't be equal
            while (low < high && compare(A[low], pivot) >= 0) high--;
            while (low < high && compare(A[low], pivot) <= 0) low++;
            int[] temp = A[low];
            A[low] = A[high];
            A[high] = temp;
        }
        return low;
    }

    private static int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

}
