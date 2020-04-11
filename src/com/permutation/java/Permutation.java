package com.permutation.java;

import com.utilities.java.ArrayUtilities;

public class Permutation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permutation(arr);
    }

    public static void permutation(int[] arr) {
        permutationHelper(arr, arr.length);
    }

    private static void permutationHelper(int[] arr, int currentSize) {
        if (currentSize == 1) {
            return;
        }
        for (int i = 0; i < currentSize; i++) {
            permutationHelper(arr, currentSize - 1);
            if (currentSize == 2) {
                ArrayUtilities.print1DArray(arr);
            }
            rotate(arr, currentSize);
        }
    }

    private static void rotate(int[] arr, int currentSize) {
        int position = arr.length - currentSize;
        int temp = arr[position];
        int i;
        for (i = position + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[i - 1] = temp;
    }
}