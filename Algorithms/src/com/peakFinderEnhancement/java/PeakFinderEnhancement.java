package com.peakFinderEnhancement.java;

public class PeakFinderEnhancement {

    public static void main(String[] ars) {
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
        System.out.println(findPeakEnhancement(x));
    }

    public static int findPeakEnhancement(int[][] arr) {
        return findPeakEnhancementHelper(0, arr.length, 0, arr[0].length, true, arr);
    }

    public static int findPeakEnhancementHelper(int startRow, int endRow, int startColumn, int endColumn,
                                                boolean rowSplit, int[][] arr) {

        int maximum;

        if (!rowSplit) {
            int middleColumn = (startColumn + endColumn) / 2;
            maximum = findMaximum(middleColumn, false, arr);

            if (!(isPeak(maximum, middleColumn, false, arr))) {
                int bestNeighbour = getBestNeighbour(maximum, middleColumn, false, arr);
                int newStartColumn = bestNeighbour > middleColumn ? bestNeighbour : startColumn;
                int newEndColumn = bestNeighbour > middleColumn ? endColumn : bestNeighbour;
                if (newEndColumn < newStartColumn || newStartColumn == -1 || newEndColumn == -1) {
                    return -1;
                }
                return findPeakEnhancementHelper(startRow, endRow, newStartColumn, newEndColumn, true, arr);
            }
            return arr[maximum][middleColumn];
        } else {

            int middleRow = (startRow + endRow) / 2;
            maximum = findMaximum(middleRow, true, arr);

            if (!(isPeak(middleRow, maximum, true, arr))) {
                int bestNeighbour = getBestNeighbour(middleRow, maximum, true, arr);
                int newStartRow = bestNeighbour > middleRow ? bestNeighbour : startRow;
                int newEndRow = bestNeighbour > middleRow ? endRow : bestNeighbour;
                if (newEndRow < newStartRow || newStartRow == -1 || newEndRow == -1) {
                    return -1;
                }
                return findPeakEnhancementHelper(newStartRow, newEndRow, startColumn, endColumn, false, arr);
            }
            return arr[middleRow][maximum];
        }

    }

    public static int findMaximum(int x, boolean rowSplit, int[][] arr) {
        int maximum = 0;

        if (!rowSplit) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[maximum][x] < arr[i][x]) {
                    maximum = i;
                }
            }
            return maximum;
        }
        for (int j = 1; j < arr[0].length; j++) {
            if (arr[x][maximum] < arr[x][j]) {
                maximum = j;
            }
        }
        return maximum;
    }

    public static boolean isPeak(int i, int j, boolean rowSplit, int[][] arr) {
        int element = arr[i][j];

        if (!rowSplit) {
            boolean right = ((j < arr[i].length - 1) && (element >= arr[i][j + 1])) || (j == arr[i].length - 1);
            boolean left = ((j > 0) && (element >= arr[i][j - 1])) || (j == 0);

            return right && left;
        }
        boolean down = ((i < arr.length - 1) && (element >= arr[i + 1][j])) || (i == arr.length - 1);
        boolean top = ((i > 0) && (element >= arr[i - 1][j])) || (i == 0);

        return down && top;
    }

    public static int getBestNeighbour(int i, int j, boolean rowSplit, int[][] arr) {
        int element = arr[i][j];

        if (!rowSplit) {
            if ((j < arr[i].length - 1) && (element < arr[i][j + 1])) {
                return j + 1;
            }
            if ((j > 0) && (element < arr[i][j - 1])) {
                return j - 1;
            }
        } else {
            if ((i < arr.length - 1) && (element < arr[i + 1][j])) {
                return i + 1;
            }
            if ((i > 0) && (element < arr[i - 1][j])) {
                return i - 1;
            }
        }

        return -1;
    }


}
