package org.dgf.algm;

/**
 * Created by apple on 18/3/30.
 */
public class AtoInteger {
    public static final int INT_MAX = 2147483647;
    public static final int INT_MIN = -2147483648;

    public boolean isNum(Character c) {
        return (c >= '0' && c <='9');
    }

    public boolean isSign(Character c) {
        return (c == '+' || c == '-');
    }

    public boolean isOverflow(long val) {
        return val > INT_MAX || val < INT_MIN ;
    }

    public long getSign(Character c) {
        long sign = 1L;

        switch (c) {
            case '+' : sign = 1L; break;
            case '-' : sign= -1L; break;
            default: break;
        }
        return sign;
    }

    public long getVal(Character c) {
        return ((long)c - (long)'0');
    }

    public boolean isValid(Character c) {
        return isNum(c) || isSign(c) || c == ' ';
    }

    public int myAtoi(String str) {
        int  len = 0;
        long value = 0L;
        boolean bFlag = false;
        int signIdx = -1;
        long sign = 1L;
        len = str.length();

        if(len <= 0) return 0;

        for(int i = 0; i < len; i++) {
            Character c = str.charAt(i);

            if(bFlag && !isNum(c)) {
                break;
            }

            if(!isNum(c) && !isSign(c)) continue;

            bFlag = true;
            if(isSign(c)) {
                if((i+1) < len && !isNum(str.charAt(i+1))) return 0;
                signIdx = i;
                sign = getSign(c);
                continue;
            }

            if(isNum(c)) {
                if(signIdx == -1 && (i-1) >= 0 && !isValid(str.charAt(i-1))) {
                    return 0;
                }
                long tmp = getVal(c)*sign;
                value = value * 10 + tmp;
            }

            if(isOverflow(value)) {
                if (sign == 1) return INT_MAX;
                else return INT_MIN;
            }

        }

        return (int)value;
    }

    public static void main(String[] args) {
        AtoInteger at = new AtoInteger();
        System.out.println(at.myAtoi("   010"));
    }

    public static int countBit(int num) {
        int pos = 1;
        int[] cnt = new int[num];
        for (int i = 1; i < num ; i++) {
            if (i == 1) cnt[i-1] = 1;
            else {
                int target = 1 << pos;
                if (target == i) cnt[i-1] = 1;
                else {
                    if (target > i) cnt[i-1] = cnt[1<<(pos-1)] + cnt[i];
                    else pos++;
                }
            }
        }
        return cnt[num-1];
    }
}
