package com.mana.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeypadCombinations {
    public static List<String> letterCombinations(String digits) {
        if(digits!=null && digits.isEmpty())
            return new ArrayList();

        Map<Character,Character[]> map=new HashMap<>();
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});

        List<String> res=new ArrayList<>();
        helper(map,res,digits,new StringBuffer());
        return res;
    }

    private static void helper(Map<Character, Character[]> map, List<String> res, String digits, StringBuffer sb) {
        if(digits!=null && digits.isEmpty()){
            res.add(sb.toString());
            return;
        }


        Character[] chars= map.get(digits.charAt(0));
        for(char c:chars){
            sb.append(c);
            helper(map,res, digits.substring(1),sb);
            sb.setLength(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        List<String> res=letterCombinations("23");
        System.out.println(res);
    }
}
