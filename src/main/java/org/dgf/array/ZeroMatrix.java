package org.dgf.array;

public class ZeroMatrix {

    public static void zero(int[][] input) {
        boolean[] bRows = new boolean[input.length];
        boolean[] bCols = new boolean[input[0].length];

        for (var i = 0; i < input.length;i++) {
            for(var j = 0; j < input[0].length;j++) {
                if (input[i][j] == 0) {
                    bRows[i] = true;
                    bCols[j] = true;
                }
            }
        }

        for (var i = 0; i < input.length;i++) {
            for (var j = 0; j < input[0].length; j++) {
                if (bRows[i] || bCols[j]) {
                    input[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {4, 5, 6, 2}, // 4, 5, 6
                {7, 8, 9, 10}   // 1, 2, 3
        };
        zero(matrix);
        for (var i = 0; i < matrix.length;i++) {
            System.out.println();
            for (var j = 0; j < matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
