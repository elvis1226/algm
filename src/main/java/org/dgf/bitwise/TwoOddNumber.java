package org.dgf.bitwise;

public class TwoOddNumber {
    public static void findTwoOddNumber(int[] input) {
        int x = 0, y = 0;
        int result = 0;
        for (int i : input) {
            result ^= i;
        }
        int k = (int)(Math.log(result) / Math.log(2));
        System.out.println("log : " + Math.log(result) / Math.log(2));
        System.out.println("r: " + result + ", k:" + k);
        for (int i : input) {
            if ((i & (1<<k)) != 0) {
                x ^= i;
            }
            else y ^= i;
        }
        System.out.println(x + ", " + y);
    }

    public static void main(String[] argvs) {
        int[] n = {1,1,3,3, 4,4,4,5,5,8,8,8,9,9};
        findTwoOddNumber(n);
    }
}
