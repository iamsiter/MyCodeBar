package com.java8;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class PairExample {
    public static void main(String[] args) {

        List<Pair<Integer,Integer>> list = new ArrayList<>(); //<Integer,Integer> is important
        BiFunction<Integer,Integer,Pair> p = Pair::new;

      //https://www.baeldung.com/java-8-double-colon-operator

        for (int i = 1; i <= 20; i+=2) {
            list.add(p.apply(i,i+1));
        }

        list.forEach(System.out::println);

        Pair p2 = list.get(0);
        System.out.println(p2.getKey()+"--"+p2.getValue());
        list.sort(Comparator.comparing(Pair::getKey));
        list.sort((a,b)->a.getKey()-b.getKey());


    }
}
