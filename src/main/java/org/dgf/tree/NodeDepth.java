package org.dgf.tree;

import java.util.ArrayList;
import java.util.List;

public class NodeDepth {
    public static int iterate(int predepth, BinaryTree root) {
        if (root == null) return 0;
        int sl = predepth + iterate(predepth+1, root.left);
        int sr = sl + iterate(predepth+1, root.right);
        return sr;
    }

    public static int nodeDepths1(BinaryTree root) {
        // Write your code here.
        int sumLeft = iterate(1, root.left);
        int sumRight = iterate(1, root.right);

        return sumLeft+sumRight;
    }

    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(root,0));

        int sum = 0;
        Node node = null;
        while (nodes.size() > 0 && (node = nodes.get(nodes.size()-1)) != null) {
            sum += node.depth;
            nodes.remove(nodes.size()-1);

            BinaryTree tree = node.tree;
            if (tree.right != null) {
                nodes.add( new Node(tree.right, node.depth+1) );
            }
            if (tree.left != null) {
                nodes.add( new Node(tree.left, node.depth+1) );
            }
        }

        return sum;
    }

    static class Node{
        public BinaryTree tree;
        public int depth;
        public Node (BinaryTree tree, int depth) {
            this.tree = tree;
            this.depth = depth;
        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
