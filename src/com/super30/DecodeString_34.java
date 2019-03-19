package com.super30;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DecodeString_34 {
    public static void main(String[] args) {
        System.out.println("Result");
        System.out.println(decodeString("10[a]ef3[cd]"));
    }

    public static String decodeString(String s) {
        if (s.length() == 0 || s == null) {
            return s;
        }

        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            deque.offer(s.charAt(i));
        }
        return helper(deque);
    }

    public static String helper(Deque<Character> deque) {

        int idx = 0, repeat = 0;
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            char c = deque.poll();
            if (Character.isDigit(c)) {
                repeat = repeat * 10 + (c - '0');
            } else if (c == '[') {
                String res = helper(deque);

                for (int i = 0; i < repeat; i++) {
                    result.append(res);
                }
                repeat = 0;
            } else if (c == ']') {
                break;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
