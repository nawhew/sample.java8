package com.example.sample.algorithm.inflearn.stringandarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }

    public static Integer[] plusOne(int[] digits) {
        if(digits[digits.length-1] != 9) {
            digits[digits.length-1]++;
            return Arrays.stream(digits).boxed().toArray(Integer[]::new);
        }

        StringBuilder digitSum = new StringBuilder();
        for (int digit : digits) {
            digitSum.append(digit);
        }

        String addedNumber = (Integer.parseInt(digitSum.toString()) + 1) + "";

        List<Integer> digitList = new ArrayList<>();
        for (String digit : addedNumber.split("")) {
            digitList.add(Integer.parseInt(digit));
        }
        return digitList.toArray(new Integer[0]);
    }

    public static int[] plusOne2(int[] digits) {
        int index = digits.length - 1;
        int carry = 1;

        while(index >= 0 && carry > 0) {
            digits[index] = (digits[index] + 1) % 10;

            if(digits[index] == 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            index++;
        }

        if(carry == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }
}
