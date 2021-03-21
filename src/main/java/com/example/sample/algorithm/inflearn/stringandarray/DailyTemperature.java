package com.example.sample.algorithm.inflearn.stringandarray;

import java.util.Arrays;

public class DailyTemperature {

    public static void main(String[] args) {
        int[] result = solve(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
        // result : [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(Arrays.toString(result));
    }

    private static int[] solve(int[] inputs) {

        int[] result = new int[inputs.length];
        for (int index = 0; index < inputs.length; index++) {
            int curNum = inputs[index];
            for (int j = index; j < inputs.length; j++) {
                int compNum = inputs[j];
                if(compNum > curNum) {
                    result[index] = j - index;
                    break;
                }
            }
        }
        return result;
    }
}
