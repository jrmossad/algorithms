package com.searchInSortedMatrix.java;

import com.utilities.java.ArrayUtilities;

public class SearchInSortedMatrix {

    public static void main(String[] args) {
        int[][] arr = {{1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004}};
        ArrayUtilities.print1DArray(searchInSortedMatrix(arr, 44));
    }

    public static int[] searchInSortedMatrix(int[][] arr, int value) {
        if (arr.length == 0) {
            return new int[]{-1, -1};
        }
        int row = 0;
        int column = arr[0].length - 1;
        while (row < arr.length && column >= 0) {
            if (arr[row][column] > value) {
                column--;
            } else if (arr[row][column] < value) {
                row++;
            } else {
                return new int[]{row, column};
            }
        }
        return new int[]{-1, -1};
    }
}