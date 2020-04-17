package com.utilities.singleLinkedList.java;

public class SinglelyLinkedList {

    private Link first;

    public SinglelyLinkedList() {
        first = null;
    }

    // O(1) time | O(1) space
    public Link getFirst() {
        return first;
    }

    // O(1) time | O(1) space
    private void setFirst(Link newLink) {
        first = newLink;
    }

    // O(n) time | O(1) space
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

    // O(1) time | O(1) space
    public void insertFirst(int data) {
        Link newLink = new Link(data);
        newLink.setNext(getFirst());
        setFirst(newLink);
    }

    // O(n) time | O(1) space
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

    // O(n) time | O(1) space
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

    // O(1) time | O(1) space
    public Link removeFirst() {
        Link link = getFirst();
        setFirst(link.getNext());
        return link;
    }

    // O(n) time | O(1) space
    public void reverse() {
        Link current = getFirst();
        Link previous = null;
        Link next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        setFirst(previous);
    }

    // O(n) time | O(1) space
    public Link getElementFromEnd(int position) {
        Link slowPointer = getFirst();
        Link fastPointer = getFirst();
        int i = 0;
        while (fastPointer != null & i < position) {
            fastPointer = fastPointer.getNext();
            i++;
        }
        if (fastPointer == null) {
            return null;
        }
        while (fastPointer != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext();
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        SinglelyLinkedList singlelyLinkedList = new SinglelyLinkedList();
        singlelyLinkedList.insert(5);
        singlelyLinkedList.insert(6);
        singlelyLinkedList.insert(7);
        singlelyLinkedList.insert(8);
        singlelyLinkedList.insert(9);
        Link element = singlelyLinkedList.getElementFromEnd(3);
        System.out.println(element.getData());
        Link current = singlelyLinkedList.getFirst();
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }
}