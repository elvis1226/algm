package org.dgf.array;

import java.util.ArrayList;
import java.util.List;

public class MaxIncreasingSubsequences {
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        // Write your code here.
        List<List<Integer>> result = new ArrayList<>();

        if (array.length == 1) {
            List<Integer> value = new ArrayList<>();
            value.add(array[0]);
            result.add(value);
            result.add(value);
            return result;
        }

        int[] sums = new int[array.length];
        for (int i = 0; i < array.length;i++){
            sums[i] = array[i];
        }

        int maxSum = Integer.MIN_VALUE, maxStartIdx = array.length-1;
        for (int cur = array.length-1; cur >= 0; cur--) {
            for (int next = cur+1;next < array.length; next++) {
                if (array[next] > array[cur]) {
                    sums[cur] = Math.max(sums[cur], array[cur] + sums[next]);
                }
            }
            maxStartIdx = maxSum > sums[cur] ? maxStartIdx : cur;
            maxSum = Math.max(maxSum, sums[cur]);
        }

        List<Integer> maxL = new ArrayList<>();
        maxL.add(maxSum);
        result.add(maxL);

        List<Integer> subseq = new ArrayList<>();
        int k = maxStartIdx, remain = maxSum;
        while(k < array.length ) {
            if (sums[k] == remain) {
                subseq.add(array[k]);
                remain -= array[k];
            }
            k++;
        }

        result.add(subseq);
        return result;
    }
}
