package com.utilities.stack.java;

import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    // O(1) time | O(1) space
    public void push(T item) {
        stack.add(item);
    }

    // O(1) time | O(1) space
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    // O(1) time | O(1) space
    public T peak() {
        if (isEmpty()) {
            return null;
        }
        return stack.get(stack.size() - 1);
    }

    // O(1) time | O(1) space
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}