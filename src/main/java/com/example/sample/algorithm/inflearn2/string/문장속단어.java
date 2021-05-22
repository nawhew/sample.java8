package com.example.sample.algorithm.inflearn2.string;

import java.util.Scanner;

public class 문장속단어 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
    }

    public static String solution(String input) {
        String answer = null;

        int maxLength = 0;
        for(String unit : input.split(" ")) {
            if(unit.length() > maxLength) {
                maxLength = unit.length();
                answer = unit;
            }
        }
        return answer;
    }
}
