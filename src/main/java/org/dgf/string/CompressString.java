package org.dgf.string;


import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CompressString {

    public static String compress(String input) {
        String res = "";
        int start = 0, end = 0, cnt = 0;
        char startChar = 0 ;

        while (end < input.length()) {
            startChar = input.charAt(start);
            char endChar = input.charAt(end);
            if (startChar == endChar) {
                cnt++;
                end++;
            }
            else {
                res += "" + startChar + cnt;
                cnt = 0;
                start = end;
            }
        }
        res += "" + startChar + cnt;
        System.out.println(res);
        return res.length() > input.length() ? input : res;
    }
    public static void main(String[] argvs) {
        String s1 = "aabcccccaaa";
        String s1Expected = "a2b1c5a3";

        String s2 = "abbccd";
        String s2Expected = "abbccd";

        var inputs = Stream.of(s1, s2).collect(toList());
        var outputs = Stream.of(s1Expected, s2Expected).collect(toList());

        for (int i = 0; i < inputs.size(); i++) {
            if (outputs.get(i).equals(compress(inputs.get(i)))){
                System.out.println(i + " passed");
            }
            else {
                System.out.println(i + " failed");
            }
        }

    }
}
