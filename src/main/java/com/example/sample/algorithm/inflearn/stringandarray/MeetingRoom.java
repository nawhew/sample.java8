package com.example.sample.algorithm.inflearn.stringandarray;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

public class MeetingRoom {

    public static void main(String[] args) {
        MeetingRoom meetingRoom = new MeetingRoom();
        System.out.println("result : " + meetingRoom.solve(new int[][]{{0,30}, {15,20}, {5,10}}));
        System.out.println("result : " + meetingRoom.solve(new int[][]{{7,10}, {2,4}}));
    }

    public boolean solve(int[][] inputs) {
        List<Interval> intervals = this.changeInterval(inputs);

        intervals.sort(this.compInterval);

        for (int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i-1).end > intervals.get(i).start) {
                return false;
            }
        }

        return true;
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
