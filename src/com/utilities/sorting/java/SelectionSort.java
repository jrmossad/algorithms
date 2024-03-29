package com.utilities.sorting.java;

import com.utilities.arrayUtilitites.java.ArrayUtilities;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {8, 1, 4, 3, 5, 2, 7};
        ArrayUtilities.print1DArray(selectionSortMin(arr));
    }

    // O(n^2) time | O(1)
    public static int[] selectionSortMax(int[] arr) {
        int maximum;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            int placeToReplace = arr.length - 1 - i;
            maximum = placeToReplace;
            for (int j = arr.length - 1 - i; j >= 0; j--) {
                if (arr[j] > arr[maximum]) {
                    maximum = j;
                }
            }
            temp = arr[maximum];
            arr[maximum] = arr[placeToReplace];
            arr[placeToReplace] = temp;
        }
        return arr;
    }

    // O(n^2) time | O(1)
    public static int[] selectionSortMin(int[] arr) {
        int minimum;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minimum = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minimum]) {
                    minimum = j;
                }
            }
            temp = arr[minimum];
            arr[minimum] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}