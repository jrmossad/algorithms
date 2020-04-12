package com.longestSubstringWithoutDuplication.java;

import java.util.HashMap;

public class LongestSubstringWithoutDuplication {

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("clementisacap"));
    }

    public static String longestSubstringWithoutDuplication(String str) {
        HashMap<Character, Integer> characters = new HashMap<>();
        int startingIndex = 0;
        String max = "";
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (characters.containsKey(current)) {
                startingIndex = Math.max(characters.get(current) + 1, startingIndex);
            }
            if (max.length() < i + 1 - startingIndex) {
                max = str.substring(startingIndex, i + 1);
            }
            characters.put(current, i);
        }
        return max;
    }
}