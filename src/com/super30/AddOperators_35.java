package com.super30;

import java.util.ArrayList;
import java.util.List;

public class AddOperators_35 {
    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        int val = num.charAt(0) - '0';
        helper(num, 1, result, target, val, val, num.charAt(0) + "");
        return result;
    }

    public static void helper(String num, int idx, List<String> result, int target, int last, int curr, String expression) {

        if (idx == num.length() && target == curr) {
            result.add(expression);
            return;
        }

        if(idx == num.length())
            return;


        for (int i = idx; i < num.length(); i++) {
            int val = num.charAt(idx) - '0';
            curr = curr + val;
            helper(num, idx + 1, result, target, val, curr, expression + "+" + val);
            curr = curr - val;

            curr = curr - val;
            helper(num, idx + 1, result, target, val, curr, expression + "-" + val);
            curr = curr + val;

            if (last != curr) {
                curr = curr - last + (last * val);
            } else {
                curr = curr * val;
            }

            helper(num, idx + 1, result, target, val, curr, expression + "*" + val);
        }
    }


    public static void main(String[] args) {
        List<String> result = addOperators("232", 8);
        result.stream().forEach(System.out::println);
    }

}
