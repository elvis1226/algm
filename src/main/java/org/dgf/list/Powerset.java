package org.dgf.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Powerset {

    public static List<List<Integer>> list(List<Integer> nums) {
        List<List<Integer>> ans = new ArrayList<>();

        scan(0,  nums, new ArrayList<>(), ans);
        return ans;
    }

    public static void scan(int index, List<Integer> nums, List<Integer> temp, List<List<Integer>> ans)
    {
        if (index == nums.size()) {

            System.out.println();
            ans.add(List.copyOf(temp));
            return;
        }
        temp.add(nums.get(index));
        scan(index+1, nums, temp, ans);
        temp.removeLast();
        scan(index+1, nums, temp, ans);

    }

    public static void main(String[] argvs) {
        List<Integer> nums = List.of(1, 2, 3);
        List<List<Integer>> res =  Powerset.list(nums);
        System.out.println("size " + res.size());
        for (List<Integer> ll : res) {
            String s = ll.stream().map(x-> x +"").collect(Collectors.joining(","));
            System.out.println(s);
        }

    }
}
