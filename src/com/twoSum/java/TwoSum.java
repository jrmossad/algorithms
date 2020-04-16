package com.twoSum.java;

import com.utilities.arrayUtilitites.java.ArrayUtilities;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 3, 4};
        ArrayUtilities.print1DArray(twoSumIteratively(arr, 8));
    }

// O(n) time | O(n) space
    public static int[] twoSumHashMap(int[] arr, int sum) {
        HashMap<Integer, Boolean> values = new HashMap<>();
        for (int x : arr) {
            int y = sum - x;
            if (values.containsKey(y)) {
                return new int[]{y, x};
            }
            values.put(x, true);
        }
        return new int[]{-1};
    }

// O(n^2) time | O(1) space
    public static int[] twoSumBruteForce(int[] arr, int sum) {
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

// O(nlog(n)) time | 0(n) space
    public static int[] twoSumRecursively(int[] arr, int sum) {
        Arrays.sort(arr);
        return twoSumHelper(arr, sum, 0, arr.length - 1);
    }

    public static int[] twoSumHelper(int[] arr, int sum, int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) {
            return new int[]{-1, -1};
        }
        int currentSum = arr[lowerBound] + arr[upperBound];
        if (currentSum == sum) {
            return new int[]{arr[lowerBound], arr[upperBound]};
        }
        if (currentSum > sum) {
            return twoSumHelper(arr, sum, lowerBound, --upperBound);
        }
        return twoSumHelper(arr, sum, ++lowerBound, upperBound);
    }

    public static int[] twoSumIteratively(int[] arr, int sum) {
        Arrays.sort(arr);
        int lowerBound = 0;
        int upperBound = arr.length - 1;
        while (lowerBound < upperBound) {
            int currentSum = arr[lowerBound] + arr[upperBound];
            if (currentSum == sum) {
                return new int[]{arr[lowerBound], arr[upperBound]};
            }
            if (currentSum > sum) {
                upperBound--;
            } else {
                lowerBound++;
            }
        }
        return new int[]{-1, -1};
    }
}