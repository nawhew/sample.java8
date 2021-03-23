package com.example.sample.algorithm.inflearn.queueandstack;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        // C : clear last unit
        // D : double last unit
        // + : added last 2 unit
        String[] strs = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(strs));
    }
    public static int calPoints(String[] ops) {
        Stack<Integer> result = new Stack<>();
        Integer sum = 0;

        for (String operator : ops) {
            Integer operatedValue = operate(operator, result);
            if(operatedValue != null) {
                result.push(operatedValue);
            }
        }

        // sum stack
//        for (Integer unit : result) {
//            sum += unit;
//        }

        // other
        while(!result.isEmpty()) {
            sum += result.pop();
        }

        return sum;
    }

    public static Integer operate(String unit, Stack<Integer> result) {
        if(isNumber(unit)) {
            return Integer.parseInt(unit);
        }

        if(unit.equals("C")) {
            result.pop();
            return null;
        }

        if(unit.equals("D")) {
            return result.peek() * 2;
        }

        if(unit.equals("+")) {
            Integer popValue = result.pop();
            Integer peekValue = result.peek();
            result.push(popValue);
            return popValue + peekValue;
        }

        return null;
    }

    private static boolean isNumber(String unit) {
        try {
            Integer.parseInt(unit);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
