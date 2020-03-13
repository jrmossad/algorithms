package com.sorting.java;

import com.utilities.java.ArrayUtilities;

import java.util.ArrayList;

public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {7, 3, 1, 2, 5};
        ArrayUtilities.printArray(countingSort(arr));
    }

    public static int[] countingSort(int[] arr) {
        int maximum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maximum) {
                maximum = arr[i];
            }
        }
        int[] countingArr = new int[maximum + 1];
        for (int i = 0; i < arr.length; i++) {
            ++countingArr[arr[i]];
        }
        int j = 0;
        for (int i = 0; i < countingArr.length; i++) {
            while (countingArr[i] != 0) {
                arr[j++] = i;
                --countingArr[i];
            }
        }
        return arr;
    }
}
