package com.mana.solutions.trees;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode createTree(Integer[] array) {

        if (array == null || array.length == 0)
            return null;
        TreeNode n = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(n);
        int count = 1;
        while (count < array.length || !queue.isEmpty()) {
            n.left = new TreeNode(array[count++]);
            queue.add(n);
            if (count < array.length) {
                n.right = new TreeNode(array[count++]);
                queue.add(n.right);
            }
        }
        return n;
    }
}
