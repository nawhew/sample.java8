package com.example.sample.algorithm.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicRotation {
    private static final int ROTATE_DEFAULT_COUNT = 1;

    public static List<Integer> rotate(List<Integer> inputs) {
        return CyclicRotation.rotate(inputs, CyclicRotation.ROTATE_DEFAULT_COUNT);
    }

    /**
     * 배열의 요소를 주어진 수만큼 순환 이동 시킵니다
     * @param inputs
     * @param count
     * @return
     */
    public static List<Integer> rotate(List<Integer> inputs, int count) {
        int inputsSize = inputs.size();
        List<Integer> outputs = new ArrayList<>(inputsSize);

        for (int i = 0; i < inputsSize; i++) {
            int index = (i + count - CyclicRotation.ROTATE_DEFAULT_COUNT) % inputsSize;
            System.out.println("index: " + index);
            outputs.add(inputs.get(index));
        }

        return outputs;
    }

    public static void main(String[] args) {
        System.out.println(CyclicRotation.rotate(
                Arrays.asList(3, 8, 9, 7, 6), 1
        ));
    }
}
