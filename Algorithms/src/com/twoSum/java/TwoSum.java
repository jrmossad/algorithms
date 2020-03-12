package com.twoSum.java;

import java.util.Arrays;
import java.util.Hashtable;
import com.utilities.java.ArrayUtilities;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 3, 4};
        ArrayUtilities.printArray(twoSumHashTable(arr, 8));
    }

    public static int[] twoSumHashTable(int[] arr, int sum) {
        Hashtable<Integer, Boolean> values = new Hashtable<>();
        for (int x : arr) {
            int y = sum - x;
            if (values.containsKey(y)) {
                return new int[]{y, x};
            }
            values.put(x, true);
        }
        return new int[]{-1};
    }

    public static int[] twoSumBrudeForce(int[] arr, int sum) {
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                currentSum = arr[i] + arr[j];
                if (currentSum == sum) {
                    return new int[]{arr[i], arr[j]};
                }
            }
        }
        return new int[]{-1};
    }

    public static int[] twoSum(int[] arr, int sum) {
        Arrays.sort(arr);
        return twoSumHelper(arr, sum, 0, arr.length - 1);
    }

    public static int[] twoSumHelper(int[] arr, int sum, int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) {
            return new int[]{-1};
        }
        int currentSum = arr[lowerBound] + arr[upperBound];
        System.out.println(currentSum);
        if (currentSum == sum) {
            return new int[]{arr[lowerBound], arr[upperBound]};
        }
        if (currentSum > sum) {
            return twoSumHelper(arr, sum, lowerBound, --upperBound);
        }
        return twoSumHelper(arr, sum, ++lowerBound, upperBound);
    }
}

