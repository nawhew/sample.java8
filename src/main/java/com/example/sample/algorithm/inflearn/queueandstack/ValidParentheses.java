package com.example.sample.algorithm.inflearn.queueandstack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("[]{}()"));
        System.out.println(isValid("[{}]"));
        System.out.println(isValid("[}()"));
        System.out.println(isValid("[{}()"));
    }

    public static boolean isValid(String inputs) {

        if(inputs.length() % 2 != 0) {
            return false;
        }

        Stack<String> brackets = new Stack<>();

        for (String input : inputs.split("")) {
            if(isOpenBracket(input)) {
                brackets.push(input);
                continue;
            }
            if(!matchedBracket(brackets.pop(), input)) {
                return false;
            }
        }

        if(brackets.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isOpenBracket(String bracket) {
        return bracket.equals("[") || bracket.equals("{") || bracket.equals("(");
    }

    public static boolean matchedBracket(String before, String current) {
        if((before.equals("[") && current.equals("]"))
            || before.equals("{") && current.equals("}")
            || before.equals("(") && current.equals(")")) {
            return true;
        }
        return false;
    }
}