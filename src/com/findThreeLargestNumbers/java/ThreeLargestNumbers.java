package com.findThreeLargestNumbers.java;

import com.utilities.arrayUtilitites.java.ArrayUtilities;

public class ThreeLargestNumbers {

    public static void main(String[] args) {
        int[] arr = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        ArrayUtilities.print1DArray(findThreeLargestNumbers(arr));
    }

    public static int[] findThreeLargestNumbers(int[] arr) {
        int[] result = new int[3];
        for (int value : arr) {
            if (value > result[2]) {
                shift(result, value, 2);
            } else if (value > result[1]) {
                shift(result, value, 1);
            } else if (value > result[0]) {
                shift(result, value, 0);
            }
        }
        return result;
    }

    private static void shift(int[] result, int value, int index) {
        for (int i = 0; i < index; i++) {
            result[i] = result[i + 1];
        }
        result[index] = value;
    }
}