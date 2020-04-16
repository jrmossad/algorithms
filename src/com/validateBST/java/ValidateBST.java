package com.validateBST.java;

import com.utilities.binaryTree.java.BinaryTree;
import com.utilities.binaryTree.java.Node;

public class ValidateBST {

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();
        tree1.levelInsert(5);
        tree1.levelInsert(7);
        tree1.levelInsert(2);
        tree1.levelInsert(20);
        tree1.levelInsert(21);
        tree1.levelInsert(3);
        tree1.levelInsert(4);
        BinaryTree tree2 = new BinaryTree();
        tree2.insert(5);
        tree2.insert(7);
        tree2.insert(2);
        tree2.insert(20);
        tree2.insert(21);
        tree2.insert(3);
        tree2.insert(4);
        System.out.println(validateBST(tree1));
        System.out.println(validateBST(tree2));
    }

    // O(n) time | O(d) space
    public static boolean validateBST(BinaryTree tree) {
        return validateBSTHelper(tree.getRoot(), Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBSTHelper(Node current, int minValue, int maxValue) {
        if (current == null) {
            return true;
        }
        if (current.getData() > maxValue && current.getData() <= minValue) {
            return false;
        }
        return (validateBSTHelper(current.getLeftChild(), minValue, current.getData()) &&
                validateBSTHelper(current.getRightChild(), current.getData(), maxValue));
    }
}