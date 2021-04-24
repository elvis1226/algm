package org.dgf.array;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> iterate(List<Integer> prefix, List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        if (array.isEmpty()) {
            result.add(prefix);
            return result;
        }

        for (int i = 0 ;i < array.size();i++) {
            int cur = array.get(i);
            List<Integer> remains = new ArrayList<>();
            remains.addAll(array.subList(0,i));
            remains.addAll(array.subList(i+1,array.size()));

            List<Integer> newPrefix = new ArrayList<>();
            newPrefix.addAll(prefix);
            newPrefix.add(cur);

            List<List<Integer>> matched = iterate(newPrefix , remains);
            result.addAll(matched);

        }
        return result;
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (array.isEmpty()) return result;

        return iterate(new ArrayList<Integer>(), array);
    }
}
