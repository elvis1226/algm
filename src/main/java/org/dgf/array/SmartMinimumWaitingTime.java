package org.dgf.array;

import java.util.Arrays;

public class SmartMinimumWaitingTime {

    // [1, 2, 3, 4, 5] , 1 : wait 0, 2: wait 1, 3: wait 2+1, 4 : wait 3 +2 +1, 5: wait 4 +3+2+1
    // sum up, 1+ (2+1) + (3+2+1) + (4+3+2+1)
    public int minimumWaitingTime(int[] queries) {
        // Write your code here.
        if (queries.length < 1 || queries.length == 1) {
            return 0;
        }
        Arrays.sort(queries);
        int total = 0, pre = queries[0];
        for (int i = 1; i < queries.length; i++) {
            total += pre ;
            pre += queries[i];
        }
        return total;
    }
    public int minimumWaitingTime2(int[] queries) {
        int totalTime = 0;
        for (int i = 0; i < queries.length; i++) {
            int duration = queries[i];
            int repeatTimes = queries.length - (i+1);
            totalTime += repeatTimes*duration;
        }
        return totalTime;
    }

}
