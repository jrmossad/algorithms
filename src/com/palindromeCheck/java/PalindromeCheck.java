package com.palindromeCheck.java;

public class PalindromeCheck {

    public static void main(String[] args) {
        System.out.println(palindromeCheckReverse("racecara"));
    }

    public static boolean palindromeCheckReverse(String string) {
        String newString = new StringBuilder(string).reverse().toString();
        return string.equals(newString);
    }

    public static boolean palindromeCheck(String string) {
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
