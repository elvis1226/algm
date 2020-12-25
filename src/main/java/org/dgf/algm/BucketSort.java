package org.dgf.algm;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public class BucketSort {
    public static void main(String[] argvs) {
        int[] test1 = new int[]{7,8,3,9,0,0,9,1,5};
        /*sort(test1, 6, buckerTize);

        }*/
        quick_sort(test1, 0 , test1.length-1);
        for(Integer t: test1) {
            System.out.println(t );
        }
    }


    private static Function<Integer, Integer> buckerTize = new Function<Integer, Integer>() {
        public Integer apply(Integer integer) {
            Map<Integer,Integer> result = new HashMap<>();
            result.put(1,5);
            result.put(2,4);
            result.put(3,2);
            result.put(4,1);
            result.put(5,3);
            result.put(6,6);
            return result.get(integer);
        }
    };



    private static void sort(Integer[] input, Integer bucketRange, Function<Integer, Integer> bucketize){
        //TODO:
        //Arrays.sort(input, (x, y) -> bucketize.apply(x) - bucketize.apply(y)  );

        //Arrays.sort(input, Comparator.comparing(bucketize));

        sort(input, 0, input.length - 1, 0, bucketRange, bucketize);
    }


    public static void quick_sort(int[] n, int l, int h)
    {
        if (l >= h) return;
        int pivot = n[(l+h)/2];
        int i = l, j = h;
        while(i <= j) {
            if (n[i] < pivot) {
                i++;
                continue;
            }
            if (n[j] > pivot) {
                j--;
                continue;
            }
            //if (i <= j)
            {
                int tmp = n[i];
                n[i] = n[j];
                n[j] = tmp;
                i++;
                j--;
            }
        }
        quick_sort(n, l, i-1);
        quick_sort(n,i, h);
    }
    private static void sort(Integer[] input, int start, int end, int bucketStart, int bucketEnd, Function<Integer, Integer> bucketize) {
        if (bucketStart >= bucketEnd) {
            return;
        }

        if (start >= end) {
            return;
        }

        int pivot = (bucketStart + bucketEnd) / 2;

        int i = start, j = end;
        while (i <= j) {
            if (bucketize.apply(input[i]) < pivot) {
                i++;
                continue;
            }
            if (bucketize.apply(input[j]) > pivot) {
                j--;
                continue;
            }
            //if (i <= j) {
                int tmp = input[i];
                input[i] = input[j];
                input[j] = tmp;
                i++;
                j--;
            //}

        }
       // if (bucketize.apply(input[i]) > pivot) i--;

        sort(input, start, i-1, bucketStart, pivot, bucketize);

        sort(input, i , end,  pivot, bucketEnd, bucketize);
    }
}