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

    // O(n) time | O(1) space
    public Link findLoop() {
        Link slowPointer = getFirst().getNext();
        Link fastPointer = null;
        if (getFirst().getNext() != null) {
            fastPointer = getFirst().getNext().getNext();
        }
        while (slowPointer != null && fastPointer != null && slowPointer != fastPointer) {
            slowPointer = slowPointer.getNext();
            if (fastPointer.getNext() != null) {
                fastPointer = fastPointer.getNext().getNext();
            }
        }
        if (slowPointer == null || fastPointer == null) {
            return null;
        }
        slowPointer = getFirst();
        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext();
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Link link1 = new Link(0);
        Link link2 = new Link(1);
        Link link3 = new Link(2);
        Link link4 = new Link(3);
        Link link5 = new Link(4);
        Link link6 = new Link(5);
        Link link7 = new Link(6);
        Link link8 = new Link(7);
        Link link9 = new Link(8);
        Link link10 = new Link(9);
        link1.setNext(link2);
        link2.setNext(link3);
        link3.setNext(link4);
        link4.setNext(link5);
        link5.setNext(link6);
        link6.setNext(link7);
        link7.setNext(link8);
        link8.setNext(link9);
        link9.setNext(link10);
        singlyLinkedList.setFirst(link1);
        Link element = singlyLinkedList.findLoop();
        System.out.println(element);
    }
}