package org.dgf.array;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxStackHeight {

    public static void maxHeight(int[] input, int x) {
        int max = input[input.length-1];
        int i = input.length-1;
        while(i >= 0 && x > 0) {
            if (max-input[i] <= x ) {
                x -= (max- input[i]);
                input[i] = max;

            }
            else {
                // before you execute below
                // input=1, 2, 6, 6, 6
                max = input[i];
            }
            i--;
        }
    }

   public static void main(String[] argv) {
        int[] input = {1, 2+2, 3+3, 5+1, 6};
        int[] input2 = {2, 3, 6};
        maxHeight(input, 5);
       IntStream.of(input).forEach(System.out::println);
       System.out.println("--------------------");
       maxHeight(input2, 1);
       IntStream.of(input2).forEach(System.out::println);
;   }
}
