package org.dgf.tree;

import java.util.Stack;

/**
 * Created by apple on 18/3/24.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int v) {
        this.val = v;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode newNode = t1 != null  ? new TreeNode(t1.val) : null;

        newNode = newNode == null ?
                ( t2 == null ? null : new TreeNode(t2.val) ) :
                ( t2 == null ? newNode : new TreeNode(t2.val + newNode.val) );

        if (newNode != null) {
            newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
            newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        }
        return newNode;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = root.left != null ? maxDepth(root.left) : 0;
        int right = root.right != null ? maxDepth(root.right) : 0;

        return Math.max(right, left) + 1;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public TreeNode calcValue(TreeNode root,int[] sum) {
        if (root == null) return null;
        calcValue(root.right, sum);
        int tmp = root.val;
        root.val += sum[0];
        sum[0] += tmp;
        calcValue(root.left, sum);
        return root;
    }

    public TreeNode calcValue2(TreeNode root,int[] sum) {

        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();

        stk.push(cur);
        while (cur != null && !stk.isEmpty()) {

            if (cur.right != null) {
                stk.push(cur.right);
                cur = cur.right;
            }
            else {
                    TreeNode p = stk.pop();
                    int tmp = p.val;
                    p.val += sum[0];
                    sum[0] += tmp;
                    if (p.left != null) {
                        cur = p.left;
                        stk.push(cur);
                    }
            }

        }
        return root;
    }

    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        int[] sum = {0};
        calcValue(root, sum);
        return root;

    }
}
