package com.levenshteinDistance.java;

import java.util.Arrays;

public class LevenshteinDistance {

    public static void main(String[] args) {
        System.out.println(levenshteinDistance("yabd", "abc"));
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
                    moves[i][j] = Math.min(moves[i - 1][j - 1], Math.min(moves[i - 1][j], moves[i][j - 1])) + 1;
                }
            }
        }
        return moves[str2.length()][str1.length()];
    }
}
