package org.dgf.dynamic;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonString {
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        List<Character> result = new ArrayList<>();
        if (str1.length() == 0 ||str2.length()== 0) return result;

        int[][] lcs = new int[str1.length()+1][str2.length()+1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                char a1 = str1.charAt(i-1);
                char a2 = str2.charAt(j-1);
                if (a1 == a2) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                }
                else {
                    lcs[i][j] = Math.max(lcs[i-1][j], Math.max(lcs[i-1][j-1], lcs[i][j-1]) );
                }
            }
        }

        if (lcs[str1.length()][str2.length()] > 0) {
            String longStr = "";
            int i = str1.length();
            int j = str2.length();
            while ( i > 0 && j > 0 && lcs[i][j] != 0) {
                if (str1.charAt(i-1) != str2.charAt(j-1)) {
                    if (lcs[i][j] == lcs[i-1][j]) {
                        i--;
                    }
                    else if(lcs[i][j] == lcs[i][j-1]) {
                        j--;
                    }
                    else {
                        i--;
                        j--;
                    }
                }
                else {
                    longStr = str1.charAt(i-1) + longStr;
                    i--;
                    j--;
                }
            }

            for (int k = 0 ; k < longStr.length(); k++) {
                result.add(longStr.charAt(k));
            }
        }

        return result;
    }
}
