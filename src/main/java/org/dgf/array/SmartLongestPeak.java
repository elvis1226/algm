package org.dgf.array;

public class SmartLongestPeak {
    public static int longestPeak(int[] array) {
        // Write your code here.
        if (array.length < 3) return 0;
        int maxLen = 0, start = 1, next = 0, increaseFlag = -1; // -1 intial state, 0: increasing, 1: decreasing

        while (next < array.length) {
            if (increaseFlag == -1) {
                while (start < array.length && array[start-1] >= array[start]) {
                    start++;
                }
                if (start >= array.length) {
                    break;
                }
                start--;
                next = start+1;
                increaseFlag = 0;
            }
            else if(increaseFlag == 0) {
                if (array[next] < array[next-1]) {
                    increaseFlag = 1;
                }
                else if (array[next] == array[next-1]){
                    start = next+1;
                    increaseFlag = -1;
                    continue;
                }
            }
            else { //decresing

                if (array[next] > array[next-1]) {
                    increaseFlag = -1;
                    maxLen = Math.max(maxLen, next-start);
                    start = next;
                    continue;
                }
                else if(array[next] == array[next-1]) {
                    increaseFlag = -1;
                    maxLen = Math.max(maxLen, next-start);
                    start = next+1;
                    continue;
                }
            }
            next++;
        }

        if (increaseFlag == 1 && next >= array.length && start < array.length) {
            maxLen = Math.max(maxLen, next-start);
        }

        return maxLen;
    }

    public static int longestPeak2(int[] array){
        if (array.length < 3) return 0;
        int maxPeakLen = 0;
        int i = 1;
        while (i < array.length -1) {
            boolean isPeak = array[i-1] < array[i] && array[i] > array[i+1];
            if(!isPeak) {
                i+= 1;
                continue;
            }
            int leftIdx = i-2;
            while (leftIdx >= 0 && array[leftIdx] < array[leftIdx+1]) {
                leftIdx--;
            }// leftIdx+1
            int rightIdx = i+2;
            while(rightIdx < array.length && array[rightIdx] < array[rightIdx-1]) {
                rightIdx++;
            }
            maxPeakLen = Math.max(maxPeakLen, rightIdx-1-leftIdx-1+1);
            i = rightIdx;
        }
        return maxPeakLen;
    }
}
