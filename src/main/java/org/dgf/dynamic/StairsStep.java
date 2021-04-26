package org.dgf.dynamic;

import java.util.HashMap;
import java.util.Map;

public class StairsStep {
    public int iterate(int height, int maxSteps, Map<Integer,Integer> memo) {
        if (height < 0) return 0;

        if (memo.containsKey(height)) {
            return memo.get(height);
        }

        int ways = 0;
        for (int step = 1 ; step <= maxSteps; step++) {
            int remaing = height-step;
            ways += staircaseTraversal(remaing, maxSteps);
        }
        memo.put(height, ways);
        return ways;
    }

    public int staircaseTraversal2(int height, int maxSteps) {
        // Write your code here.
        int ways = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0,1);
        memo.put(1,1);
        ways  = iterate(height, maxSteps, memo);
        return ways;
    }

    public int staircaseTraversal(int height, int maxSteps) {
        int[] steps = new int[height+1];
        steps[0] = 1;
        steps[1] = 1;
        for (int h = 2; h <= height; h++) {
            for (int s = 1; s <= maxSteps; s++) {
                if (s <= h) {
                    steps[h] += steps[h-s];
                }
            }
        }

        return steps[height];
    }
}
