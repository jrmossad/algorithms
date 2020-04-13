package com.balancedBrackets.java;

import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        String str = "({[]})";
        System.out.println(balancedBracketsClean(str));
    }

    public static boolean balancedBrackets(String str) {
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            switch (current) {
                case '{':
                case '(':
                case '[':
                    brackets.push(current);
                    break;
                case '}':
                    if (brackets.empty() || brackets.peek() != '{') {
                        return false;
                    } else {
                        brackets.pop();
                    }
                    break;
                case ')':
                    if (brackets.empty() || brackets.peek() != '(') {
                        return false;
                    } else {
                        brackets.pop();
                    }
                    break;
                case ']':
                    if (brackets.empty() || brackets.peek() != '[') {
                        return false;
                    } else {
                        brackets.pop();
                    }
                    break;
            }
        }
        return brackets.empty();
    }

    public static boolean balancedBracketsClean(String str) {
        Stack<Character> brackets = new Stack<>();
        String openingBrackets = "({[";
        String closingBrackets = ")}]";
        HashMap<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put('}', '{');
        matchingBrackets.put(']', '[');
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (openingBrackets.indexOf(current) != -1) {
                brackets.push(current);
            } else if ((closingBrackets.indexOf(current) != -1)) {
                if (brackets.empty() || brackets.peek() != matchingBrackets.get(current)) {
                    return false;
                } else {
                    brackets.pop();
                }
            }
        }
        return brackets.empty();
    }
}