package org.dgf.graph;

import java.util.ArrayList;
import java.util.List;

public class YoungestCommonAncestor {
    public static List<AncestralTree> findParents(AncestralTree node) {
        List<AncestralTree> result = new ArrayList<>();
        result.add(node);
        while (node.ancestor != null) {
            result.add(node.ancestor);
            node = node.ancestor;
        }
        return result;
    }

    public static int depth(AncestralTree node) {
        int result = 0;
        while (node.ancestor != null) {
            result++;
            node = node.ancestor;
        }
        return result;
    }

    public static AncestralTree adjust(AncestralTree node, int degree) {
        while (degree != 0) {
            degree--;
            node = node.ancestor;
        }
        return node;
    }

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        AncestralTree oneTree = descendantOne, twoTree = descendantTwo;

        int oneDepth = depth(oneTree);
        int twoDepth = depth(twoTree);
        if (oneDepth > twoDepth) {
            oneTree = adjust(oneTree, oneDepth-twoDepth);
        }
        else if (oneDepth < twoDepth) {
            twoTree = adjust(twoTree, twoDepth-oneDepth);
        }

        if (oneTree == twoTree) {
            return oneTree;
        }
        while (oneTree.ancestor != null && twoTree.ancestor != null) {
            if (oneTree.ancestor == twoTree.ancestor) {
                return twoTree.ancestor;
            }
            oneTree = oneTree.ancestor;
            twoTree = twoTree.ancestor;
        }

        return topAncestor;
    }
    public static AncestralTree getYoungestCommonAncestor2(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.
        if (topAncestor == null || descendantOne == null || descendantTwo == null) {
            return null;
        }
        AncestralTree oneTree = descendantOne, twoTree = descendantTwo;

        List<AncestralTree> oneParents = findParents(oneTree);
        List<AncestralTree> twoParents = findParents(twoTree);
        for (AncestralTree oneNode : oneParents) {
            for (AncestralTree twoNode : twoParents) {
                if (oneNode == twoNode) {
                    return oneNode;
                }
            }
        }
        return topAncestor; // Replace this line
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
