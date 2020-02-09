package com.peakFinder.java;

public class PeakFinder {

    public static void main(String[] args) {
        int[][] x = {{4, 5, 6, 7, 8, 7, 6, 5, 4, 3, 2},
                {5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3},
                {6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4},
                {7, 8, 9, 10, 11, 10, 9, 8, 7, 6, 5},
                {8, 9, 10, 11, 12, 11, 10, 9, 8, 7, 6},
                {7, 8, 9, 10, 11, 10, 9, 8, 7, 6, 5},
                {6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4},
                {5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3},
                {4, 5, 6, 7, 8, 7, 6, 5, 4, 3, 2},
                {3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1},
                {2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 0}};
        System.out.println(findPeak(x));

    }

    public static int findPeak(int[][] arr) {
        return findPeakHelper(0, arr[0].length, arr);
    }

    public static int findPeakHelper(int startColumn, int endColumn, int[][] arr) {
        int middle = (startColumn + endColumn) / 2;
        int maximum = findMaximum(middle, arr);

        if (!(isPeak(maximum, middle, arr))) {
            int bestNeighbour = getBestNeighbour(maximum, middle, arr);
            int newStartColumn = bestNeighbour > middle ? bestNeighbour : startColumn;
            int newEndColumn = bestNeighbour > middle ? endColumn : bestNeighbour;
            if (newEndColumn < newStartColumn || newStartColumn == -1 || newEndColumn == -1) {
                return -1;
            }
            return findPeakHelper(newStartColumn, newEndColumn, arr);
        }

        return arr[maximum][middle];
    }

    public static int findMaximum(int column, int[][] arr) {
        int maximum = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[maximum][column] < arr[i][column]) {
                maximum = i;
            }
        }

        return maximum;
    }

    public static boolean isPeak(int i, int j, int[][] arr) {
        int element = arr[i][j];
        boolean right = ((j < arr[i].length - 1) && (element >= arr[i][j + 1])) || (j == arr[i].length - 1);
        boolean left = ((j > 0) && (element >= arr[i][j - 1])) || (j == 0);

        return right && left;
    }

    public static int getBestNeighbour(int i, int j, int[][] arr) {
        int element = arr[i][j];
        if ((j < arr[i].length - 1) && (element < arr[i][j + 1])) {
            return j + 1;
        }
        if ((j > 0) && (element < arr[i][j - 1])) {
            return j - 1;
        }

        return -1;
    }

}
