package org.dgf.bitwise;

import java.util.Arrays;

public class TwoDuplicateOneMiss {
    public static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }
    public static void findTwoDuplicateOneMiss(int[] input, int n){
        int x = 0, y = 0;
        int result  = n;
        for (int i = 0; i < input.length;i++) {
            result ^= (i ^ input[i]);
        }

        int k = 0;
        while ( ((1<<k) & result) == 0) {
            k++;
        }
        k++;
        //k = log(result, 2);
        System.out.println("result:" +result);
        System.out.println("k:" +k);
        for (int i = 0; i < input.length;i++) {
            if ( ((1<<k) & input[i] ) != 0) {
                x ^= (input[i]);
            }
            else {
                y ^= (input[i]);
            }
        }
        for (int i = 1; i <= input.length; i++) {
            if (((1 << k) & i) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        System.out.println("x:" +x + ", y:" + y);
    }

    public static void main(String[] argvs) {
        int[] n = {1,2,3,5,6,7,7,8,9};
        findTwoDuplicateOneMiss(n, 9);
        findTwoDuplicateOne(n);
    }
    public static void findTwoDuplicateOne(int[] arr)
    {
        int n = arr.length;

        // take XOR of all array elements from index 0 to `n-1`
        // all numbers in range 1 to `n`
        int result = n;
        for (int i = 0; i < n; i++) {
            result = result ^ arr[i] ^ i;
        }

        // `x` and `y` stores the duplicate element and missing number
        int x = 0, y = 0;

        // `result` stores `x ^ y`

        // find the position of the rightmost set bit in result
        int k = log(result & -result, 2);
        System.out.println("result:" +result);
        System.out.println("k:" +k);
        // split the array into two subarrays
        for (int value: arr)
        {
            // array elements that have k'th bit 1
            if ((value & (1 << k)) != 0) {
                x = x ^ value;
            }

            // array elements that have k'th bit 0
            else {
                y = y ^ value;
            }
        }

        // split range `[1, n]` into two subranges
        for (int i = 1; i <= n; i++)
        {
            // number `i` has k'th bit 1
            if ((i & (1 << k)) != 0) {
                x = x ^ i;
            }

            // number `i` has k'th bit 0
            else {
                y = y ^ i;
            }
        }

        // linear search for the missing element
        System.out.print("The duplicate and missing elements are ");

        if (Arrays.asList(arr).contains(x)) {
            System.out.println(x + " and " + y);
        }
        else {
            System.out.println(y + " and " + x);
        }
    }
}
