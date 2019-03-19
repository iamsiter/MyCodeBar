package com.super30;

import java.util.Stack;

public class DecodeStringStackMtd_34 {
    public static void main(String[] args) {
        System.out.println("Result");
        System.out.println(decodeString("10[a]ef3[cd]"));
    }

    public static String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0, count = 0;

        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + s.charAt(idx) - '0';
                    idx++;
                }
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                res = res + s.charAt(idx++);
            }

        }
        return res;
    }
}



