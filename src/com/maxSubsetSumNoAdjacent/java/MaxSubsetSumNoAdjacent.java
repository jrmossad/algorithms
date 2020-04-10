package com.maxSubsetSumNoAdjacent.java;

public class MaxSubsetSumNoAdjacent {

    public static void main(String[] args) {
        int[] arr = {7, 10, 12, 7, 9, 14};
        System.out.println(maxSubsetSumNoAdjacentOptimized(arr));
    }

    public static int maxSubsetSumNoAdjacent(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int[] maxSums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                maxSums[i] = arr[i];
            } else if (i == 1) {
                maxSums[i] = Math.max(maxSums[i - 1], arr[i]);
            } else {
                maxSums[i] = Math.max(maxSums[i - 1], arr[i] + maxSums[i - 2]);
            }
        }
        return maxSums[arr.length - 1];
    }

    public static int maxSubsetSumNoAdjacentOptimized(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }
        int first = arr[0];
        int second = arr[1];
        int maxSums = second;
        for (int i = 2; i < arr.length; i++) {
            maxSums = Math.max(second, arr[i] + first);
            first = second;
            second = maxSums;
        }
        return maxSums;
    }
}

