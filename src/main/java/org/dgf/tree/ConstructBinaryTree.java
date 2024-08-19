package org.dgf.tree;

public class ConstructBinaryTree {

    public static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int value;

        public TreeNode(TreeNode left, TreeNode right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    public static TreeNode buildTree(int[] input, int left, int right) {
        TreeNode node = null;

        if (left > right )
        {
            return null;
        }

        int mid = (left+right) / 2;
        node = new TreeNode(null, null, input[mid]);
        node.right = buildTree(input, mid+1, right);
        node.left = buildTree(input, left, mid-1);

        return node;
    }

    public static void main(String[] argvs) {
        int[] inputs = {-10,-3,0,5,9};

    }
}
