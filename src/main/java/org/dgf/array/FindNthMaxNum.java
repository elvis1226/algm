package org.dgf.array;

import org.mockito.internal.matchers.Find;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.IntStream;

   /*
    Find the nth number from a input array, so that A[0]...A[nth-1] < A[nth] < A[nth+1]...A[len -1]
    */

public class FindNthMaxNum {
    private static Logger logger = LoggerFactory.getLogger(FindNthMaxNum.class);

    public static void quickSort(int[] A, int l, int r) {
        if (l < r) {
            int p = partition(A, l, r);
            quickSort(A, l, p-1);
            quickSort(A, p+1, r);
        }
    }

    private static int partition(int[] A, int l, int r) {
        int pivot = l;

        while (l <= r) {
            if (A[l] <= A[pivot]) {
                l++;
                continue;
            } // when l is first larger than pivot, and may equal r

            if (A[r] > A[pivot] ) {
                r--;
                continue;
            } // when r is less than l, then find the position of pivot

            if (l < r)
            {
                int tmp = A[l];
                A[l] = A[r];
                A[r] = tmp;
                l++;
                r--;
            }
        }

        int tmp = A[r];
        A[r] = A[pivot];
        A[pivot] = tmp;
        return r;

    }

    public static int findNthMaximumNum(int A[], int index) {
        int result = -1;
        int l = 0, r = A.length-1;
        //logger.info("{}, index: {}", A, index);
        while(l <= r) {
            //logger.info("l:{}, r:{}, index:{}", l, r, index);
            int p = partition(A, l, r);
            int c = p-l+1;
            //logger.info("p:{},c:{}",p,c);
            //logger.info("{}", A);
            if (c == index) {
                return A[p];
            }
            else if (c < index) {
                l = p+1;
                index = index - c;
            }
            else { // c > index
                r = p-1;
            }
        }
        return result;
    }

    public static void main(String[] argvs) {
        int[] A = new int[]{4,1,3,9,19, 5,8,17,16,15,14,7,2,1,13,10,12,11,20,18,6};
        quickSort(A, 0, A.length-1);
        logger.info("{}", A);

        IntStream.range(1, 22)
                .forEach( i -> {
                    int[] input= new int[] {4,0,3,9,19, 5,8,17,16,15,14,7,2,1,13,10,12,11,20,18,6};
                    logger.info("find {}th : {}", i, findNthMaximumNum(input, i));
                });

    }
}
