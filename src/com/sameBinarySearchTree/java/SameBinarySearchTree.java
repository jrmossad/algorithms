package com.sameBinarySearchTree.java;

import java.util.ArrayList;

public class SameBinarySearchTree {

    public static void main(String[] args) {
        ArrayList<Integer> arrA = new ArrayList<>();
        arrA.add(10);
        arrA.add(15);
        arrA.add(8);
        arrA.add(12);
        arrA.add(94);
        arrA.add(81);
        arrA.add(5);
        arrA.add(2);
        arrA.add(11);
        ArrayList<Integer> arrB = new ArrayList<>();
        arrB.add(10);
        arrB.add(8);
        arrB.add(5);
        arrB.add(15);
        arrB.add(2);
        arrB.add(12);
        arrB.add(11);
        arrB.add(94);
        arrB.add(81);
        System.out.println(sameBstsOptimized(arrA, arrB));
    }

    public static boolean sameBstsOptimized(ArrayList<Integer> arrA, ArrayList<Integer> arrB) {
        return sameBstsOptimizedHelper(arrA, arrB, 0, 0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private static boolean sameBstsOptimizedHelper(ArrayList<Integer> arrA, ArrayList<Integer> arrB, int indexA,
                                                   int indexB, double minValue, double maxValue) {
        if (indexA == -1 || indexB == -1) {
            return (indexA == indexB);
        }
        if (!arrA.get(indexA).equals(arrB.get(indexB))) {
            return false;
        }
        int leftSmallerIndexA = getIndexOfFirstSmaller(arrA, indexA, minValue);
        int leftSmallerIndexB = getIndexOfFirstSmaller(arrB, indexB, minValue);
        int rightBiggerIndexA = getIndexOfFirstBigger(arrA, indexA, maxValue);
        int rightBiggerIndexB = getIndexOfFirstBigger(arrB, indexB, maxValue);
        double currentValue = arrA.get(indexA);
        boolean leftAreSame = sameBstsOptimizedHelper(arrA, arrB, leftSmallerIndexA, leftSmallerIndexB, currentValue, maxValue);
        boolean rightAreSame = sameBstsOptimizedHelper(arrA, arrB, rightBiggerIndexA, rightBiggerIndexB, minValue, currentValue);
        return leftAreSame && rightAreSame;
    }

    private static int getIndexOfFirstSmaller(ArrayList<Integer> arr, int index, double minValue) {
        for (int i = index + 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(index) && arr.get(i) >= minValue) {
                return i;
            }
        }
        return -1;
    }

    private static int getIndexOfFirstBigger(ArrayList<Integer> arr, int index, double maxValue) {
        for (int i = index + 1; i < arr.size(); i++) {
            if (arr.get(i) >= arr.get(index) && arr.get(i) >= maxValue) {
                return i;
            }
        }
        return -1;
    }

    public static boolean sameBsts(ArrayList<Integer> arrA, ArrayList<Integer> arrB) {
        if (arrA.size() != arrB.size()) {
            return false;
        }
        if (arrA.size() == 0) {
            return true;
        }
        if (!arrA.get(0).equals(arrB.get(0))) {
            return false;
        }
        ArrayList<Integer> leftA = getSmaller(arrA);
        ArrayList<Integer> leftB = getSmaller(arrB);
        ArrayList<Integer> rightA = getBigger(arrA);
        ArrayList<Integer> rightB = getBigger(arrB);
        return sameBsts(leftA, leftB) && sameBsts(rightA, rightB);
    }

    private static ArrayList<Integer> getSmaller(ArrayList<Integer> arr) {
        ArrayList<Integer> smaller = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(0)) {
                smaller.add(arr.get(i));
            }
        }
        return smaller;
    }

    private static ArrayList<Integer> getBigger(ArrayList<Integer> arr) {
        ArrayList<Integer> bigger = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) <= arr.get(0)) {
                bigger.add(arr.get(i));
            }
        }
        return bigger;
    }
}
