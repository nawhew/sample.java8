package com.example.sample.algorithm.inflearn.stringandarray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solveToMap(new int[]{2, 7, 11, 15}, 9)));
    }

    private static int[] solve(int[] inputs, int target) {
        int index = 0;
        for (int number1 : inputs) {
            for (int i = index; i < inputs.length -1; i++) {
                int number2 = inputs[i];
                if(target == (number1 + number2)) {
                    return new int[]{index, i};
                }
            }
            index++;
        }
        return new int[] {0,0};
    }

    private static int[] solveToMap(int[] inputs, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i++) {
            int number = inputs[i];
            if(map.containsKey(number)) {
                result[0] = map.get(number);
                result[1] = i;
                break;
            }
            map.put(target - number, i);
        }
        return result;
    }
}
