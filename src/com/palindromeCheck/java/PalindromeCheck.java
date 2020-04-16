package com.palindromeCheck.java;

public class PalindromeCheck {

    public static void main(String[] args) {
        System.out.println(palindromeCheckRecursively("racecara"));
    }

    // O(n) time | O(n) space
    public static boolean palindromeCheckRecursively(String string) {
        return palindromeCheckRecursivelyHelper(string, 0, string.length() - 1);
    }

    private static boolean palindromeCheckRecursivelyHelper(String string, int i, int j) {
        if (i >= j) {
            return true;
        }
        return string.charAt(i) == string.charAt(j) && palindromeCheckRecursivelyHelper(string, i + 1, j - 1);
    }

    // O(n) time | O(n) space
    public static boolean palindromeCheckReverse(String string) {
        String newString = new StringBuilder(string).reverse().toString();
        return string.equals(newString);
    }

    // O(n) time | O(n) space
    public static boolean palindromeCheckReverseArray(String string) {
        char[] reverseString = new char[string.length()];
        int j = 0;
        for (int i = string.length() - 1; i >= 0; i--) {
            reverseString[j++] = string.charAt(i);
        }
        return new String(reverseString).equals(string);
    }

    // O(n) time | O(1) space
    public static boolean palindromeCheckOptimized(String string) {
        int i = 0;
        int j = string.length() - 1;
        if (j == -1) {
            return true;
        }
        while (i != j) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}