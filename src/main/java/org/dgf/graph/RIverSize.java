package org.dgf.graph;

import java.util.ArrayList;
import java.util.List;

public class RIverSize {
    public static int iterate(int[][] matrix, int x, int y, int rows, int columns, boolean[][] accessed) {
        if (x < 0 || y < 0 || x >= rows || y >= columns) return 0;
        if (matrix[x][y] == 0 ||accessed[x][y]) return 0;

        accessed[x][y] = true;
        if (matrix[x][y] == 1) {
            int dSize = iterate(matrix, x+1, y, rows, columns, accessed);
            int rSize = iterate(matrix, x, y+1, rows, columns, accessed);
            int uSize = iterate(matrix, x-1, y, rows, columns, accessed);
            int lSize = iterate(matrix, x, y-1, rows, columns, accessed);
            return 1+dSize+rSize+uSize+lSize;
        }

        return 0;
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) return result;

        boolean[][] accessed = new boolean[matrix.length][matrix[0].length];

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0 ; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (accessed[i][j] || matrix[i][j] == 0) {
                    continue;
                }
                accessed[i][j] = true;
                if (matrix[i][j] == 1) {
                    int rightSize = iterate(matrix, i, j+1, rows, columns, accessed);
                    int downSize = iterate(matrix, i+1, j, rows, columns, accessed);
                    int upSize = iterate(matrix, i-1, j, rows, columns, accessed);
                    int leftSize = iterate(matrix, i, j-1, rows, columns, accessed);
                    result.add(1 + rightSize + leftSize + downSize + upSize);
                }

            }
        }
        return result;
    }
}
