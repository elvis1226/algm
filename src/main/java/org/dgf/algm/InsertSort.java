package org.dgf.algm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertSort {
    private static Logger logger = LoggerFactory.getLogger(InsertSort.class);
    public static int[] sort(int[] input) {
        int[] target = new int[input.length];
        int j = 0, k = 0;
        target[0] = input[0];
        k = 1;
        for (int i = 1; i < input.length; i++) {
            j = k;
            while (j > 0) {
                if (input[i] >= target[j-1]) {
                    break;
                }
                else {
                    target[j] = target[j - 1];
                    j--;
                }
            }
            target[j] = input[i];
            k++;
        }
        return target;
    }

    public static int[] insertSort(int[] A) {
        //Sort the array from left to right until all the part is sorted
        //e.g first 1 item already sorted, then insert the 2nd, 3rd... to the left sorted array

        for (int i = 1, j = 1; i < A.length; i++) {
            j = i-1;
            int cur = A[i];
            while (j > -1) {
                if (cur < A[j]) {
                    A[j+1] = A[j];
                    j--;
                }
                else {
                    break;
                }
            }
            A[j+1] = cur;
        }
        return A;
    }

    public static void main(String[] argv) {
        int[] a1 = {11,2,9,4,3,4,22,8, 7, 6, 5, 13,18,7};

        logger.info("{}",a1);
        logger.info("{}",sort(a1));
        logger.info("{}",insertSort(a1));
    }
}
