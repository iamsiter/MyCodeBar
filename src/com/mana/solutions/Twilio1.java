package com.mana.solutions;

import java.util.ArrayList;
import java.util.List;

public class Twilio1 {
    public static List<String> missingWords(String s, String t) {
        String sWords[] = s.split("\\s+");
        String tWords[] = t.split("\\s+");
        List<String> res = new ArrayList<>();
        int i = 0, j = 0;

        for (i = 0, j = 0; i < sWords.length && j < tWords.length; i++) {
            if (!sWords[i].equalsIgnoreCase(tWords[j])) {
                res.add(sWords[i]);
            } else {
                j++;
            }
        }

        while (i < sWords.length) {
            res.add(sWords[i++]);
        }

        return res;
    }


}
