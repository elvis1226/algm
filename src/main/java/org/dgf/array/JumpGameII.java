package org.dgf.array;

public class JumpGameII {
    public static int jump(int cur, int[] input, int steps) {
        int res = -1;
        if (cur == (input.length-1)) {
            return steps;
        }
        if (cur >= input.length) {
            return -1;
        }

        for (int j = 1 ; j <= input[cur]; j++) {
            int curSteps = jump(cur+j, input, steps+1);
            if (curSteps != -1) {
                if (res == -1) {
                    res = curSteps;
                }
                else {
                    res = Math.min(res, curSteps);
                }
            }
        }
        return res;
    }

    public static int jump2(int[] nums) {
        int res = 0;
        int left = 0, right = 0 ;
        while (right < nums.length-1) {
            int fastest = 0;
            for (int i = left; i <= right; i++) {
                fastest = Math.max(fastest, i + nums[i]);
            }
            res++;
            if (fastest >= nums.length-1) {
                return res;
            }
            left = right+1;
            right = fastest;

        }
        return res;
    }
    public static void main(String[] argvs) {
        int[] input1 = {2, 3, 1, 1, 4};
        int[] input2 = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};

        int steps1 = jump2(input1);
        int steps2 = jump2(input2);
        System.out.println("step1 : " + steps1 + ", steps2 : " + steps2);
    }
}
