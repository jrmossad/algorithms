package com.utilities.heap.java;

import java.util.ArrayList;
import java.util.Collections;

public class MinHeap {

    private ArrayList<Integer> minHeap;

    public MinHeap(ArrayList<Integer> arr) {
        minHeap = arr;
        buildHeap(minHeap);
    }

    private ArrayList<Integer> buildHeap(ArrayList<Integer> arr) {
        int firstParentIndex = (arr.size() - 2) / 2;
        for (int i = firstParentIndex; i >= 0; i--) {
            shiftDown(i, arr.size() - 1);
        }
        return arr;
    }

    public void insert(int value) {
        minHeap.add(value);
        shiftUp(minHeap.size() - 1);
    }

    public int delete() {
        if (minHeap.size() < 0) {
            return -1;
        }
        swap(0, minHeap.size() - 1);
        int value = minHeap.remove(minHeap.size() - 1);
        shiftDown(0, minHeap.size() - 1);
        return value;
    }

    private void shiftDown(int currentIndex, int endIndex) {
        int childOneIndex = 2 * currentIndex + 1;
        int indexToSwap;
        while (childOneIndex <= endIndex) {
            int childTwoIndex = 2 * currentIndex + 2 <= endIndex ? 2 * currentIndex + 2 : -1;
            if (childTwoIndex != -1 && minHeap.get(childTwoIndex) < minHeap.get(childOneIndex)) {
                indexToSwap = childTwoIndex;
            } else {
                indexToSwap = childOneIndex;
            }
            if (minHeap.get(indexToSwap) < minHeap.get(currentIndex)) {
                swap(indexToSwap, currentIndex);
                currentIndex = indexToSwap;
                childOneIndex = 2 * currentIndex + 1;
            } else {
                break;
            }
        }
    }

    private void shiftUp(int currentIndex) {
        int parentIndex = (currentIndex - 1) / 2;
        while (currentIndex > 0 && minHeap.get(currentIndex) < minHeap.get(parentIndex)) {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }
    }

    public int peek() {
        return minHeap.size() > 0 ? minHeap.get(0) : -1;
    }

    private void swap(int i, int j) {
        Collections.swap(minHeap, i, j);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(30);
        arr.add(102);
        arr.add(23);
        arr.add(17);
        arr.add(18);
        arr.add(9);
        arr.add(44);
        arr.add(12);
        MinHeap minHeap = new MinHeap(arr);
        System.out.println(minHeap.peek());
        for (int value : minHeap.minHeap) {
            System.out.print(value + " ");
        }
    }
}