package com.example.sample.algorithm.programmers.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Hindex {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{3, 0, 6, 1, 5}));;
    }
}

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int pickSum = 0;

        PriorityQueue<Integer> sortedCitations = new PriorityQueue<>();
        Arrays.stream(citations).forEach(sortedCitations::add);

        while (!sortedCitations.isEmpty()) {
            int citation = sortedCitations.poll();
            if(sortedCitations.size() + 1 >= citation && pickSum <= citation) {
                answer = citation;
            }
            pickSum += citation;
        }
        return answer;
    }
}
