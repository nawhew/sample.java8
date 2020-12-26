package com.example.sample.algorithm.codility;

import java.util.Arrays;

public class MaxCounters {

    private final int[] counters;

    public MaxCounters(int n) {
        this.counters = new int[n];
    }

    public static int[] solution(int[] indexes, int n) {

        MaxCounters maxCounters = new MaxCounters(n);

        for (int index : indexes) {
            if(index > n) {
                int max = Arrays.stream(maxCounters.counters).max().getAsInt();

                for (int i = 0; i < maxCounters.counters.length; i++) {
                    maxCounters.counters[i] = max;
                }
                continue;
            }
            maxCounters.counters[index-1]++;
        }

        return maxCounters.counters;
    }

    private static int increase(int input) {
        return input++;
    }

    public static void main(String[] args) {
        Arrays.stream(MaxCounters.solution(new int[]{3, 4, 4, 6, 1, 4, 4}, 5))
                .forEach(value -> System.out.println("value:" + value));
    }
}
