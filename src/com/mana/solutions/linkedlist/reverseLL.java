package com.mana.solutions.linkedlist;

public class reverseLL {

    static Node reverse(Node head, Node prev) {
        if (head == null) {
            return prev;
        }

        Node result = reverse(head.next, head);
        head.next = prev;
        return result;

    }

    public static void main(String[] args) {
        //1->2->3->4->5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = reverse(head, null);
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;

        }
    }
}

