package org.dgf.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongSubString {
    public static int lengthOfLongSubstring(String s) {
        int max = 0;
        Set<Character> sub = new HashSet();
        int i = 0;

        while(i < s.length()) {
            if (sub.contains(s.charAt(i))) {
                sub.remove(s.charAt(i));
            } else {
                sub.add(s.charAt(i++));
                max = Math.max(max, sub.size());
            }
        }

        return max;
    }

    public static int lengthOfLongSubstring2(String s) {
        int i = 0;
        int j = 0;
        int max = 0;

        for(HashMap range = new HashMap(); j < s.length(); ++j) {
            if (range.containsKey(s.charAt(j))) {
                i = Math.max(i, (Integer)range.get(s.charAt(j)));
            }

            max = Math.max(max, j - i + 1);
            range.put(s.charAt(j), j + 1);
        }

        return max;
    }

    public static void testLengthOfLongSubstring() {
        String s1 = "ababdefgaaa";
        System.out.println("len1 " + lengthOfLongSubstring2(s1));
        String s2 = "abcbcadee";
        System.out.println("len2 " + lengthOfLongSubstring(s2));
        String s3 = "bbbbbb";
        System.out.println("len3 " + lengthOfLongSubstring2(s3));
    }

    public static int removeDuplicatedSortedI(int[] a, int n) {
        int index = 0;

        for(int i = 1; i < n; ++i) {
            if (a[index] != a[i]) {
                ++index;
                a[index] = a[i];
            }
        }

        return index + 1;
    }

    public static int removeDuplicatedSortedII(int[] a, int n) {
        int index = 0;
        if (n <= 2) {
            return n;
        } else {
            for(int i = 2; i < n; ++i) {
                if (a[index] != a[i]) {
                    a[index + 2] = a[i];
                    ++index;
                }
            }

            return index + 2;
        }
    }

    public void testDumplicatedSortedII() {
        int[] a = new int[]{1, 1, 1, 2, 2, 2, 3, 4, 4, 4, 5, 5, 6};
        int len = removeDuplicatedSortedII(a, a.length);
        int[] b = new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5, 6};

        for(int i = 0; i < b.length; ++i) {
            if (a[i] != b[i]) {
                System.out.println("Error");
                break;
            }
        }

    }

    public static void main(String[] args) {
        testLengthOfLongSubstring();
    }
}
