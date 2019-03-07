package com;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    Map<Long, Node> map = new HashMap<>();

    class Node {
        long data;
        int rank;
        Node parent;
    }

    public void makeSet(long data) {
        Node n = new Node();
        n.parent = n;
        n.data = data;
        map.put(data, n);
    }

    public boolean union(long data1, long data2) {
        Node root1 = map.get(data1);
        Node root2 = map.get(data2);

        Node parent1 = findSet(root1);
        Node parent2 = findSet(root2);

        if (parent1 == parent2)
            return false;

        if (parent1.rank >= parent2.rank) {
            //increment rank only if both sets have same rank
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
    }

    private Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node)
            return parent;
        node.parent = findSet(node.parent); //Path compression happening here
        return node.parent;
    }

    public long findSet(long data) {
        return findSet(map.get(data)).data;
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
    }

}
