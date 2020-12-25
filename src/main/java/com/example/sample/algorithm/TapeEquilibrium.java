package com.example.sample.algorithm;

import java.util.Arrays;

public class TapeEquilibrium {

    public static int solution(int[] inputs) {
        int minValue = 0;
        int summary = 0;
        int restSummary = Arrays.stream(inputs).sum();

        for (int input : inputs) {
            summary += input;
            restSummary -= input;
            int summaryGap = Math.abs(summary - restSummary);
            if(minValue == 0 || minValue > summaryGap) {
                minValue = summaryGap;
            }
        }
        return minValue;
    }

    public static void main(String[] args) {
        System.out.println(TapeEquilibrium.solution(new int[]{3, 1, 2, 4, 3}));
    }
}
