package org.dgf.algm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class TwoSumCls {
    public static Logger logger = LoggerFactory.getLogger(TwoSumCls.class);
    private Map<Integer,Integer> items = new TreeMap<>();

    public void add(int num) {
        this.items.put(new Integer(num), new Integer(num));
    }

    public boolean find(int sum) {
        Object[] keys  = this.items.keySet().toArray();
        for (int start = 0, end = keys.length-1; start < end;) {
            int temp =  (Integer)keys[start] + (Integer)keys[end];
            if(temp < sum) start++;
            else if (temp > sum) end--;
            else return true;
        }
        return false;
    }

    public Set<List<Integer>> findTriplet(int[] n, int sum) {
        Set<List<Integer>> items = new HashSet<>();
        Arrays.sort(n);
        for (int i = 0; i < n.length-2; i++) {
            int j = i+1, k = j+1;
            for (; j < n.length ;) {
                if (k >= n.length) {
                    j++;
                    k = j+1;
                    continue;
                }
                int ts = n[i]+n[j] + n[k];
                if(sum == ts) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(n[i]);
                    temp.add(n[j]);
                    temp.add(n[k]);
                    items.add(temp);
                }
                k++;
            }


        }
        return items;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums == null || nums.length<3)
            return result;

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){

            if(i==0 || nums[i] > nums[i-1]){
                int j=i+1;
                int k=nums.length-1;
                while(j<k){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);
                        j++;
                        k--;
//handle duplicate here
                        while(j<k && nums[j]==nums[j-1])
                            j++;
                        while(j<k && nums[k]==nums[k+1])
                            k--;
                    }else if(nums[i]+nums[j]+nums[k]<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] argv) {
        TwoSumCls tsc = new TwoSumCls();
        tsc.add(1);
        tsc.add(5);
        tsc.add(3);
        System.out.println(tsc.find(4));
        System.out.println(tsc.find(8));
        System.out.println(tsc.find(7));
        List res = tsc.threeSum(new int[]{2,-1,-1,1,2,-4});
        logger.info("{}", res);
    }

}
