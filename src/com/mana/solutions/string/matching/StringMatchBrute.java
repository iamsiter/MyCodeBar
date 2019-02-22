package com.mana.solutions.string.matching;

public class StringMatchBrute {
    public boolean match(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();

        int sLen = s.length;
        int tLen = t.length;

        for (int i = 0; i < sLen - tLen + 1; i++) {
            int j = 0;
            int count = 0;
            if (s[i] == t[j]) {
                while (j < tLen && s[i + j] == t[j]) {
                    j++;
                    count++;
                }
                if (count == tLen)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StringMatchBrute s = new StringMatchBrute();
        System.out.println(s.match("SAHILSACHDEVA", "ILSA"));
    }
}
