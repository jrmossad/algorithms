package com.utilities.doublyLinkedList.java;

public class DoublyLinkedList {

    private Link first;
    private Link last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public Link getFirst() {
        return first;
    }

    public Link getLast() {
        return last;
    }

    public void setFirst(Link first) {
        if (first == getFirst()) {
            return;
        }
        if (getFirst() == null) {
            setLast(first);
        } else {
            getFirst().setPrevious(first);
            first.setNext(getFirst());
        }
        first.setPrevious(null);
        this.first = first;
    }

    public void setLast(Link last) {
        if (last == getLast()) {
            return;
        }
        if (getFirst() == null) {
            setFirst(last);
        } else {
            getLast().setNext(last);
            last.setPrevious(getLast());
        }
        last.setNext(null);
        this.last = last;
    }

    public void setInternalLinkFirst(int data) {
        Link first = search(data);
        if (first == null) {
            System.out.println("There is no link with the given data");
            return;
        }
        if (first.getNext() != null && first != getFirst()) {
            first.getPrevious().setNext(first.getNext());
            first.getNext().setPrevious(first.getPrevious());
        }
        setFirst(first);
    }

    public void setInternalLinkLast(int data) {
        Link last = search(data);
        if (last == null) {
            System.out.println("There is no link with the given data");
            return;
        }
        if (last.getNext() != null && last != getLast()) {
            last.getPrevious().setNext(last.getNext());
            last.getNext().setPrevious(last.getPrevious());
        }
        setLast(last);
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

    public void insert(int data) {
        Link newLink = new Link(data);
        setLast(newLink);
    }

    public Link remove(int data) {
        Link removeLink = search(data);
        if (removeLink == null) {
            return null;
        }
        if (removeLink == getFirst()) {
            setFirst(removeLink.getNext());
            if (removeLink.getNext() != null) {
                removeLink.getNext().setPrevious(null);
            }
        }
        if (removeLink == getLast()) {
            setLast(removeLink.getPrevious());
            if (removeLink.getPrevious() != null) {
                removeLink.getPrevious().setNext(null);
            }
        }
        if (removeLink != getFirst() && removeLink != getLast()) {
            removeLink.getPrevious().setNext(removeLink.getNext());
            removeLink.getNext().setPrevious(removeLink.getPrevious());
        }
        return removeLink;
    }
}