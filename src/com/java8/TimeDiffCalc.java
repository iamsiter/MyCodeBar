package com.java8;

public class TimeDiffCalc {

    /*Palantir leetcode time diff in min has unique solution with rollover*/

    public static void main(String[] args) {
        String s1 = "14:00";
        String s2 = "16:45";
        System.out.println(diff(s1, s2));
    }

    public static String diff(String t1, String t2) {
        int hourDiff = 0, minDiff = 0;
        String str1[] = t1.split(":");
        String str2[] = t2.split(":");

        hourDiff = Integer.parseInt(str2[0]) - Integer.parseInt(str1[0]) - 1;   // -1 is important here
        minDiff = Integer.parseInt(str2[1]) + (60 - Integer.parseInt(str1[1]));
        if (minDiff >= 60) {
            hourDiff++;
            minDiff = minDiff - 60;

        }
        return hourDiff + ":" + minDiff;
    }
}
