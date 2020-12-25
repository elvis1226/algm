package org.dgf.algm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringAlgm {
    private static Logger log = LoggerFactory.getLogger(StringAlgm.class);

    public boolean isPalindromic(String s) {
        int len = s.length();
        if (len == 1) return true;

        for (int i = 0,j = len-1; i < len && j >= 0; i++,j--) {
            if (i == j) return true;
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public String extendString(int left, int right, int len, String s, String chk, String pre) {
        while (left >= 0 && right < len) {
            char lfC = s.charAt(left), rtC = s.charAt(right);
            if (lfC == rtC) {
                chk = lfC + chk + rtC;
                pre = chk.length() > pre.length() ? chk : pre;
                left--;
                right++;
            }
            else {
                break;
            }
        }
        return pre;
    }

    public String longestPalindrome(String s) {
        int len = s.length();

        String pre = "" +s.charAt(0);
        if(len == 1) return s;

        //aabbcdfghffhadelad
        for (int i = 0; i < len-1; i++) {
            String chk = ""+s.charAt(i) + s.charAt(i+1);
            if(pre.length() == len) return pre;

           if(isPalindromic(chk)){ //aa
               int k = i+2;
               while( k < len && s.charAt(k-1) == s.charAt(k)){
                   chk = chk+s.charAt(k);
                   k++;
               }
               pre = chk.length() > pre.length() ? chk : pre;
               pre = extendString(i - 1, k, len, s, chk, pre);

           }
           else if ((i+2) < len && isPalindromic(chk + s.charAt(i+2))) {//aba
               chk = chk + s.charAt(i+2);
               pre = chk.length() > pre.length() ? chk : pre;
               pre = extendString(i - 1, i + 3, len, s, chk, pre);
           }
        }
        return pre;
    }

    public static void testIsPalindromic() {
        StringAlgm so = new StringAlgm();
        String s1 = "aba",s2 = "bbb", s3 = "dabbac";
        log.info("a {}", so.isPalindromic("a"));
        log.info(s1 + " {}", so.isPalindromic(s1));
        log.info(s2 + " {}", so.isPalindromic(s2));
        log.info(s3 + " {}", so.isPalindromic(s3));
    }

    public static void testCheckPalindromic() {
        StringAlgm so = new StringAlgm();
        String s1 = "abcd",s2 = "fdfbbafdfdfdfdfdfdfdf", s3 = "dabbac", s4="abbbbc", s5="bbbbbb";
        String s6= "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
        log.info(s1 + " {}", so.longestPalindrome(s1));
        log.info(s2 + " {}", so.longestPalindrome(s2));
        log.info(s3 + " {}", so.longestPalindrome(s3));
        log.info(s4 + " {}", so.longestPalindrome(s4));
        log.info(s5 + " {}", so.longestPalindrome(s5));
        log.info(s6.length() + " {}", so.longestPalindrome(s6).length());
    }

    public int strStr(String haystack, String needle) {
        if(needle.length() <= 0) {
            return 0;
        }

        int cur = -1;
        for (int i = 0;i < haystack.length(); i++) {

            int j = 0;
            for(int k = i; j < needle.length() && k < haystack.length();j++,k++){

                if (haystack.charAt(k) == needle.charAt(j)) {
                    cur = i;
                }
                else {
                    cur = -1;
                    break;
                }
            }
            if (j == needle.length()) break;
            else cur = -1;
        }
        return cur;
    }

    public static String addBinary(String a, String b) {
        if(a.length() == 0) return b;
        else if(b.length() == 0) return a;
        String result = "";
        String pre = "";

        int i = a.length() -1, j = b.length()-1;
        for(;i >= 0  && j >= 0 ;i--,j--) {
            Character l = a.charAt(i), r = b.charAt(j);
            if(l != r) {
                result = pre == "" ? "1" + result : "0" + result;

            }
            else if(l == r && r == '1') {
                result = pre == "" ? "0" + result : "1" + result;
                pre = "1";
            }
            else if(l == r && r == '0') {
                if(pre == "") {
                    result = "0" + result;
                }
                else {
                    result = "1" + result;
                    pre = "";
                }
            }
        }

        if(i >= 0){
            for(; i >= 0; i--){
                Character tmp = a.charAt(i);
                if(pre == "") result = tmp +result;
                else {
                    String r = tmp+"";
                    if (!r.equals(pre)) {
                        result = pre+result;
                        pre = "";
                    }
                    else {
                        result = "0" + result;
                        pre = "1";
                    }
                }
            }
        }
        else if(j >=0) {
            for(; j >= 0; j--){
                Character tmp = b.charAt(j);
                if(pre == "") result = tmp +result;
                else {
                    String r = tmp+"";
                    if (!r.equals(pre)){
                        result = pre+result;
                        pre = "";
                    }
                    else {
                        result = "0" + result;
                        pre = "1";
                    }
                }
            }
        }

        return pre+result;
    }

    public static String convert(String s, int numRows) {
        int len = s.length();
        boolean upDown = false;
        char[][] out = new char[numRows][len];
        if(s.equals("")) return s;
        if(numRows == 1) return s;
        int k = 0,j = 0;
        for (int i = 0; i < len; i++) {
            if(!upDown) {
                if(k < numRows) {
                    out[k][j] = s.charAt(i);
                    k++;
                }
                else {
                    upDown = true;
                    k = numRows -2;
                    j++;
                    i--;
                }
            }
            else
            {
                if(k >= 0) {
                    out[k][j] = s.charAt(i);
                    k--;
                    j++;
                }
                else {
                    k = 1;
                    j--;
                    i--;
                    upDown = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int m = 0;m< numRows;m++) {
            for(int n = 0;n< len; n++) {
                if(out[m][n]!= '\u0000') sb.append(out[m][n]);
            }
        }

        return sb.toString();
    }

    public static boolean iter_wild(char[] p, char[] s, int pn, int sn, int pi, int si) {
        boolean start = false;
        while (pi < pn) {
            if(p[pi] ==  '*') {
                if (si >= sn) {
                    pi++;
                    continue;
                }
                while((pi+1) < pn && p[pi+1] == '*') {pi++;}
                if(pi >= pn) return true;
                if(iter_wild(p, s, pn, sn, pi+1, si)) return true;

                si++;
            }
            else {
                if (si >= sn) return false;
                if (p[pi] == s[si] || p[pi] == '?') {
                    pi++; si++;
                }
                else return false;
            }
        }
        while(pi < pn && p[pi] == '*') pi++;
        return (pi >= pn ? si >= sn : false);
    }


    public static boolean wild_match(String s, String p) {
        return iter_wild(p.toCharArray(),
                s.toCharArray(),
                p.length(),
                s.length(),
                0,
                0);
    }

    public static void testWildchar() {
        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        //log.info("res :" + wild_match(s,p));
        String s1="aab";
        String p1="*a*b";
        log.info("res :" + wild_match(s1,p1));
        log.info("res1 :" + wild_match(s,p));
    }
    public static void main(String[] argv) {
        //StringAlgm.testCheckPalindromic();
        //log.info(convert("ABCdfge,",2));
        //testWildchar();
        String s = "aabbdaa";
        log.info("{}", convert(s));
        log.info(""+lastworklength("hello world"));
    }

    public static int lastworklength(String s) {
        int len = 0;
        for (int i = 0; i < s.length();i++) {
            if ((i+1) < s.length() && s.charAt(i) == ' ' && s.charAt(i+1) != ' ') len = 0;
            else if (s.charAt(i) != ' ') len++;
        }
        return len;
    }

    public static String convert(String input) {
        int times = 1;
        char prev, cur;
        String result = "";

        prev = input.charAt(0);
        for (int i = 0; i < input.length();i++) {
            if (i > 0) {
                if (prev == input.charAt(i)) {
                    times++;
                }
                else {
                    result += prev;
                    prev = input.charAt(i);
                    if (times > 0) {
                        result += times;
                        times = 1;
                    }
                }
            }
        }
        result += prev;
        result += times;
        return result;
    }

    static boolean isOneEditDistance(String m, String n) {
        return false;
    }

    static void testIsOneEditDistance() {

    }
}
