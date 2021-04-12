package org.dgf.dynamic;

import java.util.Arrays;

public class MinmumWaysOfChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        if (n == 0) return 0;

        int[] minChg = new int[n+1];
        Arrays.fill(minChg, -1);
        minChg[0] = 0;
        for (int denom : denoms) {
            for (int amount = 1; amount <= n; amount++){
                if (denom <= amount) {
                    if (minChg[amount-denom] != -1) {
                        if (minChg[amount] != -1) {
                            minChg[amount] = Math.min(minChg[amount], 1+minChg[amount-denom]);
                        }
                        else {
                            minChg[amount] = 1 + minChg[amount-denom];
                        }
                    }
                }
            }
        }

        return minChg[n];
    }
}
