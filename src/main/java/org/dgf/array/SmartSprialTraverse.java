package org.dgf.array;

import java.util.ArrayList;
import java.util.List;

public class SmartSprialTraverse {
    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> result = new ArrayList<Integer>();
        int rows = array.length, columns = array[0].length;
        int rowIdx = 0, colIdx = 0, level = 0;

        while (rows > 0 && columns > 0) {
            //1,1 ~ 1,n left
            int lastCol = -1;
            for (int i = colIdx; i < (array[0].length-level); i++) {
                result.add(array[rowIdx][i]);
                lastCol = i;
            }

            //2,n ~ m,n down
            int lastRow = -1;
            if (lastCol != -1) {
                for (int i = rowIdx+1; i < (array.length-level); i++) {
                    result.add(array[i][lastCol]);
                    lastRow = i;
                }
            }

            //m,n-1 ~ m,0 right
            int firstCol = -1;
            if (lastCol != -1 && lastRow != -1) {
                for (int i = lastCol-1; i >= colIdx; i--) {
                    result.add(array[lastRow][i]);
                    firstCol = i;
                }
            }

            //m-1,0 ~ 2,0  up
            if (firstCol != -1 && lastRow != -1) {
                for (int i = lastRow-1; i > rowIdx; i--) {
                    result.add(array[i][firstCol]);
                }
            }
            rowIdx++;
            colIdx++;
            level++;
            rows -= 2;
            columns -= 2;

        }

        return result;
    }
}
