package com.sorting.java;

import com.utilities.java.ArrayUtilities;

public class MergeSort {

    public static void main(String[] args) {
        int [] a = {1,3,5,7};
        int [] b = {2,4,6,9,10,11};
        int [] c = merge(b,a);
        ArrayUtilities.printArray(c);
    }

//    public static int[] mergeSort() {
//
//    }
//
//    public static int[] mergeSortHelper() {
//
//    }

    public static int[] merge(int[] arrayA, int[] arrayB) {
        int aDex = 0;
        int bDex = 0;
        int [] finalArray = new int[arrayA.length + arrayB.length];
        for(int i = 0; i < finalArray.length; i++) {
            if(aDex < arrayA.length && bDex < arrayB.length) {
                finalArray[i] = arrayA[aDex] < arrayB[bDex] ? arrayA[aDex++] : arrayB[bDex++];
            }
            else if(aDex < arrayA.length) {
                finalArray[i] = arrayA[aDex++];
            } else {
                finalArray[i] = arrayB[bDex++];
            }
        }
        return finalArray;
    }

}
