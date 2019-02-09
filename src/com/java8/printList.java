package com.java8;

import java.util.Arrays;
import java.util.List;

public class printList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.stream().forEach(System.out::println);
    }
}
