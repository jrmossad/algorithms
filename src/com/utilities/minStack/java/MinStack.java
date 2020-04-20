package com.utilities.minStack.java;

import com.utilities.maxStack.java.MaxStack;

import java.util.ArrayList;

public class MinStack<T extends Comparable> {

    private ArrayList<T> stack;

    public MinStack() {
        stack = new ArrayList<>();
    }

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

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public T peak() {
        if (isEmpty()) {
            return null;
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}