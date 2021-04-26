package org.dgf.string;

public class InterleaveString {
    public static boolean interleave(String A, String B, String C) {
        int i = 0, ai = 0, bi = 0;
        System.out.println(A + ", " + B + "= " + C);
        for (; i < C.length(); i++) {
            if (ai < A.length() && A.charAt(ai) == C.charAt(i)) {
                ai++;
                continue;
            }

            if(bi < B.length() && B.charAt(bi) == C.charAt(i)) {
                bi++;
                continue;
            }
        }
        if (ai == A.length() && bi == B.length()&& i == C.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] argvs) {
        String c = "XXXXZY";
        String a = "XXY";
        String b = "XXZ";

        String c1 = "XXY", a1 = "YX", b1 = "X";
        System.out.println(interleave(a, b, c));
        System.out.println(interleave(a1, b1, c1));
        System.out.println(interleave("XY", "WZ", "WZXY"));
        System.out.println(interleave("XY", "X", "XXY"));
        System.out.println(interleave("YX", "X", "XXY"));
        System.out.println(interleave("XXY", "XXZ", "XXXXZY"));
    }
}
