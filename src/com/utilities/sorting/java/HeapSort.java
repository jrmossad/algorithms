package com.utilities.sorting.java;

import com.utilities.arrayUtilitites.java.ArrayUtilities;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {11, 21, 5000, 5, 500, 500, 3, 21, 2, 1, 9, 80, 20, 15, 11, 21, 100};
        ArrayUtilities.print1DArray(heapSort(arr));
    }

    public static int[] heapSort(int[] arr) {
        buildHeap(arr);
        for (int i = arr.length - 1; i >= 1; i--) {
            swap(0, i, arr);
            shiftDown(0, i - 1, arr);
        }
        return arr;
    }

    private static void buildHeap(int[] arr) {
        int firstParentIndex = (arr.length - 2) / 2;
        for (int i = firstParentIndex; i >= 0; i--) {
            shiftDown(i, arr.length - 1, arr);
        }
    }

    private static void shiftDown(int currentIndex, int endIndex, int[] arr) {
        int childOneIndex = 2 * currentIndex + 1;
        int indexToSwap;
        while (childOneIndex <= endIndex) {
            int childTwoIndex = 2 * currentIndex + 2 <= endIndex ? 2 * currentIndex + 2 : -1;
            if (childTwoIndex != -1 && arr[childOneIndex] < arr[childTwoIndex]) {
                indexToSwap = childTwoIndex;
            } else {
                indexToSwap = childOneIndex;
            }
            if (arr[currentIndex] < arr[indexToSwap]) {
                swap(currentIndex, indexToSwap, arr);
                currentIndex = indexToSwap;
                childOneIndex = 2 * currentIndex + 1;
            } else {
                break;
            }
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}