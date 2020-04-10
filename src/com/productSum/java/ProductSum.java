package com.productSum.java;

import java.util.ArrayList;

public class ProductSum {

    public static void main(String[] args) {
        ArrayList numbers = new ArrayList();
        numbers.add(5);
        numbers.add(2);
        ArrayList first = new ArrayList();
        first.add(7);
        first.add(-1);
        numbers.add(first);
        numbers.add(3);
        ArrayList second = new ArrayList();
        second.add(6);
        ArrayList third = new ArrayList();
        third.add(-13);
        third.add(8);
        second.add(third);
        second.add(4);
        numbers.add(second);
        System.out.println(productSum(numbers, 1));
    }

    public static int productSum(ArrayList numbers, int multiplier) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).getClass().getSimpleName().equals("ArrayList")) {
                sum += productSum((ArrayList) numbers.get(i), multiplier + 1);
            } else {
                sum += (int) numbers.get(i);
            }
        }
        return sum * multiplier;
    }

}
