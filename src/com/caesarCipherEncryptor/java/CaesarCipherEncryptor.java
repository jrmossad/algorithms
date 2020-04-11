package com.caesarCipherEncryptor.java;

public class CaesarCipherEncryptor {

    public static void main(String[] args) {
        System.out.println(caesarCipherEncryptor("xyz", 3));
    }

    public static String caesarCipherEncryptor(String string, int key) {
        char[] newLetters = new char[string.length()];
        int newKey = key % 26;
        for (int i = 0; i < string.length(); i++) {
            newLetters[i] = getNewLetter(string.charAt(i), newKey);
        }
        return new String(newLetters);
    }

    private static char getNewLetter(char letter, int key) {
        int newLetterCode = (int) letter + key;
        return newLetterCode <= 122 ? (char) newLetterCode : (char) (96 + (newLetterCode % 122));
    }
}