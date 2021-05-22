package com.example.sample.algorithm.inflearn.stringandarray;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRoom2 {

    public static void main(String[] args) {
        MeetingRoom2 meetingRoom = new MeetingRoom2();
        System.out.println("result : " + meetingRoom.solve(new int[][]{{0,30}, {15,20}, {5,10}}));
        System.out.println("result : " + meetingRoom.solve(new int[][]{{7,10}, {2,4}}));
        System.out.println("result : " + meetingRoom.solve(new int[][]{{0,30}, {15,20}, {5,10}, {8, 13}}));
        System.out.println("result : " + meetingRoom.solve(new int[][]{{0,30}, {15,20}, {5,10}, {25, 30}}));
    }

    public int solve(int[][] inputs) {
        List<Interval> intervals = this.changeInterval(inputs);
        intervals.sort(this.compInterval);
        int roomCount = 1;

        for (int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i-1).end > intervals.get(i).start) {
                roomCount++;
            }
        }

        return roomCount;
    }


    private List<Interval> changeInterval(int[][] inputs) {
        List<Interval> intervals = new ArrayList<>();
        for (int[] input : inputs) {
            intervals.add(new Interval(input[0], input[1]));
        }
        return intervals;
    }

    Comparator<Interval> compInterval = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start; // asc
        }
    };

    @Getter @Setter @AllArgsConstructor @ToString
    class Interval {
        int start;
        int end;
    }
}
