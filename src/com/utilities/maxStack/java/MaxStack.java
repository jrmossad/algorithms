package com.utilities.maxStack.java;

import com.utilities.minStack.java.MinStack;

import java.util.ArrayList;

public class MaxStack<T extends Comparable> {

    private ArrayList<T> stack;

    public MaxStack() {
        stack = new ArrayList<>();
    }

    // O(n) time | O(n) space
    public void push(T item) {
        MinStack<T> helper = new MinStack<>();
        while (!isEmpty() && peak().compareTo(item) >= 0) {
            helper.push(pop());
        }
        stack.add(item);
        while (!helper.isEmpty()) {
            push(helper.pop());
        }
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