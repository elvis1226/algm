package org.dgf.array;

public class SquareSortedArray {
    public static int[] sortedSquaredArray(int[] array) {
        int[] output = new int[array.length];
        int smallIdx = 0, largeIdx = array.length-1, lastIdx = array.length-1;
        while (smallIdx <= largeIdx){
            if (Math.abs(array[smallIdx]) < Math.abs(array[largeIdx])) {
                output[lastIdx] = array[largeIdx] * array[largeIdx];
                largeIdx--;
            }
            else {
                output[lastIdx] = array[smallIdx] * array[smallIdx];
                smallIdx++;
            }
            lastIdx--;
        }
        return output;
    }
}
