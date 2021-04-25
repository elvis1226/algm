package org.dgf.graph;

import java.util.Stack;

public class RemoveIsland
{
    public void iterate(int[][] matrix, int i, int j) {
        Stack<int[]> stack = new Stack<>();
        int rows = matrix.length, columns = matrix[0].length;
        stack.push(new int[] {i, j});

        while (stack.size() > 0) {
            int[] node = stack.pop();
            int x = node[0], y = node[1];
            if(matrix[x][y] != 1) {
                continue;
            }
            matrix[x][y] = 2;
            //up
            if(x-1 >= 0) {
                stack.push(new int[]{x-1, y});
            }
            //down
            if(x+1 < rows) {
                stack.push(new int[]{x+1, y});
            }
            //left
            if(y-1 >= 0) {
                stack.push(new int[]{x, y-1});
            }
            //right
            if(y+1 < columns) {
                stack.push(new int[]{x, y+1});
            }
        }
    }

        public int[][] removeIslands(int[][] matrix) {
            //Island is connected on (0,x),(n,x), (x,0),(x,n) are not removed
            int rows = matrix.length, columns = matrix[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0 ; j < columns; j++) {
                    boolean isBorder = i == 0 || j == 0 || i == (rows-1) || j == (columns-1) ;
                    if(!isBorder) {
                        continue;
                    }
                    if (matrix[i][j] != 1){
                        continue;
                    }
                    iterate(matrix, i, j);
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0 ; j < columns; j++) {
                    if(matrix[i][j] == 1) {
                        matrix[i][j] = 0;
                    }
                    else if(matrix[i][j] == 2) {
                        matrix[i][j] = 1;
                    }
                }
            }

            return matrix;
        }
}
