package org.dgf.array;

public class SmartMaxNonAdjacentNum {
    public static int maxSubsetSum(int[] array, int start){
        int maxSum = 0;

        for (int i = start; i < array.length; i++) {
            int sum = 0;
            sum += array[i];
            sum += maxSubsetSum(array, i+2);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
    public static int maxSubsetSumNoAdjacent2(int[] array) {
        // Write your code here.
        if (array.length <= 0) return 0;
        return maxSubsetSum(array, 0);
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if (array.length <= 0) return 0;
        if (array.length == 1) return array[0];

        int[] maxSum = new int[array.length];

        int pre = array[0];
        int cur = Math.max(array[0],array[1]);
        for (int i = 2; i < array.length; i++){
            int temp = cur;
            cur = Math.max(cur, array[i] + pre);
            pre = temp;
        }
        return cur;
    }
}
