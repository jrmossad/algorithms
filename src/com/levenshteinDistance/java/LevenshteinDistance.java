package com.levenshteinDistance.java;

public class LevenshteinDistance {

    public static void main(String[] args) {
        System.out.println(levenshteinDistanceOptimized("yabd", "abc"));
    }

    public static int levenshteinDistance(String str1, String str2) {
        int[][] moves = new int[str2.length() + 1][str1.length() + 1];
        for (int i = 0; i < moves[0].length; i++) {
            moves[0][i] = i;
        }
        for (int i = 1; i < moves.length; i++) {
            moves[i][0] = i;
        }
        for (int i = 1; i < moves.length; i++) {
            for (int j = 1; j < moves[i].length; j++) {
                if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    moves[i][j] = moves[i - 1][j - 1];
                } else {
                    moves[i][j] = 1 + Math.min(moves[i - 1][j - 1], Math.min(moves[i - 1][j], moves[i][j - 1]));
                }
            }
        }
        return moves[str2.length()][str1.length()];
    }

    public static int levenshteinDistanceOptimized(String str1, String str2) {
        String smallerString = str1.length() > str2.length() ? str2 : str1;
        String largerString = str1.length() < str2.length() ? str2 : str1;
        int[] evenEdits = new int[smallerString.length() + 1];
        for (int i = 0; i < evenEdits.length; i++) {
            evenEdits[i] = i;
        }
        int[] oddEdits = new int[smallerString.length() + 1];
        int[] currentEdits;
        int[] previousEdits;
        for (int i = 1; i < largerString.length() + 1; i++) {
            if (i % 2 == 1) {
                currentEdits = oddEdits;
                previousEdits = evenEdits;
            } else {
                currentEdits = evenEdits;
                previousEdits = oddEdits;
            }
            currentEdits[0] = i;
            for (int j = 1; j < smallerString.length() + 1; j++) {
                if (smallerString.charAt(j - 1) == largerString.charAt(i - 1)) {
                    currentEdits[j] = previousEdits[j - 1];
                } else {
                    currentEdits[j] = 1 + Math.min(previousEdits[j - 1], Math.min(previousEdits[j], currentEdits[j - 1]));
                }
            }
        }
        return (largerString.length() % 2 == 0) ? evenEdits[evenEdits.length - 1] : oddEdits[oddEdits.length - 1];
    }
}