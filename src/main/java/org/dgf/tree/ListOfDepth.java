package org.dgf.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
* Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D,
*  you'll have D linked lists). Return a array containing all the linked lists.

Example:
Input: [1,2,3,4,5,null,7,8]
        1

       /  \

      2    3

     / \    \

    4   5    7

   /

  8
  Output: [[1],[2,3],[4,5,7],[8]]
* */
public class ListOfDepth {

    public static List<List<Integer>> getDepth(TreeNode head) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size() ;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

}
