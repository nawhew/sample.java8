package com.example.sample.algorithm.codility;

import org.springframework.util.StopWatch;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class FrogRiverOne {

    public static int solution(int[] inputs, int destination) {
        Set<Integer> coordinates = new HashSet<>();
        IntStream.range(1, destination);
        int i = 0;
        for (int input : inputs) {
            if(input <= destination) {
                coordinates.add(input);
            }
            if(coordinates.size() == destination) {
                break;
            }
            i++;
        }
        if(coordinates.size() < destination) {
            return -1;
        }
        return i;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(FrogRiverOne.solution(new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 5));
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());;
    }
}
