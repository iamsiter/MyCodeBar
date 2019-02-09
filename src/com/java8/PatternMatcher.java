package com.java8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("is");
        Matcher matcher = pattern.matcher("This is the text which is to be searched");

        System.out.println(matcher.matches());
        System.out.println(matcher.lookingAt());

        while(matcher.find()){
            System.out.println(matcher.group().length());
            System.out.println("Start::"+matcher.start()+"  "+"End::"+matcher.end());
        }
    }
}
