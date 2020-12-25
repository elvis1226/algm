package org.dgf.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by apple on 2018/8/24.
 */
public class SumTwoNum {
    static Logger log = LoggerFactory.getLogger(SumTwoNum.class);

    public static int sumTwoNum(int a, int b) {
        while ( b != 0) {
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }
    public static void main(String[] argv) {
        int[] n =  {-1,0, 1, 2, -1, -2,-1,-4};

        log.info("{}",convert(1));
        log.info("{}",convert(0));
        List<List<Integer>> result = threeSum(n);
        log.info("{}", result) ;

        int[] n1 = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> result2 = FourSum(n1, 0);
        log.info("for sum {}", result2) ;

        int[] n2 = {-1, 2, 1, -4};
        int result3 = threeCloset2(n2, 1);
        log.info("actual {} expeced {}",result3, 1);
    }

    public static List<List<Integer>> threeSum(int[] sums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(sums);

        for (int i = 0; i < sums.length-2; i++) {
            if (i == 0 || sums[i-1] < sums[i]) {

                int remaining = 0-sums[i];
                int k = i+1, m = sums.length - 1;

                while (k < m) {
                    int temp = sums[k] + sums[m];
                    if (temp > remaining) {
                        m--;
                    }
                    else if (temp < remaining) {
                        k++;
                    }
                    else {
                        List<Integer> l = new ArrayList<>();
                        l.add(sums[i]);
                        l.add(sums[k]);
                        l.add(sums[m]);
                        result.add(l);
                        k++;
                        m--;
                        while (k < m && sums[k-1] == sums[k]) {
                            k++;
                        }
                        while (k < m && sums[m+1] == sums[m]) {
                            m--;
                        }
                    }
                }
            }

        }
        return result;
    }

    static int convert(int n) {

        return ~n & 1;
    }

    static List<List<Integer>> FourSum(int[] n, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (n == null || n.length < 4) return null;

        Arrays.sort(n);

        for (int i = 0; i < n.length-3; i++) {
            if ( i != 0 && n[i] == n[i-1]) continue;;

            for (int k = i+1; k < n.length-2;k++) {
                if (k != (i+1) && n[k] == n[k-1]) continue;

                int l = k+1, h = n.length-1;
                while (l < n.length && h > k && l < h ) {
                    int sum = n[i] + n[k] + n[l] + n[h];
                    if (sum < target) {
                        l++;
                    }
                    else if (sum > target) {
                        h--;
                    }
                    else {
                        List<Integer> some = new ArrayList<>();
                        some.add(n[i]);
                        some.add(n[k]);
                        some.add(n[l]);
                        some.add(n[h]);
                        result.add(some);
                        l++;
                        h--;
                        while (l < n.length && n[l-1] == n[l]) {
                            l++;
                        }
                        while (h > k && n[h+1] ==n[h]) {
                            h--;
                        }
                    }
                }
            }
        }

        return result;
    }

    static int ThreeSumClosest(int[] n, int target) {
        int min = 0;
        boolean init = false;
        Arrays.sort(n);
        for (int i = 0; i < n.length-2; i++) {
            int l = i+1;
            while (l < n.length-1) {
                int k = l+1;
                while (k < n.length) {
                    if (!init) {
                        min = n[i] + n[l] + n[k];
                    } else {
                        if (Math.abs(min-target) > Math.abs(n[i] + n[l] + n[k] - target)) {
                            min = n[i] + n[l] + n[k];
                        }
                        else {
                            break;
                        }
                    }
                    k++;
                }
                l++;
            }
        }

        return min;
    }

    static int threeCloset2(int[] n , int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(n);
        for (int i = 0; i < n.length-2; i++) {
            int l = i+1, h = n.length-1;
            while (l < h) {
               int sum = n[i] + n[l] + n[h];
               int diff = Math.abs(sum-target);

               if (diff == 0) return sum;
               if (diff < min) {
                   min = diff;
                   result = sum;
               }

               if (sum < target) l++;
               else h--;
            }
        }
        return result;
    }
}
