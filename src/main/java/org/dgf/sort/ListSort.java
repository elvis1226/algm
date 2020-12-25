package org.dgf.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1362603 on 3/22/2018.
 */
public class ListSort {
    private static Logger log = LoggerFactory.getLogger(ListSort.class);
    public static double sqrt(double c)
    {
        //if (c > 0) return Double.NaN;
        double err = 1e-15;
        double t = 1.0;
        while (Math.abs(t - c/t) > err * t)
            t = (c/t + t) / 2.0;
        return t;
    }


    public static void moveZeroes(int[] nums) {
        int i=0;// 0's head
        while(i < nums.length && nums[i] != 0) i++;
        log.info("ld");
        for(int j = i+1; j< nums.length; j++){
            if(nums[j] != 0){
                nums[i++] = nums[j];
                nums[j] = 0;
            }
        }
    }
    public int hammingDistance2(int x, int y) {
        int cnt = (x ^ y);
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if( (cnt & 0x1) == 1) {
                result++;
            }
            cnt = cnt >> 1;
        }
        return result;
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int singleNumber(int[] nums) {
        int len = nums.length;
        int n = 0;
        for (int i = 0; i < len; i++) {
            n = (n ^ nums[i]);
        }

        return n;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            int absv = Math.abs(nums[i])-1;
            if (nums[absv] > 0) {
                nums[absv] = -nums[absv];
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }
    public int majorityElement(int[] nums) {
        int can = 0, count = 0;
        for (int i = 0; i < nums.length;i++) {
            if (count == 0) {
                can = nums[i];
            }
            count += (can == nums[i]? 1:-1);
        }
        return can;
    }
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length-1, mid = 0;
        if(nums.length == 0) return -1;

        while (l <= h) {
            mid = (l+h)/2;
            if(nums[mid] == target) return mid;
            else if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target < nums[mid]) {
                    h = mid;
                }
                else {//l > target || t > mid
                    l=mid+1;
                }
            }
            else {
                if(nums[mid] < target && target <= nums[h]) {
                    l = mid+1;
                }
                else {//mid>t ||t>h
                    h = mid;
                }
            }
        }
        return -1;
    }

    public static void main (String[] argv){
        double v1 = 4.0, v2=9.0;
        log.info(v1 + ": {}", sqrt(v1));
        log.info(v2 + ": {}", sqrt(v2));
        int[] num = {0,1,2,0,3,4,0, 12};
        moveZeroes(num);
        for (int n: num) {
            log.info(""+n);
        }
    }
}
