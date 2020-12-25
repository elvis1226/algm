package org.dgf.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ArrayAlgm {
    static Logger log = LoggerFactory.getLogger(ArrayAlgm.class);

    /*
    Iterate from long array and shrink to smaller one and return the length
    @param s The sum of the target
    @param n The input array
    @return  The minimum length of the sub array that older and equal to the s
     */
    static int minimizeSubArrayWithSum(int s, int[] n) {
        int result = n.length;
        int start = 0, i = 0, sum = 0 ;
        while (i < n.length) {
            if (sum >= s) {
                result = Math.min(result, i-start);
                sum -= n[start];
                start++;
            }
            else {
                if (i == n.length) break;
                sum += n[i];
                i++;
            }
        }

        return result;
    }

    static void testMinimizeSubArrayWithSum() {
        int[] input1 = {2,1,2,3,4,3,5,6};
        int s1 = 7, expected1 = 2;
        log.info("Expected {}, Actual {}", expected1, minimizeSubArrayWithSum(s1, input1) );
        int[] input2 = {2,1,2,3,4,3,5,6};
        int s2 = 9, expected2 = 2;
        log.info("Expected {}, Actual {}", expected2, minimizeSubArrayWithSum(s2, input2) );
    }

    static int removeDuplicatedII(int[] n) {
        boolean isDuplicated = false;
        int i = 0,j = 1;
        for (; j < n.length; ) {
            if (n[i] == n[j]) {
                if (isDuplicated) {
                    j++;
                }
                else {
                    n[++i] = n[j++];
                    isDuplicated = true;
                }
            }
            else {
                n[++i] = n[j++];
                isDuplicated = false;
            }
        }
        return i+1;
    }

    static void testRemoveDuplicatedII() {
        Thread a ;
        int[] input = {1,1,2,2,2,2,3,3,4,4,4,5,5,6,6,6,7,8,8,8};
        log.info("{}", input);
        log.info("Expected 15, Actual {}", removeDuplicatedII(input));
        log.info("{}", input);
        int[] input2 = {1,2,3,4,5};
        log.info("Expected 5, Actual {}", removeDuplicatedII(input2));
        log.info("{}", input2);
    }

    static void moveZero(int[] n) {
        for (int i = -1, j = 0; j < n.length; j++) {
            if (n[j] == 0) {
                if (i == -1) i = j;
                continue;
            }

            if (i != -1) {
                n[i++] = n[j];
                n[j] = 0;
            }
        }
    }

    static void testMoveZero() {
        int[] n = {0,1,2,3,0,4,5,0};
        moveZero(n);;
        log.info("{}",n);
    }

    static int minmumCandys(int[] rating) {
        if (rating.length <= 0) return 0;

        int[] candys = new int[rating.length];
        candys[0] = 1;
        //left to right
        for (int i = 1; i < rating.length; i++) {
            if (rating[i] > rating[i-1]) {
                candys[i] = candys[i-1] + 1;
            }
            else
            candys[i] = 1;
        }
        int result = candys[rating.length-1];
        //right to left
        for (int i = rating.length-2; i >= 0; i--) {
            if (rating[i] > rating[i+1]) {
                if (candys[i] <= candys[i+1]) {
                    candys[i] = candys[i+1] +1;
                }

            }
            result += candys[i];
        }
        log.info("{}", candys);
        return result;
    }

    static void testMinmumCandys(){
        int[] c1 = {2,1,3,5,4,6};
        int r1 = minmumCandys(c1);
        log.info("{}, {}",r1,c1);

        int[] c2 = {1,3,2,6,5,3,4};
        int r2 = minmumCandys(c2);
        log.info("{}, {}",r2,c2);
    }

    static List<String> summaryRange(int[] n) {
        List<String> result = new ArrayList<>();
        if (n.length <= 0) return result;

        String s = "" +n[0];

        for (int i = 1; i < n.length; i++) {
            if (n[i] == n[i-1] +1) {
                continue;
            }

            if (!s.equals("" + n[i-1])) {
                s = s + "->" + n[i - 1];
            }
            result.add(s);
            s = "" + n[i];
        }
        result.add(s);
        return result;
    }
    static void testSummaryRange(){
        int[] c = {0,1,2,3,5,6,7,9,10,13};
        List<String> r = summaryRange(c);
        log.info("{}, {}",c, r );

        int[] c2 = {0,1,2,4,5,7};
        List<String> r2 = summaryRange(c2);
        log.info("{}, {}",c2, r2 );
        int[] c3 = {0};
        List<String> r3 = summaryRange(c3);
        log.info("{}, {}",c3, r3 );

    }

    //only for wd1 equals wd2
    static int shortestWordDistance(String[] words, String wd1, String wd2) {
        int result = Integer.MAX_VALUE;
        int left = -1, right = -1, turn = 0;
        for (int i = 0; i < words.length; i++) {
            if (wd1.equals(words[i]) && (turn == 2 ||turn == 0)) {
                left = i;

                if (right != -1 && turn == 2) {
                    result = Integer.min(Math.abs(left-right), result);

                }
                turn = 1;
            }
            else if (wd2.equals(words[i]) && (turn == 1 || turn == 0)) {
                right = i;

                if (left != -1 && turn == 1 ) {
                    result = Integer.min(Math.abs(left-right), result);

                }
                turn = 2;
            }

        }
        return result;
    }

    static void testShortestWordDistance()
    {
        String[] words1 = {"hello", "world", "you", "hello", "jacck","hello", "world", "nami", "jacck"} ;
        log.info("{}",words1);
        log.info("{}, 2, hello -> hello", shortestWordDistance(words1,"hello","hello"));
        log.info("{}, 1, nami -> world", shortestWordDistance(words1,"nami","world"));
        log.info("{}, 2, jacck -> world", shortestWordDistance(words1,"jacck","world"));
    }

    static void mergeSortedArray(int[] A, int m, int[] B, int n) {

    }
    public static void main(String[] argv) {
        /*testMinimizeSubArrayWithSum();
        testRemoveDuplicatedII();
        testMoveZero();
        testMinmumCandys();
        testSummaryRange();*/
        testShortestWordDistance();
    }
}
