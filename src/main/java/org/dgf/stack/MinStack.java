package org.dgf.stack;

import java.util.Stack;

public class MinStack {
    public Stack<StackRecord> stack = new Stack<>();
    public int currentMin;

    public record StackRecord(int value, int min) {
    }

    public void push(int value) {
        this.currentMin = Math.min(value, currentMin);
        StackRecord record = new StackRecord(value, currentMin);
        this.stack.push(record);
    }

    public int pop() {
        return this.stack.pop().value;
    }

    public int min() {
        return this.stack.peek().min;
    }

    public static void main(String[] argv) {

    }
}
