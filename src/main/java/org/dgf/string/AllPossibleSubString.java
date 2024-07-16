package org.dgf.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        }

        return result;
    }

    /*
     " a  b  c "
       0  0  1  -> c   (1)
       0  1  0  -> b   (2)
       1  0  0  -> a   (4)
       0  1  1  -> bc  (3)
       1  0  1  -> ac  (5)
       1  1  0  -> ab  (6)
       1  1  1  -> abc (7)

     */
    public static List<String> getPossibleStringWay2(String input) {
        final List<String> result = new ArrayList<>();
        final int maxNum = 1 << input.length() ;

        for (int i = 1; i < maxNum; i++) {
            String res = "";
            for(int bit = 0 ; bit < input.length(); bit++) {
                if ((i & (1 << bit)) != 0) {
                    res = input.charAt(input.length() - 1 - bit) + res;
                }
            }
            result.add(res);
        }
        Collections.sort(result);;
        return result;
    }

    public static void main(String[] argv) {
        final var input = "abc";
        final var result = getPossibleString(input);
        result.stream().forEach(System.out::println);
        System.out.println(" ---------- ");
        final var input2 = "aa";
        final var result2 = getPossibleString(input2);
        result2.stream().forEach(System.out::println);
        System.out.println(" ---------- ");
        final var result3 = getPossibleStringWay2 (input);
        result3.stream().forEach(System.out::println);
        //final var join3 = result3.stream().collect(Collectors.joining(" ")).toString();
        //System.out.println(join3);
    }
}
