package com.heap.java;

import com.utilities.java.Node;

import java.util.*;

public class MaxHeap {

    public Node root;
    //Till I implement my own linked list and queue
    private Queue<Node> nodesQueue;

//    public MaxHeap(int[] arr) {
//        nodesQueue = new LinkedList<>();
//        root = null;
//        initialize(arr);
//    }

//    public void initialize(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(i);
//            Node current = new Node(arr[i]);
//            nodesQueue.add(current);
//            if (root == null) {
//                root = current;
//            } else if (nodesQueue.peek().leftChild == null) {
//                System.out.println("hi");
//                if (nodesQueue.peek().data > current.data) {
//                    current.parent = nodesQueue.peek();
//                    nodesQueue.peek().leftChild = current;
//                } else {
//                    Node previous = nodesQueue.peek();
//                    while (previous != null && previous.data < current.data) {
//                        current.leftChild = previous;
//                        Node swap = current.rightChild;
//                        current.rightChild = previous.rightChild;
//                        previous.rightChild = swap;
//                        if (previous.parent != null) {
//                            previous.parent.leftChild = current;
//                            previous.parent = previous.parent.leftChild;
//                        } else {
//                            root = current;
//                        }
//                        previous = previous.parent;
//
//                    }
//                    Queue<Node> nodes = new LinkedList<>();
////                    Node x = ;
//
//                    nodes.add(nodesQueue.remove());
//
//                    System.out.println(root.data);
//                    nodesQueue = nodes;
//                }
//            } else if (nodesQueue.peek().rightChild == null) {
//                if (nodesQueue.peek().data > current.data) {
//                    current.parent = nodesQueue.peek();
//                    nodesQueue.peek().rightChild = current;
//
//                } else {
//                    Node previous = nodesQueue.peek();
//                    while (previous.data < current.data) {
//                        current.rightChild = previous;
//                        Node swap = current.leftChild;
//
//                        current.leftChild = previous.leftChild;
//                        previous.leftChild = swap;
//                        if (previous.parent != null) {
//                            previous.parent.rightChild = current;
//                        } else {
//                            root = current;
//                        }
//                        previous.parent = previous.parent.rightChild;
//                        previous = previous.parent;
//                    }
//                    Queue<Node> nodes = new LinkedList<>();
//                    this.printLeafNodes(this.root);
//                }
//                nodesQueue.remove();
//            }
//        }
//    }
//
//    public void printLeafNodes(Node current) {
//        if (current == null) {
//            System.out.println();
//            return;
//        }
//        if (current.leftChild == null && current.rightChild == null) {
//            System.out.printf("%d ", current.data);
//        }
//        printLeafNodes(current.leftChild);
//        printLeafNodes(current.rightChild);
//    }
//
//    public static void main(String[] args) {
//        int[] x = new int[]{1, 12, 13, 10, 11, 9, 8};
//        MaxHeap arr = new MaxHeap(x);
//        System.out.println(arr.root.data);
//        System.out.println(arr.root.leftChild.data);
//        System.out.println(arr.root.rightChild.data);
//        System.out.println(arr.root.leftChild.leftChild.data);
//        System.out.println(arr.root.leftChild.rightChild.data);
//        System.out.println(arr.root.rightChild.leftChild.data);
//        System.out.println(arr.root.rightChild.rightChild.data);
//
//    }

}
