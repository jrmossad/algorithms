package com.peakFinder.java;

public class PeakFinder {

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

	public static int getBestNeigbour(int i, int j, int[][] arr) {
		int element = arr[i][j];
		if ((j < arr[i].length - 1) && (element < arr[i][j + 1])) {
			return j + 1;
		}
		if ((j > 0) && (element < arr[i][j - 1])) {
			return j - 1;
		}

		return -1;
	}

	public static int findPeakHelper(int startColumn, int endColumn, int[][] arr) {
		int middle = (startColumn + endColumn) / 2;
		int maximum = findMaximum(middle, arr);

		if (!(isPeak(maximum, middle, arr))) {
			int bestNeigbour = getBestNeigbour(maximum, middle, arr);
			int newStartColumn = bestNeigbour > middle ? bestNeigbour : startColumn;
			int newEndColumn = bestNeigbour > middle ? endColumn : bestNeigbour;
			if (newEndColumn < newStartColumn || newStartColumn == -1 || newEndColumn == -1) {
				return -1;
			}
			return findPeakHelper(newStartColumn, newEndColumn, arr);
		}

		return arr[maximum][middle];
	}
	
	public static int findPeak(int[][] arr) {
		return findPeakHelper(0, arr[0].length, arr);
	}

	public static void main(String[] args) {
		int[][] x = { { 10, 8, 10, 10 }, { 14, 13, 12, 11 }, { 15, 9, 11, 21 }, { 16, 17, 19, 20 } };
		System.out.println(findPeak(x));

	}

}
