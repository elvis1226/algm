package org.dgf.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlapIntervals {
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        if (intervals.length <= 0) {
            return new int[][] {};
        }

        List<int[]> result = new ArrayList<>();

		/*Arrays.sort(intervals, new Comparator<int[]>() {
														public int compare(int[] x, int [] y){
															 return Integer.compare(x[0], y[0]);
														}
													}
							 );*/
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        int[] curIntval =  new int[] { intervals[0][0], intervals[0][1] };
        result.add(curIntval);

        for (int i = 1; i < intervals.length; i++) {
            if (curIntval[1] >= intervals[i][0]) {
                curIntval[0] = curIntval[0] < intervals[i][0] ? curIntval[0] : intervals[i][0];
                curIntval[1] = curIntval[1] < intervals[i][1] ? intervals[i][1] : curIntval[1];
                continue;
            }
            curIntval =  new int[2];
            curIntval[0] = intervals[i][0];
            curIntval[1] = intervals[i][1];
            result.add(curIntval);
        }

        return result.toArray(new int[1][]);
    }
}
