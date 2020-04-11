package com.binarySearch.java;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 9, 11, 11, 15, 20, 21, 21, 21, 80, 100, 500, 500, 5000};
        System.out.println(binarySearchIteratively(arr, 21));
    }

    public static int binarySearchIteratively(int[] arr, int target) {
        int lowerBound = 0;
        int upperBound = arr.length - 1;
        int middle;
        while (true) {
            middle = (lowerBound + upperBound) / 2;
            if (lowerBound > upperBound) {
                return -1;
            } else if (arr[middle] == target) {
                return target;
            } else if (arr[middle] > target) {
                upperBound = middle - 1;
            } else {
                lowerBound = middle + 1;
            }
        }
    }

    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchRecursiveHelper(arr, target, 0, arr.length - 1);
    }

    public static int binarySearchRecursiveHelper(int[] arr, int target, int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            return -1;
        }
        int middle = (lowerBound + upperBound) / 2;
        if (arr[middle] == target) {
            return target;
        }
        if (arr[middle] > target) {
            return binarySearchRecursiveHelper(arr, target, lowerBound, middle - 1);
        }
        return binarySearchRecursiveHelper(arr, target, middle + 1, upperBound);
    }
}