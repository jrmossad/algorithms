package com.utilities.singlyLinkedList.java;

public class SinglyLinkedList {

    private Link first;

    public SinglyLinkedList() {
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
    public Link removeNthElementFromEnd(int position) {
        Link slowPointer = getFirst();
        Link fastPointer = getFirst();
        Link previous = null;
        int i = 0;
        while (fastPointer != null && i < position) {
            fastPointer = fastPointer.getNext();
            i++;
        }
        if (i != position && fastPointer == null) {
            return null;
        }
        while (fastPointer != null) {
            previous = slowPointer;
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext();
        }
        if (slowPointer == getFirst()) {
            setFirst(slowPointer.getNext());
        } else {
            previous.setNext(slowPointer.getNext());
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insert(5);
        singlyLinkedList.insert(6);
        singlyLinkedList.insert(7);
        singlyLinkedList.insert(8);
        singlyLinkedList.insert(9);
        Link element = singlyLinkedList.removeNthElementFromEnd(3);
        System.out.println(element.getData());
        Link current = singlyLinkedList.getFirst();
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }
}