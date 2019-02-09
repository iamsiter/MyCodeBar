package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysToList {
    public static void main(String[] args) {

        //Array to List
        Integer [] nums = new Integer []{1,2,3,4,5};
        List <Integer> list =  new ArrayList<>(Arrays.asList(nums));

        //Using Java 8
        int [] nums2 = new int []{1,2,3,4,5};
        List<Integer> listStream = Arrays.stream(nums2).boxed().collect(Collectors.toList());

        //List to array

        Integer [] a =listStream.toArray(new Integer[listStream.size()]);

    }
}
