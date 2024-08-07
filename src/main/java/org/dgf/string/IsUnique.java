package org.dgf.string;

public class IsUnique {

    public static boolean isUnique(String str) {
        int[] counts = new int[26];
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            counts[index] =counts[index] +1;
            if (counts[index] > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUnique2(String str) {
        int mask = 0;
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';

            if (((mask >> index) & 0x1) == 1) {
                return false;
            }
            mask |= (1 << index);
        }

        return true;
    }

    public static void main(String[] argv){
        String s1 = "helloworld";
        String s2 = "abcde";

        System.out.println("Expected false : " + isUnique2(s1));
        System.out.println("Expected true : " + isUnique2(s2));
    }
}
