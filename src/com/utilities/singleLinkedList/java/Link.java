package com.utilities.singleLinkedList.java;


public class Link {

    private int data;
    private Link next;

    public Link(int data) {
        this.data = data;
        next = null;
    }

    public int getData() {
        return data;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}