package com.zigzagTraverse.java;

import com.utilities.arrayUtilitites.java.ArrayUtilities;

public class ZigzagTraverse {

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 4, 10},
                {2, 5, 9, 11},
                {6, 8, 12, 15},
                {7, 13, 14, 16}};
        ArrayUtilities.print1DArray(zigzagTraverse(arr));
    }

    // O(n * m) time | O(n * m) space
    public static int[] zigzagTraverse(int[][] arr) {
        if (arr.length == 0) {
            return new int[]{-1};
        }
        int height = arr.length - 1;
        int width = arr[0].length - 1;
        int[] output = new int[arr.length * arr[0].length];
        int i = 0;
        int j = 0;
        int count = 0;
        boolean goingDown = true;
        while (!isOutOfBounds(i, j, height, width)) {
            output[count++] = arr[i][j];
            if (goingDown) {
                if (j == 0 || i == height) {
                    goingDown = false;
                    if (i == height) {
                        j++;
                    } else {
                        i++;
                    }
                } else {
                    i++;
                    j--;
                }
            } else {
                if (i == 0 || j == width) {
                    goingDown = true;
                    if (j == width) {
                        i++;
                    } else {
                        j++;
                    }
                } else {
                    i--;
                    j++;
                }
            }
        }
        return output;
    }

    private static boolean isOutOfBounds(int row, int column, int height, int width) {
        return row < 0 || row > height || column < 0 || column > width;
    }
}