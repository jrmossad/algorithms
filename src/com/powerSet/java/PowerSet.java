package com.powerSet.java;

import java.util.ArrayList;

public class PowerSet {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> result = powerSet(arr);
        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> numbers = (ArrayList<Integer>) result.get(i);
            for (int value : numbers) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> powerSet(int[] arr) {
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            int index = powerSet.size();
            for (int j = 0; j < index; j++) {
                ArrayList<Integer> current = new ArrayList<>();
                for (int k = 0; k < powerSet.get(j).size(); k++) {
                    current.add(powerSet.get(j).get(k));
                }
                current.add(arr[i]);
                powerSet.add(current);
            }
        }
        return powerSet;
    }
}