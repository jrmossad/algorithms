package com.sorting.java;

import com.utilities.java.ArrayUtilities;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 5};
        ArrayUtilities.printArray(selectionSort(arr));
    }

    public static int[] selectionSort(int[] arr) {
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


}
