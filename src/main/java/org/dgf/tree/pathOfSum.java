package org.dgf.tree;

import java.util.List;

public class pathOfSum {

    public static int sum(TreeNode head, int total) {
        int res = 0;
        if (total < 0 || head == null) {
            return 0;
        }
        if (total == 0) {
            return 1;
        }

        int remaining = total - head.val;
        if (remaining == 0) {
            return 1;
        }
        res += sum(head.left, remaining);
        res += sum(head.right, remaining);

        return res;
    }
}
