package org.dgf.array;


import java.util.*;

// Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

// For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

// 1   2   4
//  \ /   / \
//   3   5   8
//    \ / \   \
//     6   7   10

// Write a function that, for two given individuals in our dataset, returns true if and only if they share at least one ancestor.

// Sample input and output:
// hasCommonAncestor(parentChildPairs, 3, 8) => false
// hasCommonAncestor(parentChildPairs, 5, 8) => true
// hasCommonAncestor(parentChildPairs, 6, 8) => true
// hasCommonAncestor(parentChildPairs, 1, 3) => false


public class ParentChildArray {


    public static boolean hasCommonAncestor(int[][] parentChildPairs, int node1, int node2){

        Map<Integer, List<Integer>> nodeParents = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < parentChildPairs.length; i++){
            if (nodeParents.containsKey(parentChildPairs[i][1])){
                List<Integer> l = nodeParents.get(parentChildPairs[i][1]);
                l.add(parentChildPairs[i][0]);
                nodeParents.put(node1, l);
            }
            else {
                List<Integer> l = new ArrayList<Integer>();
                l.add(parentChildPairs[i][0]);
                nodeParents.put(node1, l);
            }
        }
        return false;

    }

    public static List<List<Integer>> findNodesWithZeroAndOneParents(int[][] parentChildPairs)
    {
        List<List<Integer>> result = new ArrayList<>();
        //O(parentChildPairs.length)
        Map<Integer,Integer> nodeCnt = new HashMap<Integer,Integer>();

        if (parentChildPairs.length == 0) return result;
        //O(parentChildPairs.length * 2)
        for (int i = 0; i < parentChildPairs.length; i++){
            for (int j = 0 ; j < parentChildPairs[i].length; j++){
                nodeCnt.put(parentChildPairs[i][j], 0);
            }
        }
        for (int i = 0; i < parentChildPairs.length; i++){
            if (nodeCnt.containsKey(parentChildPairs[i][1])){
                int cnt = nodeCnt.get(parentChildPairs[i][1])+1;
                nodeCnt.put(parentChildPairs[i][1], cnt);
            }
        }

        List<Integer> a0 = new ArrayList<Integer>();
        List<Integer> a1 = new ArrayList<Integer>();
        for (Integer key : nodeCnt.keySet()){
            int v = nodeCnt.get(key);
            if (v == 0){
                a0.add(key);
            }
            if (v ==1) {
                a1.add(key);
            }
        }

        result.add(a0);
        result.add(a1);
        return result;

    }

    public static void main(String[] args) {
        int[][] parentChildPairs = new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {8, 10}
        };

        List<List<Integer>> result = findNodesWithZeroAndOneParents(parentChildPairs);

        for (List<Integer> l : result){

            for (Integer i : l){
                System.out.print(i + " ");
            }

            System.out.println("-------");
        }
    }
}


