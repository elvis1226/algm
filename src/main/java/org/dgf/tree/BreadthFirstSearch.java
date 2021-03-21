package org.dgf.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            // Write your code here.
            Queue<Node> nodes = new LinkedList<>();
            nodes.add(this);

            while (nodes.size() > 0) {
                Node cur = nodes.poll();

                if(cur != null){
                    array.add(cur.name);
                    if (cur.children.size() > 0) {
                        nodes.addAll(cur.children);
                    }
                }

            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
