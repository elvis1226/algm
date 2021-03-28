package org.dgf.array;

import java.util.List;

public class MoveToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int last = array.size() - 1;
        for (int i = 0 ; i < last; i++) {
            if (array.get(i) == toMove) {
                //swap the i and last, then last--
                while(array.get(last) == toMove && i < last) {
                    last--;
                }
                if (i > last) break;

                int temp = array.get(last
                );
                array.set(last, array.get(i));
                array.set(i, temp );
                last--;
            }
        }
        return array;
    }
}
