package org.dgf.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pathOfSum {

    public static int getpath(TreeNode head, int total, int curSum) {
        if (head == null) return 0;
        int res = 0;

        curSum += head.val;
        if (curSum == total) {
            res++;
        }

        res += getpath(head.left, total, curSum);
        res += getpath(head.right, total, curSum);

        return res;
    }
    public static int sum(TreeNode head, int total) {
        int res = 0;
        res = getpath(head, total, 0);
        res += sum(head.left, total);
        res += sum(head.right, total);

        return res;
    }


    public static void buildSumMap(TreeNode head,  int curSum, Map<Integer, Integer> map) {
        if (head == null) return;
        int runningSum = head.val + curSum;

        map.merge(runningSum, 1, (x, y) -> x+y);
        buildSumMap(head.left, runningSum, map);
        buildSumMap(head.right, runningSum, map);
    }

    public static int sum2(TreeNode head, int total) {
        Map<Integer, Integer> map = new HashMap<>();
        buildSumMap(head, 0, map);
        int res = 0;
        for (Integer key : map.keySet()) {
            if (key == total) {
                res++;
            }
            int newKey = key - total;
            if (map.containsKey(newKey)) {
                res += map.get(newKey);
            }
        }

        return res;
    }

    public static int sum3(TreeNode head, int total, int runningSum, Map<Integer, Integer> map) {
        if (head == null) return 0;

        int path = 0;
        runningSum = head.val + runningSum;
        int sum = runningSum - total;
        path = map.getOrDefault(sum, 0);

        if (runningSum == total) {
            path++;
        }

        map.merge(runningSum, 1, (x, y) -> x+y);

        path += sum3(head.left, total, runningSum, map);

        path += sum3(head.right, total, runningSum, map);

        return path;
    }
}
