package com.utilities.queue.java;

public class StaticQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int count;

    public StaticQueue(int max) {
        queue = new int[max];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void insert(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (rear == queue.length) {
            rear = -1;
        }
        queue[++rear] = item;
        count++;
    }

    public int remove() {
        if (isEmpty()) {
            return -1;
        }
        int item = queue[front++];
        if (front == queue.length) {
            front = 0;
        }
        count--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == queue.length;
    }
}