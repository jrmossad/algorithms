package com.palindromeCheck.java;

public class PalindromeCheck {

    public static void main(String[] args) {
        System.out.println(palindromeCheckRecursive("racecara"));
    }

    public static boolean palindromeCheckRecursive(String string) {
        return palindromeCheckRecursiveHelper(string, 0, string.length() - 1);
    }

    private static boolean palindromeCheckRecursiveHelper(String string, int i, int j) {
        if (i >= j) {
            return true;
        }
        return string.charAt(i) == string.charAt(j) && palindromeCheckRecursiveHelper(string, i + 1, j - 1);
    }

    public static boolean palindromeCheckReverse(String string) {
        String newString = new StringBuilder(string).reverse().toString();
        return string.equals(newString);
    }

    public static boolean palindromeCheckReverseArray(String string) {
        char[] reverseString = new char[string.length()];
        int j = 0;
        for (int i = string.length() - 1; i >= 0; i--) {
            reverseString[j++] = string.charAt(i);
        }
        return new String(reverseString).equals(string);
    }

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
