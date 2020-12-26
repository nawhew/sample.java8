package com.example.sample.algorithm.programmers.stackandqueue;

import java.util.Arrays;

public class 주식가격 {

    public static void main(String[] args) {
        Solution_주식가격 solution = new Solution_주식가격();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 1, 3})));;
    }
}

class Solution_주식가격 {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        int i, j;

        for (i = 0; i < length; i++) {
            for (j = i + 1; j < length; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}