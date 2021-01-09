package org.dgf.array;

import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class MaxSumOfSubArray {
    private static Logger logger = LoggerFactory.getLogger(MaxSumOfSubArray.class);

    public static Tuple3<Integer, Integer, Integer> findCrossMaxSumArray2(int[] n, int start, int end, int mid) {
        int sum = 0, l = 0, r = 0, lsum = 0, rsum = 0;
        boolean lflag = false, rflag = false;
        for (int i = mid; i >= start; i--) {
            sum += n[i];
            if (!lflag) {
                lsum = sum;
                lflag = true;
                continue;
            }
            else if (sum > lsum){
                lsum = sum;
                l = i;
            }
        }
        sum = lsum;
        for (int j = mid+1; j <= end; j++) {
            sum += n[j];
            if (sum > lsum){
                lsum = sum;
                r = j;
            }
        }

        return new Tuple3<>(l, r, lsum);
    }

    public static Tuple3<Integer, Integer, Integer> findCrossMaxSumArray(int[] n, int start, int end, int mid) {
        int sum = 0, l = 0, r = 0, lsum = 0, rsum = 0;
        boolean lflag = false, rflag = false;
        for (int i = mid; i >= start; i--) {
            sum += n[i];
            if (!lflag) {
                lsum = sum;
                lflag = true;
                continue;
            }
            else if (sum > lsum){
                lsum = sum;
                l = i;
            }
        }
        sum = 0;
        for (int j = mid+1; j <= end; j++) {
            sum += n[j];
            if (!rflag) {
                rflag = true;
                rsum = sum;
                continue;
            }
            else if (sum > rsum){
                rsum = sum;
                r = j;
            }
        }

        return new Tuple3<>(l, r, lsum + rsum);
    }

    public static Tuple3<Integer, Integer, Integer> findMaxSumArray(int[] n, int start, int end) {
        Tuple3<Integer, Integer, Integer> result ;

        if (start == end) {
            return new Tuple3(start, end, n[start]);
        } else {
            int mid = start + (end - start) / 2;

            Tuple3<Integer, Integer, Integer> left = findMaxSumArray(n, start, mid);
            Tuple3<Integer, Integer, Integer> right = findMaxSumArray(n, mid + 1, end);
            Tuple3<Integer, Integer, Integer> cross = findCrossMaxSumArray2(n, start, end, mid);

            if (left.third() >= right.third() && left.third() >= cross.third()) {
                result = new Tuple3(left);
            }
            else if (right.third() >= left.third() && right.third() >= cross.third()) {
                result = new Tuple3(right);
            }
            else {
                result = new Tuple3(cross);
            }

            return result;
        }
    }

    public static void main(String[] argvs) {
        int input[] = {2, -1, 4, 3, -9, 4, -2, 3, 5, -2, -3, 2, 3};
        StringBuilder sb = new StringBuilder();
        Joiner joiner = Joiner.on("  ");
        String ss = joiner.join(IntStream
                .rangeClosed(0, input.length-1).iterator())
                .toString();
        logger.info("[{}]", ss);
        logger.info("{}", input);
        Tuple3<Integer, Integer, Integer> result = findMaxSumArray(input, 0, input.length-1);
        logger.info("{}", result);
    }

    static class Tuple3<T, P, Q> {
        private P t2;
        private T t1;
        private Q t3;

        Tuple3(T t1, P t2, Q t3) {
            this.t1 = t1;
            this.t2 = t2;
            this.t3 = t3;
        }

        Tuple3(Tuple3<T, P, Q> other) {
            this.t1 = other.first();
            this.t2 = other.second();
            this.t3 = other.third();
        }

        T first() {
            return t1;
        }

        P second() {
            return t2;
        }

        Q third() {
            return t3;
        }

        @Override
        public String toString() {
            return "Tuple3{" +
                    "t1=" + t1 +
                    ", t2=" + t2 +
                    ", t3=" + t3 +
                    '}';
        }
    }
}
