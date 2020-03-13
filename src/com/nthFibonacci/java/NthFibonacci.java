package com.nthFibonacci.java;

import java.util.Hashtable;

public class NthFibonacci {

    public static void main(String[] args) {
        System.out.println(getNthFibonacciIterative(6));
    }

    public static int getNthFibonacciBruteForce(int number) {
        if (number == 2) {
            return 1;
        }
        if (number == 1) {
            return 0;
        }
        return getNthFibonacciBruteForce(number - 1) + getNthFibonacciBruteForce(number - 2);
    }

    public static int getNthFibonacciHashtable(int number) {
        Hashtable<Integer, Integer> memoize = new Hashtable<>();
        memoize.put(1, 0);
        memoize.put(2, 1);
        return getNthFibonacciHashtableHelper(number, memoize);
    }

    private static int getNthFibonacciHashtableHelper(int number, Hashtable<Integer, Integer> memoize) {
        if (memoize.containsKey(number)) {
            return memoize.get(number);
        } else {
            memoize.put(number, getNthFibonacciHashtableHelper(number - 1, memoize) + getNthFibonacciHashtableHelper(number - 2, memoize));
            return memoize.get(number);
        }
    }

    public static int getNthFibonacciIterative(int number) {
        int[] lastTwo = {0, 1};
        int counter = 3;
        while (counter <= number) {
            int nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            counter++;
        }
        return number > 1 ? lastTwo[1] : lastTwo[0];
    }
}
