package com.subArraySort.java;

import com.utilities.arrayUtilitites.java.ArrayUtilities;

public class SubArraySort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        ArrayUtilities.print1DArray(subArraySort(arr));
    }

    public static int[] subArraySort(int[] arr) {
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (isOutOfOrder(i, arr[i], arr)) {
                minimum = Math.min(minimum, arr[i]);
                maximum = Math.max(maximum, arr[i]);
            }
        }
        if (minimum == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        int indexOfMinimum = 0;
        int indexOfMaximum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > minimum) {
                indexOfMinimum = i;
                break;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < maximum) {
                indexOfMaximum = i;
                break;
            }
        }
        return new int[]{indexOfMinimum, indexOfMaximum};
    }

    private static boolean isOutOfOrder(int i, int value, int[] arr) {
        if (i == 0) {
            return arr[i] > arr[i + 1];
        } else if (i == arr.length - 1) {
            return arr[i] < arr[i - 1];
        }
        return arr[i] < arr[i - 1] || arr[i] > arr[i + 1];
    }
}