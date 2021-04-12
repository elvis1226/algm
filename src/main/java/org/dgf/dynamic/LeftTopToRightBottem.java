package org.dgf.dynamic;

import java.util.HashMap;
import java.util.Map;

public class LeftTopToRightBottem {
    public int scanGraph(int w, int h, Map<String, Integer> memo) {
        String key = w + "," + h;
        if (w == 0 || h == 0) return 0;
        if (w == 1 && h == 1) return 1;

        if(memo.containsKey(key)) return memo.get(key);

        int ways = scanGraph(w-1, h, memo) + scanGraph(w, h-1, memo);
        memo.put(key, ways);
        return ways;
    }

    public int numberOfWaysToTraverseGraph(int width, int height) {
        // Write your code here.
        if (width == 1 && height == 1) return 0;
        Map<String, Integer> memo = new HashMap<>();
        int ways = scanGraph(width, height, memo);
        return ways;
    }
}
