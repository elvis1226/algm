package org.dgf.string;

public class longestPalindromicSubstring{
    public static int[] extend(String str, int leftIdx, int rightIdx) {
        while (leftIdx >= 0 && rightIdx < str.length()) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                break;
            }
            leftIdx--;
            rightIdx++;
        }
        return new int[] {leftIdx+1, rightIdx};
    }

    public static String longestPalindromicSubstring(String str) {
        if (str.length() == 1) return str;

        String result = "";
        for (int i = 0; i < str.length(); i++) {
            //aa
            int[] even = extend(str, i-1, i);
            //aba
            int[] odd = extend(str, i-1, i+1);
            int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            String cur = str.substring(longest[0], longest[1]);
            if (cur.length() > result.length()) {
                result = cur;
            }
        }
        return result;
    }

    public static String longestPalindromicSubstring2(String str) {
        // Write your code here.
        if (str.length() == 1) return str;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(i,i+1);
            for (int j = i+1; j < str.length(); j++) {
                String temp =  prefix + str.substring(i+1,j+1);
                if (isPalindromic(temp)) {
                    if (result.length() < temp.length()){
                        result = temp;
                    }
                }
            }
        }

        return result;
    }

    public static boolean isPalindromic(String str) {
        if (str.length() == 1) return true;
        int i = 0, j = str.length()-1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
