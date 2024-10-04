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

    public static int countStep(int n, Map<Integer, Integer> memo) {
        // hop 1, 2 or 3 steps
        int result = 0;
        if (memo.containsKey(n)){
            return memo.get(n);
        }

        if (n < 0) {
            return 0;
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        result += countStep(n-1, memo);

        result += countStep(n-2, memo);

        result += countStep(n-3, memo);

        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> memo = new HashMap<>();

        int steps = countStep(3, memo);

        System.out.println("n=3, step : " + steps);
        memo.clear();

        steps = countStep(5, memo);

        System.out.println("n=5, step :" + steps);
    }
}
