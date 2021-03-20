package org.dgf.tree;

public class CloserNode {
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        BST cur = tree;
        BST pre = cur;
        int closer = cur.value;
        while (cur != null) {
            pre = cur;
            closer = Math.abs(closer - target) >  Math.abs(cur.value - target) ? cur.value : closer;
            if(cur.value < target){
                cur = cur.right;
            }
            else if (cur.value > target) {
                cur = cur.left;
            }
            else {
                return cur.value;
            }
        }
        return closer;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
