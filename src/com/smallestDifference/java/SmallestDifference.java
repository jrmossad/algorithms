package com.smallestDifference.java;

import com.utilities.java.ArrayUtilities;

import java.util.Arrays;

public class SmallestDifference {


    public static void main(String[] args) {
        int[] arrA = {-1, 5, 10, 20, 28, 3};
        int[] arrB = {26, 134, 135, 15, 157};
        ArrayUtilities.print1DArray(smallestDifference(arrA, arrB));
    }

    public static int[] smallestDifference(int[] arrA, int[] arrB) {
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int indexA = 0;
        int indexB = 0;
        double minimumDifference = Double.POSITIVE_INFINITY;
        double currentDifference = Double.POSITIVE_INFINITY;
        int[] smallestPair = new int[2];
        while ((indexA < arrA.length) && (indexB < arrB.length)) {
            int numA = arrA[indexA];
            int numB = arrB[indexB];
            currentDifference = Math.abs((numA - numB));
            if (currentDifference < minimumDifference) {
                minimumDifference = currentDifference;
                smallestPair[0] = numA;
                smallestPair[1] = numB;
            }

            if (numA < numB) {
                indexA++;
            } else if (numA > numB) {
                indexB++;
            } else {
                break;
            }

        }
        return smallestPair;
    }
}
