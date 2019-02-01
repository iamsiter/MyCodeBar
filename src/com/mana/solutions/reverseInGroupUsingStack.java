package com.mana.solutions;

import java.util.Stack;

public class reverseInGroupUsingStack {

    private static Node reverse(Node head, int k, Stack<Node> stack) {
        if (head == null)
            return head;

        Node curr = head;
        int count = 0;

        while (curr != null && count < k) {
            stack.push(curr);
            curr = curr.next;
            count++;
        }

        if (count != k)
            return head;

        count = k;
        curr = null;
        Node next = null;
        while (count > 0) {
            if (count == k) {
                head = stack.pop();
                curr = head;
                next = curr.next;
            } else {
                curr.next = stack.pop();
                curr = curr.next;
            }
            count--;
        }
        curr.next = reverse(next, k, stack);

        return head;
    }

    public static void main(String[] args) {
        //1->2->3->4->5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        Stack<Node> stack = new Stack<>();
        head = reverse(head, 3, stack);
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;

        }
    }


}
