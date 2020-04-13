package com.balancedBrackets.java;

import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        String str = "({[]}))";
        System.out.println(balancedBrackets(str));
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
}