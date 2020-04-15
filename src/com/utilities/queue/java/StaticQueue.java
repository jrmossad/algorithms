package com.utilities.queue.java;

public class StaticQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int numberOfElements;

    public StaticQueue(int max) {
        queue = new int[max];
        front = 0;
        rear = -1;
        numberOfElements = 0;
    }

    public void insert(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        queue[++rear] = item;
        if (rear == queue.length) {
            rear = -1;
        }
        numberOfElements++;
    }

    public int remove() {
        if (isEmpty()) {
            return -1;
        }
        int item = queue[front++];
        if (front == queue.length) {
            front = 0;
        }
        numberOfElements--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean isFull() {
        return numberOfElements == queue.length;
    }
}