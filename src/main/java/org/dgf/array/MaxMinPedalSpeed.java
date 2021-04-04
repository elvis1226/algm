package org.dgf.array;

import java.util.Arrays;

public class MaxMinPedalSpeed {
    public int findMaxSpeed(int[] rSpeed, int[] bSpeed){
        int pair = 0, redIdx = rSpeed.length-1, blueIdx = bSpeed.length-1;
        int sum = 0;
        while (pair < rSpeed.length) {
            if (rSpeed[redIdx] > bSpeed[blueIdx]) {
                sum += rSpeed[redIdx];
                redIdx--;
            }
            else {
                sum += bSpeed[blueIdx];
                blueIdx--;
            }

            pair++;
        }
        return sum;
    }

    public int findMinSpeed(int[] rSpeed, int[] bSpeed){
        int redIdx = rSpeed.length-1;
        int sum = 0;
        while (redIdx >= 0) {
            if (rSpeed[redIdx] > bSpeed[redIdx]) {
                sum+= rSpeed[redIdx];
            }
            else {
                sum += bSpeed[redIdx];
            }
            redIdx--;
        }
        return sum;
    }

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.
        if(redShirtSpeeds.length <= 0 || blueShirtSpeeds.length <= 0
                ||redShirtSpeeds.length != blueShirtSpeeds.length) {
            return 0;
        }

        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if (fastest) {
            return findMaxSpeed(redShirtSpeeds, blueShirtSpeeds);
        }

        return findMinSpeed(redShirtSpeeds, blueShirtSpeeds);
    }
}
