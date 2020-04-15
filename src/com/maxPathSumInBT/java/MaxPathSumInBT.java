package com.maxPathSumInBT.java;

import com.utilities.binarySearchTree.java.BinarySearchTree;
import com.utilities.binarySearchTree.java.Node;

public class MaxPathSumInBT {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.messInsert(1);
        tree.messInsert(2);
        tree.messInsert(3);
        tree.messInsert(4);
        tree.messInsert(5);
        tree.messInsert(6);
        tree.messInsert(7);
        System.out.println(maxPathSumInBT(tree));
    }

    public static int maxPathSumInBT(BinarySearchTree tree) {
        return maxPathSumInBTHelper(tree.getRoot())[1];
    }

    private static int[] maxPathSumInBTHelper(Node current) {
        if (current == null) {
            return new int[]{0, 0};
        }
        int[] leftArray = maxPathSumInBTHelper(current.getLeftChild());
        int leftMaxSumAsBranch = leftArray[0];
        int leftMaxPathSum = leftArray[1];
        int[] rightArray = maxPathSumInBTHelper(current.getRightChild());
        int rightMaxSumAsBranch = rightArray[0];
        int rightMaxPathSum = rightArray[1];
        int maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);
        int value = current.getData();
        int maxSumAsBranch = Math.max(maxChildSumAsBranch + value, value);
        int maxSumAsRootNode = Math.max(leftMaxSumAsBranch + value + rightMaxSumAsBranch, maxSumAsBranch);
        int maxPathSum = Math.max(Math.max(leftMaxPathSum, rightMaxPathSum), maxSumAsRootNode);
        return new int[]{maxSumAsBranch, maxPathSum};
    }
}