package com.mergeLinkedLists.java;

import com.utilities.singlyLinkedList.java.Link;
import com.utilities.singlyLinkedList.java.SinglyLinkedList;

public class MergeLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList firstLinkedList = new SinglyLinkedList();
        firstLinkedList.insert(2);
        firstLinkedList.insert(6);
        firstLinkedList.insert(7);
        firstLinkedList.insert(8);
        SinglyLinkedList secondLinkedList = new SinglyLinkedList();
        secondLinkedList.insert(1);
        secondLinkedList.insert(3);
        secondLinkedList.insert(4);
        secondLinkedList.insert(5);
        secondLinkedList.insert(9);
        secondLinkedList.insert(10);
        SinglyLinkedList mergedLinkedList = mergeLinkedList(firstLinkedList, secondLinkedList);
        Link current = mergedLinkedList.getFirst();
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }

    // O(n + m) time | O(1) space
    public static SinglyLinkedList mergeLinkedList(SinglyLinkedList firstLinkedList, SinglyLinkedList secondLinkedList) {
        Link first = firstLinkedList.getFirst();
        Link second = secondLinkedList.getFirst();
        SinglyLinkedList output = null;
        Link firstNext;
        Link secondNext;
        Link previous = null;
        while (first != null && second != null) {
            if (first.getData() < second.getData()) {
                if (previous != null) {
                    previous.setNext(first);
                } else {
                    output = firstLinkedList;
                }
                firstNext = first.getNext();
                first.setNext(second);
                previous = first;
                first = firstNext;
            } else {
                if (previous != null) {
                    previous.setNext(second);
                } else {
                    output = secondLinkedList;
                }
                secondNext = second.getNext();
                second.setNext(first);
                previous = second;
                second = secondNext;
            }
        }
        return output;
    }
}