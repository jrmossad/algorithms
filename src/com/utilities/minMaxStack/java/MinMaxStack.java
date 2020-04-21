package com.utilities.minMaxStack.java;

import java.util.ArrayList;

public class MinMaxStack {

    private ArrayList<Integer> stack;
    private ArrayList<int[]> minMax;

    public MinMaxStack() {
        stack = new ArrayList<>();
        minMax = new ArrayList<>();
    }

    public void push(int item) {
        int[] currentMnMax = null;
        if (!isEmpty()) {
            int[] previousMinMax = minMax.get(stack.size() - 1);
            currentMnMax = new int[]{Math.min(item, previousMinMax[0]), Math.max(item, previousMinMax[1])};

        } else {
            currentMnMax = new int[]{item, item};
        }
        minMax.add(currentMnMax);
        stack.add(item);
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        minMax.remove(minMax.size() - 1);
        return stack.remove(stack.size() - 1);
    }

    public int getMin() {
        if (isEmpty()) {
            return -1;
        }
        return minMax.get(stack.size() - 1)[0];
    }

    public int getMax() {
        if (isEmpty()) {
            return -1;
        }
        return minMax.get(stack.size() - 1)[1];
    }

    public int peak() {
        if (isEmpty()) {
            return -1;
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}