package org.dgf.sort;

public class LargestThreeNumber {
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        if(array == null || array.length < 3) {
            return new int[] {};
        }

        int[] result = new int[3];
        result[0] = array[0];
        int curLen = 1, j = 0;
        for (int i = 1;i < 3; i++){
            j = curLen - 1;
            while(j >= 0 && result[j]> array[i]){
                result[j+1] = result[j];
                j--;
            }
            result[j+1] = array[i];
            curLen++;
        }

        for (int i = 3; i < array.length; i++) {
            if (result[0] > array[i]) {
                continue;
            }

            if (result[1] > array[i]) {
                result[0] = array[i];
                continue;
            }
            else {
                result[0] = result[1];
            }

            if(result[2] > array[i]) {
                result[1] = array[i];
            }
            else {
                result[1] = result[2];
                result[2] = array[i];
            }
        }
        return result;
    }
}
