package com.utilities.sorting.java;

import com.utilities.arrayUtilitites.java.ArrayUtilities;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {11, 21, 5000, 5, 500, 500, 3, 21, 2, 1, 9, 80, 20, 15, 11, 21, 100};
        ArrayUtilities.print1DArray(bubbleSort(arr));
    }

    // O(n^2) time | O(1)
    public static int[] bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}