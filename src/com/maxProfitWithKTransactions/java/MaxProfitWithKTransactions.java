package com.maxProfitWithKTransactions.java;

public class MaxProfitWithKTransactions {

    public static void main(String[] args) {
        int[] arr = {5, 11, 3, 50, 60, 90};
        System.out.println(maxProfitWithKTransactions(arr, 2));
    }

    // O(n * K) time | O(n * k) space
    public static int maxProfitWithKTransactions(int[] arr, int k) {
        if (arr.length == 0) {
            return 0;
        }
        int[][] profits = new int[k + 1][arr.length];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < profits.length; i++) {
            for (int j = 1; j < profits[i].length; j++) {
                maxProfit = Math.max(maxProfit, profits[i - 1][j - 1] - arr[j - 1]);
                profits[i][j] = Math.max(profits[i][j - 1], maxProfit + arr[j]);
            }
        }
        return profits[k][arr.length - 1];
    }

    // O(n * K) time | O(n) space
    public static int maxProfitWithKTransactionsOptimized(int[] arr, int k) {
        if (arr.length == 0) {
            return 0;
        }
        int[] evenProfits = new int[arr.length];
        int[] oddProfits = new int[arr.length];
        int maxProfit = Integer.MIN_VALUE;
        int[] currentProfits = null;
        int[] previousProfits;
        for (int i = 1; i < k + 1; i++) {
            if (i % 2 == 1) {
                currentProfits = oddProfits;
                previousProfits = evenProfits;
            } else {
                currentProfits = evenProfits;
                previousProfits = oddProfits;
            }
            for (int j = 1; j < arr.length; j++) {
                maxProfit = Math.max(maxProfit, previousProfits[j - 1] - arr[j - 1]);
                currentProfits[j] = Math.max(currentProfits[j - 1], maxProfit + arr[j]);
            }
        }
        return currentProfits[arr.length - 1];
    }
}