package org.dgf.list;

import org.dgf.type.ListNode;

public class KthNode {
    public static ListNode findKthNode(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] argvs)
    {
        ListNode head = null, pre = null;
        for (int i = 1 ; i < 6 ; i++) {
            ListNode<Integer> cur = new ListNode<>(Integer.valueOf(i), null);
            if (head == null) {
                head = cur;
                pre = cur;
                continue;
            }
            pre.next = cur;
            pre = cur;
        }

        ListNode next = head;
        while (next != null) {
            System.out.print(next.value + " ");
            next = next.next;
        }
        System.out.println();
        ListNode found = findKthNode(head, 3);
        System.out.println("find " + found.value);
    }
}
