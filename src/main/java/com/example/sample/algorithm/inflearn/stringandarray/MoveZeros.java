package com.example.sample.algorithm.inflearn.stringandarray;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] inputs = new int[]{0, 3, 2, 0, 8, 5};
        System.out.println(Arrays.toString(solve(inputs)));
        inputs = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(solve(inputs)));
    }

    public static int[] solve(int[] inputs) {

        int zeroIndex = 0;

        for (int i = 0; i < inputs.length; i++) {
            if(inputs[i] != 0) {
                inputs[zeroIndex++] = inputs[i];
            }
        }

        for (; zeroIndex < inputs.length; zeroIndex++) {
            inputs[zeroIndex] = 0;
        }

        return inputs;
    }
}
