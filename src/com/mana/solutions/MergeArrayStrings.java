package com.mana.solutions;

import java.util.Arrays;

public class MergeArrayStrings {

    public static String mergeStrings(String[] arr) {
        StringBuilder sb = new StringBuilder();
        int[] index = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            char[] chars = arr[i].toCharArray();
            Arrays.sort(chars);
            arr[i] = new String(chars);
        }

        int count = 1;
        while (count != 0) {
            count = 0;
            int sel_index = 0;
            char sel_char = 150;
            int sel_string=0;

            for (int i = 0; i < arr.length; i++) {
                if (index[i] < arr[i].length()) {
                    count++;
                    if (arr[i].charAt(index[i]) < sel_char) {
                        sel_char = arr[i].charAt(index[i]);
                        sel_index = index[i];
                        sel_string=i;
                    }
                }
            }

            if(count>0){
                index[sel_string] = index[sel_string] + 1;
                sb.append(sel_char);
            }

        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String arr[] = new String[5];
        arr[0] = "sdfs";
        arr[1] = "afkjasnfkv";
        arr[2] = "cnsdc";
        arr[3] = "kansdf";
        arr[4] = "koa";

        System.out.println(mergeStrings(arr));
    }

}
