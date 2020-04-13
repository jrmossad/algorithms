package com.utilities.java;

public class Node {

    private int data;
    private Node leftChild;
    private Node rightChild;
    private Node parent;

    public Node(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }

    public int getData() {
        return data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}