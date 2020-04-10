package com.moveElementToEnd.java;

import com.utilities.java.ArrayUtilities;

public class MoveElementToEnd {

    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 2, 2, 3, 4, 2};
        moveElementToEnd(arr, 2);
        ArrayUtilities.printArray(arr);
    }

    public static void moveElementToEnd(int[] arr, int value) {
        int i = arr.length - 1;
        int j = 0;
        while (i > j) {
            if (arr[i] == value) {
                i--;
                continue;
            } else if (arr[i] != value && arr[j] == value) {
                int temp = arr[i];
                arr[i--] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
    }
}
