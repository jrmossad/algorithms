package com.numberOfWaysToMakeChange.java;

public class NumberOfWaysToMakeChange {

    public static void main(String[] args) {
        int[] arr = {1, 5, 10, 25, 2};
        System.out.println(numberOfWaysToMakeChange(arr, 10));
    }

    public static int numberOfWaysToMakeChange(int[] arr, int change) {
        int[] ways = new int[change + 1];
        ways[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < ways.length; j++) {
                if (arr[i] <= j) {
                    ways[j] += ways[j - arr[i]];
                }
            }
        }
        return ways[ways.length - 1];
    }
}