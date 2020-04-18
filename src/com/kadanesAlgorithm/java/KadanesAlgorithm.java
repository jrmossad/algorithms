package com.kadanesAlgorithm.java;

public class KadanesAlgorithm {

    public static void main(String[] args) {
        int[] arr = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println(kadanesAlgorithm(arr));
    }

    // O(n) time | O(1) space
    public static int kadanesAlgorithm(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int lastMax = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            lastMax = Math.max(current, lastMax + current);
            if (lastMax > max) {
                max = lastMax;
            }
        }
        return max;
    }
}