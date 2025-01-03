package org.dgf.array;

public class ContainMoreWater {
    public static int collect(int[] heights) {
        int ans = 0;
        int left = 0, right = heights.length-1;
        while (left < right) {
            int area = (right - left) * (Math.min(heights[left], heights[right]));
            ans = Math.max(area, ans);
            if (heights[left] < heights[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return ans;
    }
}
