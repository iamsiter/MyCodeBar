package com.java8;

import java.util.ArrayList;
import java.util.List;

public class DoubleColonTest {
    public static int counter = 0;
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/double-colon-operator-in-java/
        List<Integer> result = new ArrayList<>();
        result.stream().forEach(System.out::println);

        //More examples
        //result.stream().forEach(DoubleColonTest::counter);
        //list.forEach((new GFG())::someFunction);

    }
}
