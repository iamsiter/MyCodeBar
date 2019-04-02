package com.mana.solutions.general;

/*
 * 1) Can be cleaned by making find function( logic is being repeated in all the functions)
 * 2) LOADFACTOR= #Entries in table/ # Buckets
 *
 * */
public class MyHashMap {

    HashNode[] nodes;
    int BUCKETS = 4;
    int LOAD_FACTOR = 2;
    int count = 0;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        nodes = new HashNode[BUCKETS];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hash = idx(key, BUCKETS);
        if (nodes[hash] == null) {
            nodes[hash] = new HashNode(-1, -1); //dummy node
        }

        HashNode head = nodes[hash];
        while (head.next != null && head.key != key) {
            head = head.next;
        }

        if (head.next == null && head.key != key) {
            head.next = new HashNode(key, value);
            this.count++;

            if (this.count / BUCKETS >= LOAD_FACTOR)
                reHash();

        } else {
            head.val = value;
        }
    }

    public void reHash() {
        //Basically double the buckets and rehash every node
        HashNode[] new_nodes = new HashNode[2 * BUCKETS];
        System.out.println("Rehash triggered");
        for (int i = 0; i < nodes.length; i++) {
            HashNode curr = nodes[i];
            if (curr == null)
                continue;
            curr = curr.next;
            while (curr != null) {
                int hash = idx(curr.key, 2 * BUCKETS);
                if (new_nodes[hash] == null) {
                    new_nodes[hash] = new HashNode(-1, -1);
                }
                HashNode temp = new_nodes[hash].next;
                HashNode temp2 = curr.next;

                new_nodes[hash].next = curr;
                curr.next = temp;
                curr = temp2;
            }
        }
        this.nodes = new_nodes;
        BUCKETS *= 2;
    }


    public int idx(int key, int buckets) {
        return Integer.hashCode(key) % buckets;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hash = idx(key, BUCKETS);

        if (nodes[hash] == null) {
            System.out.println("-1");
            return -1;
        }

        HashNode head = nodes[hash];
        while (head.next != null) {
            head = head.next;
            if (head.key == key) {
                System.out.println(head.val);
                return head.val;
            }
        }
        System.out.println("-1");
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = idx(key, BUCKETS);
        if (nodes[hash] == null)
            return;
        HashNode prev = nodes[hash];
        HashNode curr = prev.next;
        while (curr != null) {
            if (curr.key == key) {
                break;
            }

            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
        }
        this.count--;
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 2);
        hashMap.put(4, 2);
        hashMap.put(5, 2);
        hashMap.put(6, 2);
        hashMap.put(7, 2);
        hashMap.put(8, 2);
        hashMap.put(9, 2);
        hashMap.put(11, 2);
    }


}

class HashNode {
    int key, val;
    HashNode next;

    HashNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}