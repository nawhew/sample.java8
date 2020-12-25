package com.example.sample.algorithm;

public class FrogJump {

    public static int solution(int x, int y, int distance) {
        if(x == y) {
            return 0;
        }

        int quotient = (y - x) / distance;
        if(((y - x) % distance) > 0) {
            quotient++;
        }
        return quotient;
    }

    public static void main(String[] args) {
        System.out.println(FrogJump.solution(10, 71, 30));
    }
}
