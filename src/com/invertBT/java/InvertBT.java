package com.invertBT.java;

import com.utilities.binaryTree.java.BinaryTree;
import com.utilities.binaryTree.java.Node;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBT {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
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
        invertBTRecursively(tree);
        tree.inOrderTraversal();
    }

    // O(n) time | O(log(d))
    public static void invertBTRecursively(BinaryTree tree) {
        invertBRecursivelyTHelper(tree.getRoot());
    }

    public static void invertBRecursivelyTHelper(Node current) {
        if (current == null) {
            return;
        }
        swap(current);
        invertBRecursivelyTHelper(current.getLeftChild());
        invertBRecursivelyTHelper(current.getRightChild());
    }

    // O(n) time | O(n)
    public static void invertBTIteratively(BinaryTree tree) {
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