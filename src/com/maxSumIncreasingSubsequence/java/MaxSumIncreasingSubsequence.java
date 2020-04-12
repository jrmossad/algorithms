package com.maxSumIncreasingSubsequence.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxSumIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {8, 12, 2, 3, 15, 5, 7};
        ArrayList result = maxSumIncreasingSubsequence(arr);
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getClass().getSimpleName().equals("ArrayList")) {
                ArrayList<Integer> numbers = (ArrayList<Integer>) result.get(i);
                for (int value : numbers) {
                    System.out.print(value + " ");
                }
                System.out.println();
                continue;
            }
            System.out.println("Sum: " + (int) result.get(i));
        }
    }

    public static ArrayList maxSumIncreasingSubsequence(int[] arr) {
        int[] maxSums = Arrays.copyOf(arr, arr.length);
        int[] indices = new int[arr.length];
        Arrays.fill(indices, -1);
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            for (int j = 0; j < i; j++) {
                if (current >= arr[j] && maxSums[j] + current > maxSums[i]) {
                    maxSums[i] = maxSums[j] + current;
                    indices[i] = j;
                }
            }
            if (maxSums[i] > maxSums[maxIndex]) {
                maxIndex = i;
            }
        }
        ArrayList result = new ArrayList();
        result.add(maxSums[maxIndex]);
        result.add(buildSequence(arr, indices, maxIndex));
        return result;
    }

    private static ArrayList<Integer> buildSequence(int[] arr, int[] indices, int maxIndex) {
        ArrayList<Integer> numbers = new ArrayList<>();
        while (maxIndex != -1) {
            numbers.add(arr[maxIndex]);
            maxIndex = indices[maxIndex];
        }
        Collections.reverse(numbers);
        return numbers;
    }
}