package com.groupAnagrams.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] arr = {"go", "act", "flop", "tac", "cat", "og", "olfp"};
        groupAnagrams(arr);
    }

    public static void groupAnagrams(String[] arr) {
        HashMap<String, ArrayList<String>> anagrams = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String sortedWords = sortString(arr[i]);
            ArrayList<String> groups = anagrams.containsKey(sortedWords) ? anagrams.get(sortedWords) : new ArrayList<>();
            groups.add(arr[i]);
            anagrams.put(sortedWords, groups);
        }
        for (ArrayList<String> value : anagrams.values()) {
            for (int i = 0; i < value.size(); i++) {
                System.out.print(value.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static String sortString(String str) {
        char temp[] = str.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
}