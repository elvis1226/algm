package org.dgf.graph;

import java.util.HashSet;
import java.util.Set;

public class CheckCycle {
    public boolean checkCycle(Set<Integer> scan, int[][] edges, int cur, boolean[] visited){
        visited[cur] = true;
        for (int next = 0; next < edges[cur].length; next++) {
            if (scan.contains(edges[cur][next])) {
                return true;
            }

            scan.add(edges[cur][next]);
            if (!visited[edges[cur][next]] && checkCycle(scan, edges, edges[cur][next], visited)) {
                return true;
            }

            scan.remove(edges[cur][next]);
        }

        return false;
    }

    public boolean cycleInGraph(int[][] edges) {
        // Write your code here.
        //0()
        boolean[] visited = new boolean[edges.length];

        for (int cur = 0 ; cur < edges.length; cur++) {
            if (visited[cur]) {
                continue;
            }
            Set<Integer> scan = new HashSet<>();
            scan.add(cur);
            if(checkCycle(scan, edges, cur, visited)) {
                return true;
            }
        }
        return false;
    }
}
