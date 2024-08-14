package org.dgf.list;

import org.dgf.type.ListNode;

public class PartitionList {

    public static ListNode<Integer> partition(ListNode<Integer> head, int p) {
        ListNode left = null, firstLeft = null;
        ListNode right = null, firstRight = null;

        while(head != null) {
            if (head.value < p) {
                if (left == null) {
                    left = head;
                    firstLeft = head;
                }
                else {
                    left.next = head;
                    left = head;
                }
            }
            else {
                if (right == null) {
                    right = head;
                    firstRight = head;
                }
                else {
                    right.next = head;
                    right = head;
                }
            }
            head = head.next;
        }

        left.next = firstRight;
        right.next = null;
        return firstLeft;
    }

    public static void main(String[] argvs)
    {
        ListNode head = null, pre = null;
        for (int i = 1 ; i < 6 ; i++) {
            ListNode<Integer> cur = new ListNode<>(Integer.valueOf(6-i), null);
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

        head = partition(head, 3);
        next = head;
        while (next != null) {
            System.out.print(next.value + " ");
            next = next.next;
        }
        System.out.println();
    }
}
