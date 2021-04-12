package org.dgf.dynamic;

public class SmartWaysOfChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        if (n == 0) return 1;

        int[] chg = new int[n+1];
        chg[0] = 1;
        for (int denom : denoms) {
            for (int amt = 1; amt <= n; amt++) {
                if (denom <= amt){
                    chg[amt] += chg[amt-denom];
                }
            }
        }
        return chg[n];
    }
}
