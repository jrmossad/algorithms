package com.binarySearchTree.java;

import com.utilities.java.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private Node root;
    private Queue<Node> nodesQueue;

    public BinarySearchTree() {
        nodesQueue = new LinkedList<>();
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void messInsert(int data) {
        Node newNode = new Node(data);
        nodesQueue.add(newNode);
        if (getRoot() == null) {
            root = newNode;
        } else if (nodesQueue.peek().getLeftChild() == null) {
            nodesQueue.peek().setLeftChild(newNode);
        } else {
            nodesQueue.peek().setRightChild(newNode);
            nodesQueue.remove(nodesQueue.peek());
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (getRoot() == null) {
            root = newNode;
        } else {
            Node current = getRoot();
            Node parent;
            while (true) {
                parent = current;
                if (current.getData() > data) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else if (current.getData() <= data) {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int data) {
        Node current = getRoot();
        Node parent = getRoot();
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
        }
        if (current == getRoot()) {
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

    public int findClosestValueBSTRecursive(int data) {
        return findClosestValueBSTRecursiveHelper(data, getRoot(), getRoot().getData());
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
        Node current = getRoot();
        int closest = current.getData();
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

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(13);
        tree.insert(5);
        tree.insert(8);
        tree.insert(7);
        tree.insert(6);
        tree.insert(9);
        tree.insert(3);
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(16);
        tree.insert(14);
        tree.insert(11);
        tree.insert(12);
        tree.inOrderTraversal();
        tree.preOrderTraversal();
        tree.postOrderTraversal();
        System.out.println(tree.branchSum());
    }
}
