package com.utilities.queue.java;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> {

    List<T> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    public void inset(T item) {
        queue.add(item);
    }

    public T remove() {
        if (isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return queue.get(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}