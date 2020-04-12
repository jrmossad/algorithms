package com.simpleCycleCheck.java;

public class SimpleCycleCheck {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, -4, -4, 2};
        System.out.println(simpleCycleCheck(arr));
    }

    public static boolean simpleCycleCheck(int[] arr) {
        int numberOfVisitedElements = 0;
        int currentIndex = 0;
        while (numberOfVisitedElements < arr.length) {
            if (numberOfVisitedElements > 0 && currentIndex == 0) {
                return false;
            }
            numberOfVisitedElements++;
            currentIndex = getNextIndex(currentIndex, arr);
        }
        return currentIndex == 0;
    }

    private static int getNextIndex(int currentIndex, int[] arr) {
        int jump = arr[currentIndex];
        int nextIndex = (currentIndex + jump) % arr.length;
        return nextIndex >= 0 ? nextIndex : nextIndex + arr.length;
    }
}