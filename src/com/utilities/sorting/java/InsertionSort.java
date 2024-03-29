package com.utilities.sorting.java;

import com.utilities.arrayUtilitites.java.ArrayUtilities;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {11, 21, 5000, 5, 500, 500, 3, 21, 2, 1, 9, 80, 20, 15, 11, 21, 100};
        ArrayUtilities.print1DArray(vanillaInsertionSort(arr));
        ArrayUtilities.print1DArray(binarySearchInsertionSort(arr));
    }

    // O(n^2) time | O(1)
    public static int[] vanillaInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    // O(n^2) time | O(1)
    public static int[] binarySearchInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int lowerBound = 0;
            int upperBound = i - 1;
            int location = binarySearch(lowerBound, upperBound, temp, arr);

            for (int j = upperBound; j >= location; j--) {
                arr[j + 1] = arr[j];
            }
            arr[location] = temp;
        }
        return arr;
    }

    public static int binarySearch(int lowerBound, int upperBound, int insertedNum, int[] arr) {
        int middle = (lowerBound + upperBound) / 2;
        if (upperBound == lowerBound) {
            if (insertedNum >= arr[upperBound]) {
                return lowerBound + 1;
            }
            return lowerBound;
        } else if (insertedNum >= arr[middle]) {
            return binarySearch(middle + 1, upperBound, insertedNum, arr);
        }
        return binarySearch(lowerBound, middle - 1, insertedNum, arr);
    }
}