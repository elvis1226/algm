package org.dgf.array;

import java.util.Arrays;

public class SmartClosestDifference {
    public static int findPosition(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (num <= arr[i]) {
                return i;
            }
        }
        return arr.length-1;
    }

    public static boolean isBigger(int l1, int l2, int r1, int r2) {
        return Math.abs(l1 - l2) > Math.abs(r1 - r2);
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        //Arrays.sort(arrayOne);
        if (arrayOne.length <= 0 || arrayTwo.length <= 0) {
            return new int[]{};
        }
        Arrays.sort(arrayTwo); // O(mlogm);
        int[] result = new int[2];
        result[0] = 0; result[1] = Integer.MAX_VALUE;

        // mlogm + n * m
        for (int i = 0; i < arrayOne.length; i++) { //n
            int pos = findPosition(arrayTwo, arrayOne[i]); //m
            if (isBigger(result[0], result[1], arrayOne[i], arrayTwo[pos])) {
                result[0] = arrayOne[i];
                result[1] = arrayTwo[pos];
            }

            if (pos > 0) {
                if (isBigger(result[0], result[1], arrayOne[i], arrayTwo[pos-1])){
                    result[0] = arrayOne[i];
                    result[1] = arrayTwo[pos-1];
                }
            }

        }

        return result;
    }

    public static int[] smallestDifference2(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        int[] result = new int[2];
        if (arrayOne.length <= 0 || arrayTwo.length <= 0) {
            return result;
        }

        Arrays.sort(arrayOne);//mlogm
        Arrays.sort(arrayTwo);//nlogn

        result[0] = 0; result[1] = Integer.MAX_VALUE;

        int oneIdx = 0, twoIdx = 0;
        while (oneIdx < arrayOne.length && twoIdx < arrayTwo.length) {
            if (isBigger(result[0], result[1], arrayOne[oneIdx], arrayTwo[twoIdx])) {
                result[0] = arrayOne[oneIdx];
                result[1] = arrayTwo[twoIdx];
            }
            if (arrayOne[oneIdx] < arrayTwo[twoIdx]) {
                oneIdx++;
            }
            else {
                twoIdx++;
            }
        }
        return result;
    }
}
