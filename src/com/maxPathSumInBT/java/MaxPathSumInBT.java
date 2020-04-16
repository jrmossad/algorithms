package com.maxPathSumInBT.java;

import com.utilities.binaryTree.java.BinaryTree;
import com.utilities.binaryTree.java.Node;

public class MaxPathSumInBT {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.levelInsert(1);
        tree.levelInsert(2);
        tree.levelInsert(3);
        tree.levelInsert(4);
        tree.levelInsert(5);
        tree.levelInsert(6);
        tree.levelInsert(7);
        System.out.println(maxPathSumInBT(tree));
    }

    public static int maxPathSumInBT(BinaryTree tree) {
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