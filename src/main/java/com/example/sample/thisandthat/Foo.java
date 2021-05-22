package com.example.sample.thisandthat;

import java.util.PriorityQueue;

public class Foo {
    public static void main(String[] args) {

        PriorityQueue<Proc> procs = new PriorityQueue<>((o1, o2) -> o1.request - o2.request);
        int[][] jobs = new int[][]{{0,3}, {1,9}, {2,6}};
        for (int[] job : jobs) {
            procs.add(new Proc(job[0], job[1]));
        }



    }

}

class Proc {
    int request;
    int workingTime;
    int startTime;
    int endTime;

    public Proc(int request, int workingTime) {
        this.request = request;
        this.workingTime = workingTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
        this.endTime = this.startTime + this.workingTime;
    }

    public int realWorkingTime() {
        return this.endTime - this.startTime;
    }
}