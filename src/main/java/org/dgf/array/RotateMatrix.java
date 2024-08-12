package org.dgf.array;

public class RotateMatrix {

    public static int[][] rotate(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for(int row = 0; row < matrix.length;row++) {
            int newCol = matrix.length-1-row;
            for (int newRow = 0; newRow < matrix.length ; newRow++) {
                res[newRow][newCol] = matrix[row][newRow];
            }
        }
        return res;
    }

    public static int[][] rotate2(int[][] matrix) {
        //upside-down rotate
        for(int row = 0; row < matrix.length/2;row++) {
            //if (row < (matrix.length-1-row))
            {
                for (int col = 0; col < matrix[0].length; col++) {
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[matrix.length-1-row][col];
                    matrix[matrix.length-1-row][col] = temp;
                }
            }
        }
        //diagnal rotate
        for (int row = 0 ; row < matrix.length; row++) {
            for(int col = 0; col < row; col++) {
                {
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[col][row];
                    matrix[col][row] = temp;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
       int[][] matrix = {
               {1, 2, 3}, //7, 8 , 9
               {4, 5, 6}, // 4, 5, 6
               {7, 8, 9}   // 1, 2, 3
                };
       int[][] expectedMatrix = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
       };

       int[][] actul = rotate2(matrix);
       for (int i = 0; i < matrix.length;i++) {
           System.out.println();
           for (int j = 0; j < actul[0].length;j++) {
               System.out.print(actul[i][j] + " ");
               if(matrix[i][j] != expectedMatrix[i][j]) {
                   //System.out.println("failed on " + i + "," +j);
               }
           }
       }
    }
}
