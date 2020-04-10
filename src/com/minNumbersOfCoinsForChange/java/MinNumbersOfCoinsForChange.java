package com.minNumbersOfCoinsForChange.java;

import java.util.Arrays;

public class MinNumbersOfCoinsForChange {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        System.out.println(minNumbersOfCoinsForChange(arr, 6));
    }

    public static int minNumbersOfCoinsForChange(int[] arr, int change) {
        int[] coins = new int[change + 1];
        Arrays.fill(coins, Integer.MAX_VALUE);
        coins[0] = 0;
        for (int value : arr) {
            for (int j = 1; j < coins.length; j++) {
                if (value <= j) {
                    coins[j] = Math.min(coins[j - value] + 1, coins[j]);
                }
            }
        }
        return coins[coins.length - 1] == Integer.MAX_VALUE? -1: coins[coins.length - 1];
    }
}
