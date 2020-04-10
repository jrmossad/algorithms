package com.sorting.java;

import com.utilities.java.ArrayUtilities;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        ArrayUtilities.printArray(radixSort(arr));
    }

    public static int[] radixSort(int[] arr) {
        int max = getMax(arr);
        for (int digit = 1; max / digit > 0; digit *= 10) {
            countingSort(arr, digit);
        }
        return arr;
    }

    private static int getMax(int[] arr) {
        int max = 0;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private static void countingSort(int[] arr, int digit) {
        int[] output = new int[arr.length];
        int[] count = new int[10];
        for (int value : arr) {
            count[(value / digit) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / digit) % 10] - 1] = arr[i];
            count[(arr[i] / digit) % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
