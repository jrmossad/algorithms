package com.utilities.singleLinkedList.java;

public class SinglelyLinkedList {

    private Link first;

    public SinglelyLinkedList() {
        first = null;
    }

    public Link getFirst() {
        return first;
    }

    private void setFirst(Link newLink) {
        first = newLink;
    }

    public void insert(int data) {
        Link newLink = new Link(data);
        if (first == null) {
            setFirst(newLink);
            return;
        }
        Link previous = null;
        Link current = first;
        while (current != null) {
            previous = current;
            current = current.getNext();
        }
        previous.setNext(newLink);
    }

    public void insertFirst(int data) {
        Link newLink = new Link(data);
        newLink.setNext(getFirst());
        setFirst(newLink);
    }

    public Link search(int data) {
        Link current = getFirst();
        while (current != null) {
            if (current.getData() == data) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public Link remove(int data) {
        Link current = getFirst();
        Link previous = null;
        while (current != null) {
            if (current.getData() == data) {
                if (current != getFirst()) {
                    previous.setNext(current.getNext());
                } else {
                    setFirst(current.getNext());
                }
                return current;
            }
            previous = current;
            current = current.getNext();
        }
        return null;
    }

    public Link removeFirst() {
        Link link = getFirst();
        setFirst(link.getNext());
        return link;
    }

    public static void main(String[] args) {
        SinglelyLinkedList singlelyLinkedList = new SinglelyLinkedList();
        singlelyLinkedList.insert(5);
        singlelyLinkedList.insert(6);
        singlelyLinkedList.insert(7);
        singlelyLinkedList.remove(5);
        singlelyLinkedList.insert(5);
        singlelyLinkedList.remove(7);
        Link current = singlelyLinkedList.getFirst();
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }
}