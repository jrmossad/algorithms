package com.utilities.queue.java;

public class StaticQueueWithoutCount {

    private int[] queue;
    private int front;
    private int rear;

    public StaticQueueWithoutCount(int max) {
        queue = new int[max + 1];
        front = 0;
        rear = -1;
    }

    public void insert(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (rear == queue.length - 1) {
            rear = -1;
        }
        queue[++rear] = item;
    }

    public int remove() {
        if (isEmpty()) {
            return -1;
        }
        int item = queue[front++];
        if (front == queue.length) {
            front = 0;
        }
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return rear >= front ? (rear - front + 1) : ((queue.length - front) + (rear + 1));
    }

    public boolean isEmpty() {
        return ((rear + 1 == front) || (front + queue.length - 1 == rear));
    }

    public boolean isFull() {
        return ((rear + 2 == front) || (front + queue.length - 2 == rear));
    }
}