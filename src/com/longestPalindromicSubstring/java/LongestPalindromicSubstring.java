package com.longestPalindromicSubstring.java;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String str = "abaxyzzyxf";
        System.out.println(longestPalindromicSubstring(str));
    }

    // O(n^2) time | O(1) space
    public static String longestPalindromicSubstring(String str) {
        if (str.length() == 0) {
            return "";
        }
        int[] longest = new int[]{0, 1};
        int[] oddCut;
        int[] evenCut;
        int[] maxBetweenTwo;
        for (int i = 1; i < str.length() - 1; i++) {
            oddCut = getTheLongestPalindromeFrom(str, i - 1, i + 1);
            evenCut = getTheLongestPalindromeFrom(str, i - 1, i);
            maxBetweenTwo = oddCut[1] - oddCut[0] > evenCut[1] - evenCut[0] ? oddCut : evenCut;
            longest = maxBetweenTwo[1] - maxBetweenTwo[0] > longest[1] - longest[0] ? maxBetweenTwo : longest;
        }
        return str.substring(longest[0], longest[1]);
    }

    private static int[] getTheLongestPalindromeFrom(String str, int leftPointer, int rightPointer) {
        while (leftPointer >= 0 && rightPointer < str.length()) {
            if (str.charAt(leftPointer) != str.charAt(rightPointer)) {
                break;
            }
            leftPointer--;
            rightPointer++;
        }
        return new int[]{leftPointer + 1, rightPointer};
    }
}