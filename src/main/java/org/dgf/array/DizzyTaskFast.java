package org.dgf.array;

import java.util.ArrayList;
import java.util.Collections;

public class DizzyTaskFast {
    public int findIdx(int[] input, int value) {
        for(int i = 0; i < input.length; i++) {
            if (input[i] == value) {
                input[i] *= -1;
                return i;
            }
        }
        return -1;
    }

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        // Write your code here.
        ArrayList<ArrayList<Integer>>  result = new ArrayList<>();

        if (tasks.size() <= 0||k <= 0 || (2*k) != tasks.size()) return result;
        int[] duplicated = new int[tasks.size()];
        for (int i=0; i < tasks.size();i++) {
            duplicated[i] = tasks.get(i);
        }

        Collections.sort(tasks);

        for (int i = 0; i < k; i++) {
            ArrayList<Integer> curPair = new ArrayList<>();
            curPair.add(findIdx(duplicated, tasks.get(i)));
            curPair.add(findIdx(duplicated, tasks.get(tasks.size() - i-1)));

            result.add(curPair);
        }

        return result;
    }
}
