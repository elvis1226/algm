package org.dgf.array;

import java.util.Arrays;

public class SmartProduct {
    public int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];
        int[] leftRunning = new int[array.length];
        int[] rightRunning = new int[array.length];

        int leftProduct = 1, rightProduct = 1;
        for(int i = 0; i < array.length; i++) {
            leftRunning[i] = leftProduct;
            leftProduct *= array[i];
        }
        for(int i = array.length-1; i >= 0 ; i--) {
            rightRunning[i] = rightProduct;
            rightProduct *= array[i];
        }
        for(int i = 0; i < array.length; i++) {
            result[i] = leftRunning[i] * rightRunning[i];
        }
        return result;
    }

    public int[] arrayOfProducts2(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];
        Arrays.fill(result, 1);

        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length;j++) {
                if (j!=i) {
                    result[j] *= array[i];
                }
            }
        }
        return result;
    }
}
