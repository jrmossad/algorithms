package com.smallestSubstringContaining.java;

import java.util.HashMap;

public class SmallestSubstringContaining {

    public static void main(String[] args) {
        String largeString = "abcd$ef$axb$c$";
        String smallString = "$$abf";
        System.out.println(smallestSubstringContaining(smallString, largeString));
    }

    // O(S1 + S2) time | O(S1 + S2) space
    public static String smallestSubstringContaining(String smallString, String largeString) {
        HashMap<Character, Integer> neededCharacters = getUniqueCharactersCount(smallString);
        HashMap<Character, Integer> currentCharacters = new HashMap<>();
        int[] position = new int[]{0, Integer.MAX_VALUE};
        int uniqueCharacter = 0;
        int maxUniqueCharacter = neededCharacters.size();
        int i = 0;
        int j = 0;
        while (j < largeString.length()) {
            char rightChar = largeString.charAt(j);
            if (!neededCharacters.containsKey(rightChar)) {
                j++;
                continue;
            }
            increaseCharacterCount(currentCharacters, rightChar);
            if (currentCharacters.get(rightChar) == neededCharacters.get(rightChar)) {
                uniqueCharacter++;
            }
            while (uniqueCharacter == maxUniqueCharacter && i <= j) {
                if (position[1] - position[0] > (j - i)) {
                    position[0] = i;
                    position[1] = j;
                }
                char leftChar = largeString.charAt(i);
                if (!currentCharacters.containsKey(leftChar)) {
                    i++;
                    continue;
                }
                if (currentCharacters.get(leftChar) == neededCharacters.get(leftChar)) {
                    uniqueCharacter--;
                }
                decreaseCharacterCount(currentCharacters, leftChar);
                i++;
            }
            j++;
        }
        if (position[1] == Integer.MAX_VALUE) {
            return "";
        }
        return largeString.substring(position[0], position[1] + 1);
    }

    private static HashMap<Character, Integer> getUniqueCharactersCount(String smallString) {
        HashMap<Character, Integer> neededCharacters = new HashMap<>();
        for (int i = 0; i < smallString.length(); i++) {
            char current = smallString.charAt(i);
            if (!neededCharacters.containsKey(current)) {
                neededCharacters.put(current, 0);
            }
            int count = neededCharacters.get(current);
            neededCharacters.put(current, ++count);
        }
        return neededCharacters;
    }

    private static void increaseCharacterCount(HashMap<Character, Integer> currentCharacters, char character) {
        if (!currentCharacters.containsKey(character)) {
            currentCharacters.put(character, 0);
        }
        int count = currentCharacters.get(character);
        currentCharacters.put(character, ++count);
    }

    private static void decreaseCharacterCount(HashMap<Character, Integer> currentCharacters, char character) {
        int count = currentCharacters.get(character);
        currentCharacters.put(character, --count);
    }
}