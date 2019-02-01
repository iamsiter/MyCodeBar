package com.mana.solutions;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeGeneration {

    static Map<String, List<Node>> memorizedMap = new HashMap<>();

    static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
        }

    }

    // A utility function to do preOrder traversal of BST
    public static void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.key);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static List<Node> constructTrees(int start, int end) {

        if (memorizedMap.containsKey(start + "-" + end)) return memorizedMap.get(start + "-" + end);
        List<Node> list = new ArrayList<>();

        if (start > end) {
            list.add(null);
        } else {
            for (int i = start; i <= end; i++) {

                List<Node> leftSubTrees = constructTrees(start, i - 1);
                List<Node> rightSubTrees = constructTrees(i + 1, end);

                for (int j = 0; j < leftSubTrees.size(); j++) {
                    Node left = leftSubTrees.get(j);

                    for (int k = 0; k < rightSubTrees.size(); k++) {
                        Node right = rightSubTrees.get(k);

                        Node root = new Node(i);
                        root.left = left;
                        root.right = right;
                        list.add(root);
                    }
                }
            }
        }

        memorizedMap.put(start + "-" + end, list);
        return list;
    }

    public static void main(String... args) {
        List<Node> result = constructTrees(1, 14);
        System.out.println("Total size is " + result.size());
        for (Node node : result) {
            preOrder(node);
            System.out.println("-----");
        }
    }
}