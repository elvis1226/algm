package org.dgf.graph;

import java.util.ArrayList;
import java.util.List;

public class RobotPath {

    public static List<int[]> findPath(int[][] matrix) {
        List<int[]> res = new ArrayList<>();

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[] target = new int[]{rows-1, columns-1};
        dfs(0, 0, matrix, target, res);
        return res;
    }
    public static boolean dfs (int start, int end, int[][] matrix, int[] target, List<int[]> path){
        if (start >= target[0] || end >= target[1] || matrix[start][end]== 1){
            return false;
        }

        if (start == target[0] && end == target[1]){
            return true;
        }
        path.add(new int[] {start, end});

        if (dfs(start, end+1, matrix, target, path) ||
            dfs(start+1, end, matrix, target, path))
        {
            return true;
        };
        path.removeLast();
        return false;
    }
}
