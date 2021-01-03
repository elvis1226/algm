package org.dgf.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Assuming the element of A[] is less than a number k, then could use C[k] and B[] to sort in linear
 */
public class CountingSort {
    private static Logger logger = LoggerFactory.getLogger(CountingSort.class);

    public static void countingSort(int[] A, int[] B, int max) {

        int[] C = new int[max];
        Arrays.stream(A).forEach(x-> C[x]++);

        for (int i = 1 ; i < C.length; i++) {
            C[i] = C[i-1] + C[i];
        }

        IntStream.range(0, A.length).forEach(i -> {
            B[C[A[i]]-1]= A[i];
            C[A[i]]--;
        });
    }

    public static void main(String[] argv) {
        int[] input = new int[] {4,3,2,1,0,5,2,3,2,4,3,1,0};
        int[] output = new int[input.length];

        int k = Arrays.stream(input).reduce(0, Integer::max) +1;
        logger.info("k : {}", k);

        logger.info("input: {}", input);

        countingSort(input, output, k);

        logger.info("output: {}",output);
    }
}
