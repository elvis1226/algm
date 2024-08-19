package org.dgf.graph;

import java.util.*;

public class GraphSearch {

    // input n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
    // output: true


    public static boolean findTarget(int n, int[][] graph, int start, int target) {
        List<Integer>[] nodes = new ArrayList[n];
        Arrays.setAll(nodes, k-> new ArrayList<>());

        for (int[] row : graph) {
            nodes[row[0]].add(row[1]);
        }
        Set<Integer> visited = new HashSet<>();
        return GFS(visited, nodes, start, target);
    }

    public static boolean GFS(Set<Integer> visited, List<Integer>[] nodes , int start, int target) {
        if(start == target) {
            return true;
        }

        visited.add(start);
        for (int next : nodes[start]) {
            if (visited.contains(next)) {
                continue;
            }

            if (GFS(visited, nodes, next, target)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] argv)
    {
        int[][] graph1 = {{0, 1}, {0, 2}, {1, 2}, {1, 2}};
        int[][] graph2 = {{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}};
        boolean res1 = findTarget(3, graph1, 0, 2);
        boolean res2 = findTarget(5, graph2, 0, 4);
        System.out.println("res1 : " + res1);
        System.out.println("res2 : " + res2);
    }

}
