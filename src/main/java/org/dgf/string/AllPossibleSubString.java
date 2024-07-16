package org.dgf.string;

import java.util.ArrayList;
import java.util.List;

/*
 string input = "abc"
 string output like " a, ab, abc, ac, b, bc , c"
 1. iterate the char from left to right one by one as header
 2. iterate the remaining chars with the header
 */
public class AllPossibleSubString {

    public static List<String> getSubstring(String prefix, String input) {
        List<String> result = new ArrayList<>();

        if (! prefix.isEmpty()) {
            result.add(prefix);
        }

        if (input.isEmpty()) {
            return result;
        }

        for (int i = 0; i < input.length(); i++) {
            var cur = input.charAt(i);
            var left = getSubstring(prefix + cur, input.substring(i+1));
            result.addAll(left);
        }
        return result;
    }

    public static List<String> getPossibleString(String input) {
        final List<String> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i ++) {
            var cur = input.charAt(i);
            result.add(cur + "");

            var remaing = input.substring(i+1);
            var subs = getSubstring("", remaing);
            for (String s : subs) {
                result.add(cur + s);
            }
            result.stream().forEach(System.out::println);
            System.out.println(i + " ---------- ");
        }

        return result;
    }

    public static void main(String[] argv) {
        final var input = "abc";
        final var result = getPossibleString(input);
        result.stream().forEach(System.out::println);
    }
}
