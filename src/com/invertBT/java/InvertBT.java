package com.invertBT.java;

import com.binarySearchTree.java.BinarySearchTree;
import com.utilities.java.Node;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBT {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(12);
        tree.insert(11);
        tree.insert(13);
        tree.insert(20);
        tree.insert(19);
        tree.insert(22);
        tree.insert(3);
        tree.insert(1);
        tree.insert(4);
        tree.inOrderTraversal();
        invertBTRecursive(tree);
        tree.inOrderTraversal();
    }

    public static void invertBTRecursive(BinarySearchTree tree) {
        invertBRecursiveTHelper(tree.getRoot());
    }

    public static void invertBRecursiveTHelper(Node current) {
        if (current == null) {
            return;
        }
        swap(current);
        invertBRecursiveTHelper(current.getLeftChild());
        invertBRecursiveTHelper(current.getRightChild());
    }

    public static void invertBTIterative(BinarySearchTree tree) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(tree.getRoot());
        while (nodes.size() != 0) {
            Node current = nodes.remove();
            if (current == null) {
                continue;
            }
            swap(current);
            nodes.add(current.getLeftChild());
            nodes.add(current.getRightChild());
        }
    }

    private static void swap(Node current) {
        Node temp = current.getLeftChild();
        current.setLeftChild(current.getRightChild());
        current.setRightChild(temp);
    }
}
