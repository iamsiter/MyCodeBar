package com.mana.solutions.linkedlist;

public class ReverseInKGroups {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node n1 = new Node(2);
        root.next = n1;
        Node n2 = new Node(3);
        n1.next = n2;
        Node n3 = new Node(4);
        n2.next = n3;
        Node n4 = new Node(5);
        n3.next = n4;
        Node n5 = new Node(6);
        n4.next = n5;
        Node n6 = new Node(7);
        n5.next = n6;
        Node n7 = new Node(8);
        n6.next = n7;

        printLL(root);

        Node res = reverseInGrpsWithCondition(root, 3);
        printLL(res);

//      Node res = reverseInGrps(root, 3);
//      printLL(res);

    }

    private static void printLL(Node root) {
        Node curr = root;
        while (curr != null) {
            System.out.print(curr.val + "-->");
            curr = curr.next;
        }
        System.out.println();
    }

    private static Node reverseInGrpsWithCondition(Node root, int K) {
        if (root == null)
            return null;

        int count = 0;
        Node curr = root;
        Node prev = null;
        Node next = null;

        Node check = root;
        int c = 0;
        while (check != null) {
            c++;
            if(c==K) break;
            check = check.next;
        }

        if(c<K){
            return root;
        }

        while (curr != null && count < K) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (curr!=null)
            root.next = reverseInGrpsWithCondition(curr, K);

        return prev;
    }

    private static Node reverseInGrps(Node root, int K) {
        if (root == null)
            return null;

        int count = 0;
        Node curr = root;
        Node prev = null;
        Node next = null;

        while (curr != null && count < K) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (curr != null)
            root.next = reverseInGrps(curr, K);

        return prev;

        /*The method works fine until there is a condition that if group size is less than K then it should
         not be reversed
         If we need that group less than K should not be reversed then we have to do a lookahead check to ensure there are
         enough nodes
         See another implementation with correct usage of K
         */

    }
}
