package org.dgf.tree;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            // Write your code here.
            List<Node> nodes = new ArrayList<>();

            nodes.add(this);
            Node node = null;
            while (nodes.size() > 0 && (node=nodes.get(nodes.size()-1)) != null) {
                array.add(node.name);

                nodes.remove(nodes.size()-1);

                for (int i = node.children.size()-1; i >= 0; i--) {
                    nodes.add(node.children.get(i));
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
