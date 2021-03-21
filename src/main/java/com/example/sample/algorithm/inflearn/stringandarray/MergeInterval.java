package com.example.sample.algorithm.inflearn.stringandarray;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {
        Interval[] result = solve(new int[][] {{1,3}, {2,6}, {8, 10}, {15, 18}});
        System.out.println("result : " + Arrays.toString(result));
    }

    private static Interval[] solve(int[][] inputs) {

        List<Interval> intervals = createInterval(inputs);
        List<Interval> result = new ArrayList<>();
        intervals.sort(intervalComparator);
        System.out.println(intervals);

        Interval before = intervals.get(0);
        for (int index = 1; index < intervals.size(); index++) {
            Interval current = intervals.get(index);

            if(before.end >= current.start) {
                before.end = Math.max(before.end, current.end);
                continue;
            }
            result.add(before);
            before = current;
        }

        if(!result.contains(intervals.get(intervals.size() -1))) {
            result.add(intervals.get(intervals.size()-1));
        }

        return result.toArray(new Interval[result.size()]);
    }

    static Comparator<Interval> intervalComparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    };

    private static List<Interval> createInterval(int[][] inputs) {
        List<Interval> intervals = new ArrayList<>();
        for(int[] input : inputs) {
            intervals.add(new Interval(input));
        }
        return intervals;
    }
}

@Getter @AllArgsConstructor @ToString
class Interval {
    int start;
    int end;

    public Interval(int[] input) {
        this(input[0], input[1]);
    }
}
