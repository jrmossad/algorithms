package com.utilities.binaryTree.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Node root;
    private Queue<Node> nodesQueue;

    public BinaryTree() {
        nodesQueue = new LinkedList<>();
        root = null;
    }

    private void setRoot(Node node) {
        root = node;
    }

    public Node getRoot() {
        return root;
    }

    public void levelInsert(int data) {
        Node newNode = new Node(data);
        newNode.setParent(nodesQueue.isEmpty() ? null : nodesQueue.peek());
        nodesQueue.add(newNode);
        if (getRoot() == null) {
            setRoot(newNode);
        } else if (nodesQueue.peek().getLeftChild() == null) {
            nodesQueue.peek().setLeftChild(newNode);
        } else {
            nodesQueue.remove().setRightChild(newNode);
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (getRoot() == null) {
            setRoot(newNode);
        } else {
            Node current = getRoot();
            Node parent;
            while (true) {
                parent = current;
                if (current.getData() > data) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(newNode);
                        newNode.setParent(parent);
                        return;
                    }
                } else if (current.getData() <= data) {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(newNode);
                        newNode.setParent(parent);
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int data) {
        Node current = getRoot();
        Node parent = null;
        Node substitute = null;
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
            current.getLeftChild().setParent(substitute);
        }
        if (current == getRoot()) {
            setRoot(substitute);
        } else if (isLeftChild) {
            parent.setLeftChild(substitute);
        } else {
            parent.setRightChild(substitute);
        }
        substitute.setParent(parent);
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
            if (successor.getRightChild() != null) {
                successor.getRightChild().setParent(successorParent);
            }
            successor.setRightChild(delNode.getRightChild());
            delNode.getRightChild().setParent(successor);
        }
        return successor;
    }

    public Node minimum() {
        Node current = getRoot();
        Node last = getRoot();
        while (current != null) {
            last = current;
            current = current.getLeftChild();
        }
        return last;
    }

    public Node maximum() {
        Node current = getRoot();
        Node last = getRoot();
        while (current != null) {
            last = current;
            current = current.getRightChild();
        }
        return last;
    }

    public boolean search(int data) {
        return searchHelper(data, getRoot());
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

    // O(log(n)) time | O(log(n)) space if tree is balanced
    // O(n) time | O(n) space if tree in unbalanced
    public int findClosestValueBSTRecursively(int data) {
        return findClosestValueBSTRecursivelyHelper(data, getRoot(), Integer.MAX_VALUE);
    }

    private int findClosestValueBSTRecursivelyHelper(int data, Node current, int closest) {
        if (current == null) {
            return closest;
        }
        if (Math.abs((current.getData() - data)) < Math.abs((closest - data))) {
            closest = current.getData();
        }
        if (data < current.getData()) {
            return findClosestValueBSTRecursivelyHelper(data, current.getLeftChild(), closest);
        } else if (data > current.getData()) {
            return findClosestValueBSTRecursivelyHelper(data, current.getRightChild(), closest);
        } else {
            return closest;
        }
    }

    // O(log(n)) time | O(1) space if tree is balanced
    // O(n) time | O(1) space if tree is unbalanced
    public int findClosestValueBSTIteratively(int data) {
        Node current = getRoot();
        int closest = Integer.MAX_VALUE;
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

    public ArrayList<Integer> branchSum() {
        ArrayList<Integer> sums = new ArrayList<>();
        branchSumHelper(getRoot(), 0, sums);
        return sums;
    }

    private void branchSumHelper(Node current, int currentSum, ArrayList<Integer> sums) {
        if (current == null) {
            return;
        }
        currentSum += current.getData();
        if (current.getRightChild() == null && current.getLeftChild() == null) {
            sums.add(currentSum);
            return;
        }
        branchSumHelper(current.getLeftChild(), currentSum, sums);
        branchSumHelper(current.getRightChild(), currentSum, sums);
    }

    public void inOrderTraversal() {
        inOrderTraversalHelper(getRoot());
        System.out.println();
    }

    private void inOrderTraversalHelper(Node current) {
        if (current == null) {
            return;
        }
        inOrderTraversalHelper(current.getLeftChild());
        System.out.print(current.getData() + " ");
        inOrderTraversalHelper(current.getRightChild());
    }

    public void preOrderTraversal() {
        preOrderTraversalHelper(getRoot());
        System.out.println();
    }

    private void preOrderTraversalHelper(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.getData() + " ");
        preOrderTraversalHelper(current.getLeftChild());
        preOrderTraversalHelper(current.getRightChild());
    }

    public void postOrderTraversal() {
        postOrderTraversalHelper(getRoot());
        System.out.println();
    }

    private void postOrderTraversalHelper(Node current) {
        if (current == null) {
            return;
        }
        postOrderTraversalHelper(current.getLeftChild());
        postOrderTraversalHelper(current.getRightChild());
        System.out.print(current.getData() + " ");
    }

    public void inOrderTraversalIteratively() {
        Node previous = null;
        Node current = getRoot();
        Node nextNode = null;
        while (current != null) {
            if (previous == null || previous == current.getParent()) {
                if (current.getLeftChild() != null) {
                    nextNode = current.getLeftChild();
                } else {
                    System.out.print(current.getData() + " ");
                    nextNode = current.getRightChild() != null ? current.getRightChild() : current.getParent();
                }
            } else if (previous == current.getLeftChild()) {
                System.out.print(current.getData() + " ");
                nextNode = current.getRightChild() != null ? current.getRightChild() : current.getParent();
            } else {
                nextNode = current.getParent();
            }
            previous = current;
            current = nextNode;
        }
        System.out.println();
    }
}