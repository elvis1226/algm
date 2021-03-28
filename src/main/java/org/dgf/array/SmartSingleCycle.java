package org.dgf.array;

public class SmartSingleCycle {
    public static boolean hasSingleCycle2(int[] array) {
        // Write your code here.

        int cur = 0;
        for(int i = 0 ; i < array.length; i++) {
            if (i > 0 && cur == 0) {
                return false;
            }
            cur = getNext(array, cur);
        }
        return cur == 0;
    }

    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        boolean[] visited = new boolean[array.length];
        int cur = 0;
        for(int i = 0 ; i < array.length; i++) {
            if (visited[cur]) {
                return false;
            }

            visited[cur] = true;
            cur = getNext(array, cur);

        }

        return cur == 0;
    }

    public static int getNext(int[] array, int current) {
        int jump = array[current];
        int next = (jump+current) % array.length;
        if (next < 0) {
            next = array.length+next;
        }
        return next;
    }
}

