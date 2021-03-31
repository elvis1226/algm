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
}
