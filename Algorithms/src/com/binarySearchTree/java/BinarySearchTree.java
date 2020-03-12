package com.binarySearchTree.java;

import com.utilities.java.*;

public class BinarySearchTree {

    private Node root;

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (current.getData() > data) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(new Node(data));
                        return;
                    }
                } else if (current.getData() <= data) {
                    current = current.getRightChild();

                    if (current == null) {
                        parent.setRightChild(new Node(data));
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int data) {
        Node current = root;
        Node substitute = null;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.getData() != data) {
            parent = current;
            if (current.getData() > data) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if (current == null) {
                return false;
            }
        }
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            substitute = null;
        } else if (current.getRightChild() == null) {
            substitute = current.getLeftChild();
        } else if (current.getLeftChild() == null) {
            substitute = current.getRightChild();
        } else {
            substitute = getSuccessor(current);
            substitute.setLeftChild(current.getLeftChild());
        }
        if (current == root) {
            root = substitute;
        } else if (isLeftChild) {
            parent.setLeftChild(substitute);
        } else {
            parent.setRightChild(substitute);
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.getRightChild();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != delNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(delNode.getRightChild());
        }
        return successor;
    }

    public Node minimum() {
        Node current = root;
        Node last = root;
        while (current != null) {
            last = current;
            current = current.getLeftChild();
        }
        return last;
    }

    public Node maximum() {
        Node current = root;
        Node last = root;
        while (current != null) {
            last = current;
            current = current.getRightChild();
        }
        return last;
    }

    public boolean search(int data) {
        return searchHelper(data, root);
    }

    private boolean searchHelper(int data, Node current) {
        if (current == null) {
            return false;
        }
        if (current.getData() == data) {
            return true;
        }
        if (current.getData() > data) {
            return searchHelper(data, current.getLeftChild());
        }
        return searchHelper(data, current.getRightChild());
    }

    public int findClosestValueBSTRecursive(int data) {
        return findClosestValueBSTRecursiveHelper(data, root, root.getData());
    }

    private int findClosestValueBSTRecursiveHelper(int data, Node current, int closest) {
        if (current == null) {
            return closest;
        }
        if (Math.abs((current.getData() - data)) < Math.abs((closest - data))) {
            closest = current.getData();
        }
        if (data < current.getData()) {
            return findClosestValueBSTRecursiveHelper(data, current.getLeftChild(), closest);
        } else if (data > current.getData()) {
            return findClosestValueBSTRecursiveHelper(data, current.getRightChild(), closest);
        } else {
            return closest;
        }
    }

    public int findClosestValueBSTIterative(int data) {
        return findClosestValueBSTIterativeHelper(data, root, root.getData());
    }

    private int findClosestValueBSTIterativeHelper(int data, Node root, int closest) {
        Node current = root;
        while (current != null) {
            if (Math.abs((current.getData() - data)) < Math.abs((closest - data))) {
                closest = current.getData();
            }
            if (data < current.getData()) {
                current = current.getLeftChild();
            } else if (data > current.getData()) {
                current = current.getRightChild();
            } else {
                break;
            }
        }
        return closest;
    }
}