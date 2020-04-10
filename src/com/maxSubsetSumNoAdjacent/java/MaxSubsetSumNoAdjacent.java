package com.maxSubsetSumNoAdjacent.java;

public class MaxSubsetSumNoAdjacent {

    public static void main(String[] args) {
        int[] arr = {7, 10, 12, 7, 9, 14};
        System.out.println(maxSubsetSumNoAdjacent(arr));
    }

    public static int maxSubsetSumNoAdjacent(int[] arr) {
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
}
