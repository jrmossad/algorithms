package com.fourNumberSum.java;

import java.util.ArrayList;
import java.util.HashMap;

public class FourNumberSum {

    public static void main(String[] args) {
        int[] arr = {7, 6, 4, -1, 1, 2};
        ArrayList<int[]> numberSum = fourNumberSum(arr, 16);
        for (int[] numbers : numberSum) {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    // O(n^2) time | O(n^2) space on average
    // O(n^3) time | O(n^2) space on worst case
    public static ArrayList<int[]> fourNumberSum(int[] arr, int target) {
        HashMap<Integer, ArrayList<int[]>> allPairSums = new HashMap<>();
        ArrayList<int[]> numberSum = new ArrayList<>();
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int currentSum = arr[i] + arr[j];
                int difference = target - currentSum;
                if (allPairSums.containsKey(difference)) {
                    for (int[] pair : allPairSums.get(difference)) {
                        int[] match = new int[4];
                        match[0] = pair[0];
                        match[1] = pair[1];
                        match[2] = arr[i];
                        match[3] = arr[j];
                        numberSum.add(match);
                    }
                }
            }
            for (int j = 0; j < i; j++) {
                int currentSum = arr[i] + arr[j];
                if (!allPairSums.containsKey(currentSum)) {
                    ArrayList<int[]> numbers = new ArrayList<>();
                    numbers.add(new int[]{arr[i], arr[j]});
                    allPairSums.put(currentSum, numbers);
                } else {
                    allPairSums.get(currentSum).add(new int[]{arr[i], arr[j]});
                }
            }
        }
        return numberSum;
    }
}