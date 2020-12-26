package com.example.sample.algorithm.codility;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermMissingElements {

    /**
     * use AtomicInteger
     * @param inputs
     * @return
     */
    @Deprecated
    public static int solution(int[] inputs) {
        OptionalInt maxOptional = Arrays.stream(inputs).max();
        AtomicInteger max = new AtomicInteger();
        maxOptional.ifPresent(value -> max.set(value));

        List<Integer> inputIntegers = mapIntArrayToIntegerList(inputs);
        AtomicInteger result = new AtomicInteger();
        OptionalInt resultOptional = IntStream.range(1, max.get()).filter(value -> !inputIntegers.contains(value))
                .findFirst();

        resultOptional.ifPresent(value -> result.set(value));
        return result.get();
    }

    public static int solution2(int[] inputs) {
        int max = calculateMax(inputs);

        List<Integer> inputIntegers = mapIntArrayToIntegerList(inputs);
        OptionalInt resultOptional = IntStream.range(1, max)
                                            .filter(value -> !inputIntegers.contains(value))
                                            .findFirst();

        if(resultOptional.isPresent()) {
            return resultOptional.getAsInt();
        }
        return 0;
    }

    /**
     * int[] to List<Integer>
     * @param inputs
     * @return
     */
    private static List<Integer> mapIntArrayToIntegerList(int[] inputs) {
        return Arrays.stream(inputs)
                .mapToObj(String::valueOf)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    /**
     * 주어진 배열에서 최대값 계산
     * @param inputs 
     * @return
     */
    private static int calculateMax(int[] inputs) {
        OptionalInt maxOptional = Arrays.stream(inputs).max();
        int max = 0;
        if(maxOptional.isPresent()) {
            max = maxOptional.getAsInt();
        }
        return max;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(PermMissingElements.solution2(new int[]{1,2,5,4}));
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());;
    }
}
