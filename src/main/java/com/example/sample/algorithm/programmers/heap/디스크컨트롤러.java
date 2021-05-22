package com.example.sample.algorithm.programmers.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class 디스크컨트롤러 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("result : " + solution.solution(new int[][]{{0,3}, {1,9}, {2,6}}));
    }

}
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Proc> procs = new PriorityQueue<>((o1, o2) -> o1.request - o2.request);
        for (int[] job : jobs) {
            procs.add(new Proc(job[0], job[1]));
        }

        List<Proc> endProces = new ArrayList<>();
        Proc firstProc = procs.poll();
        firstProc.setStartTime(firstProc.request);
        int realTime = firstProc.endTime;
        endProces.add(firstProc);

        while(!procs.isEmpty()) {
            int finalRealTime = realTime;
            Proc nextProc = procs.stream()
                    .filter(proc -> proc.request <= finalRealTime)
//                    .min((o1, o2) -> o1.workingTime - o2.workingTime)
//                    .get();
                    .findFirst().get();
            procs.remove(nextProc);
            nextProc.setStartTime(realTime);
            realTime = nextProc.endTime;
            endProces.add(nextProc);
            System.out.println(nextProc);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        AtomicInteger sum = new AtomicInteger(0);
        endProces.stream().forEach(proc -> sum.set(sum.get() + proc.endTime - proc.request));

        return sum.get() / jobs.length;
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

    @Override
    public String toString() {
        return "Proc{" +
                "request=" + request +
                ", workingTime=" + workingTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}