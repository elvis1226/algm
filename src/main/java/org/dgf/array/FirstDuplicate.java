package org.dgf.array;

public class FirstDuplicate {
    public int firstDuplicateValue(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (result[array[i]-1] > 0) {
                return array[i];
            }
            result[array[i]-1] += 1;
        }

        return -1;
    }

    public int firstDuplicateValue2(int[] array) {
        // Write your code here.

        for (int i = 0; i < array.length; i++) {
            int value = Math.abs(array[i]);
            if (array[value-1] < 0) {
                return value;
            }
            array[value-1] *= -1;
        }

        return -1;
    }
}
