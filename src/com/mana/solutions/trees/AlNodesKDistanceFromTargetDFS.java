package com.mana.solutions.trees;

import java.util.ArrayList;
import java.util.List;

public class AlNodesKDistanceFromTargetDFS {

    public static int distanceFromTarget = 0;

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<>();
        distanceKFromRoot(target, K, ans); // Mine nodes K distance below
        dfsutil(root, target, K, ans); // Mine K nodes above target...this could be broken across parent nodes*^^
        return ans;
    }

    public static TreeNode dfsutil(TreeNode root, TreeNode target, int K, List<Integer> ans) {
        if (root == null) return null;
        if (root == target) {
            distanceFromTarget++;
            return root;
        }
        TreeNode leftChildInPath = dfsutil(root.left, target, K, ans);
        if (leftChildInPath != null) {//target on left subtree
            root.left = null; //clever way to stop processing of left and restore later ^
            if (K >= distanceFromTarget) {//to handle broken part ^^^
                distanceKFromRoot(root, K - distanceFromTarget, ans);
            }
            root.left = leftChildInPath; //restored later
            distanceFromTarget++;
            return root;
        }
        TreeNode rightChildInPath = dfsutil(root.right, target, K, ans);
        if (rightChildInPath != null) {//target on right subtree
            root.right = null; //clever way to stop processing of right and restore later
            if (K >= distanceFromTarget) {//to handle broken part
                distanceKFromRoot(root, K - distanceFromTarget, ans);
            }
            root.right = rightChildInPath;//restored later
            distanceFromTarget++;
            return root;
        }
        return null;
    }

    public static void distanceKFromRoot(TreeNode root, int k, List<Integer> ans) {
        if (root == null) return;
        if (k == 0) {
            ans.add(root.val);
            return;
        }
        distanceKFromRoot(root.left, k - 1, ans);
        distanceKFromRoot(root.right, k - 1, ans);
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