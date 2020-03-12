package com.sorting.java;

import com.utilities.java.ArrayUtilities;

public class MergeSort {

    public static void main(String[] args) {
        ArrayUtilities.printArray(mergeSort(new int[]{1, 4, 7, 2, 1}));
    }

    public static int[] mergeSort(int[] arr) {
        return mergeSortHelper(new int[arr.length], arr, 0, (arr.length - 1));
    }

    public static int[] mergeSortHelper(int[] arrA, int[] arrB, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return arrB;
        } else {
            int middle = (lowerBound + upperBound) / 2;
            mergeSortHelper(arrA, arrB, lowerBound, middle);
            mergeSortHelper(arrA, arrB, (middle + 1), upperBound);
            return mergeRec(arrA, arrB, lowerBound, (middle + 1), upperBound);
        }
    }

    public static int[] mergeRec(int[] arrA, int[] arrB, int aDex, int bDex, int upperBound) {
        int j = 0;
        int lowerBound = aDex;
        int middle = bDex - 1;
        int numberOfElements = upperBound - lowerBound + 1;

        while (aDex <= middle && bDex <= upperBound) {
            arrA[j++] = arrB[aDex] > arrB[bDex] ? arrB[bDex++] : arrB[aDex++];
        }

        while (aDex <= middle) {
            arrA[j++] = arrB[aDex++];
        }

        while (bDex <= upperBound) {
            arrA[j++] = arrB[bDex++];
        }

        for (j = 0; j < numberOfElements; j++) {
            arrB[lowerBound + j] = arrA[j];
        }
        return arrB;
    }

    public static int[] merge(int[] arrayA, int[] arrayB) {
        int aDex = 0;
        int bDex = 0;
        int[] finalArray = new int[arrayA.length + arrayB.length];
        for (int i = 0; i < finalArray.length; i++) {
            if (aDex < arrayA.length && bDex < arrayB.length) {
                finalArray[i] = arrayA[aDex] < arrayB[bDex] ? arrayA[aDex++] : arrayB[bDex++];
            } else if (aDex < arrayA.length) {
                finalArray[i] = arrayA[aDex++];
            } else {
                finalArray[i] = arrayB[bDex++];
            }
        }
        return finalArray;
    }

}
