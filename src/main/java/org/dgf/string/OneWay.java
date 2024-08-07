package org.dgf.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OneWay {

    public static Map<Character, Integer> getCntMap(String s ) {
        var res = new HashMap<Character, Integer>();
        if (!s.isEmpty()) {
            for (Character c : s.toCharArray()) {
                res.merge(c, 1, (n, o) -> n+o);
            }
        }

        res.entrySet().stream().forEach( e -> System.out.println(e.getKey() + "-> " + e.getValue()));
        return res;
    }

    public static boolean isOneWay(String s1, String s2) {
        if(Math.abs(s2.length() - s1.length()) > 1) {
            return false;
        }
        //delete one char, s1 have one additional char than s2, others are same;
        //insert one char, s1 have less one char than s2, others are same;
        //replace one char, s1 have a different char than s2, others are same;
        Map<Character, Integer> cntS1 = getCntMap(s1);
        System.out.println("--------------------");
        Map<Character, Integer> cntS2 = getCntMap(s2);

        int s1keySize = cntS1.keySet().size();
        int s2keySize = cntS2.keySet().size();
        if (Math.abs( s1keySize- s2keySize) >= 2) {
            return false;
        }
        Set<Character> keys = s1keySize > s2keySize ? cntS1.keySet() : cntS2.keySet();
        int diffSize = 0;
        for (Character k: keys) {
            int s1cnt = cntS1.getOrDefault(k, 0);
            int s2cnt = cntS2.getOrDefault(k, 0);
            if (s1cnt != s2cnt ) {
                if (Math.abs(s1cnt-s2cnt) != 1) {
                    return false;
                }
                else {
                    diffSize++;
                }
            }
        }
        if (diffSize == 1) {
            return true;
        }

        return false;
    }


    public static boolean isOneWay2(String s1, String s2)
    {
        var s1Len = s1.length();
        var s2Len = s2.length();
        if(Math.abs(s1Len - s2Len) > 1) {
            return false;
        }

        int cnt = 0;
        if (s1Len == s2Len) {
            for (int i = 0; i < s1Len; i++) {
                if(s1.charAt(i) != s2.charAt(i)) {
                    cnt++;
                }
            }
            if (cnt > 1) {
                return false;
            }
            return true;
        }

        if (s1Len < s2Len) {
            return isOneWay2(s2, s1);
        }
        System.out.println("s1 have more chars  than s2");
        int leftIdx = 0, rightIdx = 0;
        int diffSize = 0;
        while (leftIdx < s1.length()){
            if (s2.charAt(rightIdx) !=  s1.charAt(leftIdx)) {
                diffSize++;
            }
            else {
                rightIdx++;
            }
            leftIdx++;
        }

        for (; rightIdx < s2.length(); rightIdx++,diffSize++) {}

        return diffSize < 2;
    }

    public static void main(String[] argv){
        var first1 = "pale";
        var second1 = "ple";

        var first2 = "pales";
        var second2 = "pal";

        var first3 = "abcde";
        var second3 = "abfde";

        System.out.println("Expected true: " + isOneWay2(first1, second1));
        System.out.println("--------------------");
        System.out.println("Expected true: " + isOneWay2(second1, first1));
        System.out.println("--------------------");
        System.out.println("Expected false: " + isOneWay2(second2, first2));
        System.out.println("--------------------");
        System.out.println("Expected false: " + isOneWay2(first2, second2));
        System.out.println("--------------------");
        System.out.println("Expected true: " + isOneWay2(second3, first3));

    }
}
