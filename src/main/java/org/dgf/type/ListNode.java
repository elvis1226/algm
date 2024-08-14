package org.dgf.type;

public  class ListNode<T> {
    public ListNode next;
    public T value;

    public ListNode(T value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
