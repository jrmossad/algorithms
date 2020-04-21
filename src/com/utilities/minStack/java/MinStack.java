package com.utilities.minStack.java;

import com.utilities.maxStack.java.MaxStack;

import java.util.ArrayList;

public class MinStack<T extends Comparable> {

    private ArrayList<T> stack;

    public MinStack() {
        stack = new ArrayList<>();
    }

    // O(n) time | O(n) space
    public void push(T item) {
        MaxStack<T> helper = new MaxStack<>();
        while (!isEmpty() && peak().compareTo(item) < 0) {
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