package org.dgf.sort;

public class Count01Matrix {
    boolean isGreatStart(int actual) {
        return actual >= 0;
    }

    boolean isLessEnd(int actual, int max) {
        return actual < max;
    }

    int find(int[][] matrix, int row, int column){
        for (int step = 1; step <= 2*Integer.max(matrix.length,matrix[0].length); step++) {
            //up
            if (isGreatStart(row-step) && matrix[row-step][column] == 0) return step;

            //down
            if (isLessEnd(row+step, matrix.length) && matrix[row+step][column] == 0) return step;

            //left
            if (isGreatStart(column-step) && matrix[row][column-step]==0) return step;

            //right
            if (isLessEnd(column+step, matrix[0].length) && matrix[row][column+step] == 0) return step;

            for (int h = step-1; h >= 1; h--) {
                //up
                if (isGreatStart(row-h)) {
                    if (isGreatStart(column - step + h) &&
                        matrix[row - h][column - step + h] == 0) return step;

                    if (isLessEnd(column + step - h, matrix[0].length) &&
                        matrix[row - h][column + step - h] == 0)return step;
                }

                //down
                if (isLessEnd(row+h, matrix.length)) {
                    if (isGreatStart(column - step + h) &&
                        matrix[row + h][column - step + h] == 0) return step;
                    if (isLessEnd(column + step - h, matrix[0].length)
                        && matrix[row + h][column + step - h] == 0) return step;
                }

                //left
                if (isGreatStart(column-h)) {
                    if (isGreatStart(row-step+h) && matrix[row-step+h][column-h] == 0) return step;
                    if (isLessEnd(row+step-h, matrix.length) &&matrix[row+step-h][column-h] == 0) return step;
                }

                //right
                if (isLessEnd(column+h, matrix[0].length)) {
                    if (isGreatStart(row-step+h) &&matrix[row-step+h][column+h] == 0) return step;
                    if (isLessEnd(row+step-h, matrix.length) && matrix[row+step-h][column+h] == 0) return step;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    void updateMatrix(int[][] matrix){
        if (matrix.length == 0) return;
        int[][] upatedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length;j++) {
                if (matrix[i][j] == 0) upatedMatrix[i][j] = 0;
                else upatedMatrix[i][j] = find(matrix, i, j);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------");
        for (int i=0; i < upatedMatrix.length; i++) {
            for (int j = 0; j < upatedMatrix[0].length; j++) {
                System.out.print(upatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] argv){
        Count01Matrix cm = new Count01Matrix();
        int[][] matrix1 = {
                {0, 1, 0},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[][] matrix2 = {
                {0, 0, 0},
                {0, 0, 1},
                {1, 1, 1}
        };
        int[][] matrix3 = {
                {1, 1, 0},
                {1, 1, 1},
                {1, 1, 1}
        };
        cm.updateMatrix(matrix1);
        System.out.println("========");

        cm.updateMatrix(matrix2);
        System.out.println("========");
        cm.updateMatrix(matrix3);
   }
}
