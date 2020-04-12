package com.longestSubstringWithoutDuplication.java;

import java.util.HashMap;

public class LongestSubstringWithoutDuplication {

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("clementisacap"));
    }

    public static String longestSubstringWithoutDuplication(String str) {
        HashMap<Character, Integer> characters = new HashMap<>();
        int startingIndex = 0;
        int[] max = {0, 1};
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (characters.containsKey(current)) {
                startingIndex = Math.max(characters.get(current) + 1, startingIndex);
            }
            if (max[1] - max[0] < i + 1 - startingIndex) {
                max[1] = i + 1;
                max[0] = startingIndex;
            }
            characters.put(current, i);
        }
        return str.substring(max[0], max[1]);
    }
}