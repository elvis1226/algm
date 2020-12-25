package org.dgf.array;

import java.util.List;

public class MaxSumOfSubArray {

    public static List<Integer> findMaxSumArray(int[] n, int start, int end) {
        /*
        if (start == end) {
            return (start, end, n[start]);
        }
        else {
           int mid = start + (end-start)/2;

           (l_start, l_end, l_sum) = findMaxSumArray(n,start, mid);
           (r_start, r_end, r_sum) = findMaxSumArray(n,mid+1, end);
           (c_start, c_end, c_sum) = findCrossMaxSumArray(n, start, end, mid);

           current_sum = l_sum;
           current_s = l_start;
            current_d = l_end;
           if (current_sum < r_sum) {
              current_sum = r_sum;
              current_s = r_start;
              current_d = r_end;
           }

           if (current_sum < c_sum) {
             current_sum = c_sum;
             current_s = c_start;
             current_d = c_end;
           }
           return (current_s, current_d, current_sum);
       }
         */

        return null;
    }

    public static void main(String[] argvs) {
       int input[] = {2, -1, 4, 3, -9, 4, -2, 3, 6, 4, 3, 2,1};
       //findMaxSumArray(input);
    }
}
