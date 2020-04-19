package com.numbersInPi.java;

import java.util.HashMap;

public class NumbersInPi {

    public static void main(String[] args) {
        String str = "3141592";
        String[] numbers = {"3141", "5", "31", "2", "4159", "9", "42", "3", "141592"};
        System.out.println(numbersInPi(str, numbers));
    }

    // O(n^3 + m) time | O(n + m) space
    public static int numbersInPi(String str, String[] numbers) {
        HashMap<String, Boolean> numbersInTable = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            numbersInTable.put(numbers[i], true);
        }
        HashMap<Integer, Integer> cache = new HashMap<>();
        int minSpaces = getMinSpaces(str, numbersInTable, cache, 0);
        return minSpaces == Integer.MAX_VALUE ? -1 : minSpaces;
    }

    private static int getMinSpaces(String str, HashMap<String, Boolean> numbersInTable,
                                    HashMap<Integer, Integer> cache, int current) {
        if (current == str.length()) {
            return -1;
        }
        if (cache.containsKey(current)) {
            return cache.get(current);
        }
        int minSpaces = Integer.MAX_VALUE;
        for (int i = current; i < str.length(); i++) {
            String prefix = str.substring(current, i + 1);
            if (numbersInTable.containsKey(prefix)) {
                int minSpacesInSuffix = getMinSpaces(str, numbersInTable, cache, i + 1);
                minSpaces = Math.min(minSpaces, minSpacesInSuffix + 1);
            }
        }
        cache.put(current, minSpaces);
        return cache.get(current);
    }
}