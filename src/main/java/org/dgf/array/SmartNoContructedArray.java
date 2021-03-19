package org.dgf.array;

import java.util.Arrays;

public class SmartNoContructedArray {

    /*
    * any new input item must less or equals than the current Cap + 1, otherwise the minimum is 1 + item > Cap +1
    * and cant calc the Cap + 1, then Cap +1  is the minimum num can't be calc
    * */
    public int nonConstructibleChange(int[] coins) {
        // Write your code here.
        if (coins.length < 1) {
            return 1;
        }

        Arrays.sort(coins);
        int changeCap = 0;
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] > (changeCap+1)) {
                return changeCap+1;
            }
            changeCap += coins[i];

        }

        return changeCap+1;
    }
}
