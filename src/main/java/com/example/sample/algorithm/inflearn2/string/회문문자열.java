package com.example.sample.algorithm.inflearn2.string;

import java.util.Scanner;
import java.util.Stack;

public class 회문문자열 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println(solution(in.nextLine()));
    }

    public static String solution(String input) {
        String answer = "NO";

        Stack<String> letter = new Stack<>();
        String[] strings = input.split("");
        letter.push(strings[0]);

        for (int i = 1; i < strings.length; i++) {
            String nowString = strings[i];
            if(letter.peek().equalsIgnoreCase(nowString)) {
                letter.pop();
            }
        }

        if(letter.size() == 0) {
            answer = "YES";
        }
        return answer;
    }
}
