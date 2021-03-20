package org.dgf.tree;

import java.util.ArrayList;
import java.util.List;

public class BranchSum {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void iterate(int aggregation, BinaryTree root, List<Integer> result ) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            result.add(aggregation+root.value);
            return ;
        }

        iterate(aggregation+root.value, root.left, result);
        iterate(aggregation+root.value, root.right, result);

    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            result.add(root.value);
            return result;
        }

        iterate(root.value, root.left, result);

        iterate(root.value, root.right, result);

        return  result;
    }
}
