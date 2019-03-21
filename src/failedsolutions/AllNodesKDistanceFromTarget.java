/*
package failedsolutions;

import java.util.ArrayList;
import java.util.List;

public class AllNodesKDistanceFromTarget {
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        if (root == target) {
            process(root.left, result, K - 1);
            process(root.right, result, K - 1);
            return result;
        }


        int right = find(root.right, target, result, K);
        int left = find(root.left, target, result, K);

        if(left==0 || right==0) {
            result.add(root.data);
            return result;
        }


        if (left == -1) {
            process(root.left, result, K - right - 1);
        } else {
            process(root.right, result, K - left - 1);
        }

        return result;
    }

    private static int find(TreeNode root, TreeNode target, List<Integer> result, int K) {
        if (K < 0 || root == null)
            return -1;

        if (root == target) {
            process(root, result, K);
            return 1;
        }

        int left = find(root.left, target, result, K);
        int right = find(root.right, target, result, K);

        if(left==K || right ==K)
            result.add(root.data);

        return (right == -1 && left == -1) ? -1 : Math.max(left, right) + 1;
    }

    private static void process(TreeNode root, List<Integer> result, int K) {
        if (root == null)
            return;

        if (K == 0) {
            result.add(root.data);
            return;
        }
        process(root.left, result, K - 1);
        process(root.right, result, K - 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(4);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n4.left = n7;
        n4.right = n8;
        n2.left = n5;
        n2.right = n6;

        List<Integer> result = distanceK(root, n1, 2);
        result.stream().forEach(i -> System.out.print(i + " "));
    }

}
*/
