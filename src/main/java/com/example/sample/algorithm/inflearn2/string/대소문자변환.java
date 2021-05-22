package com.example.sample.algorithm.inflearn2.string;

import java.util.Scanner;

public class 대소문자변환 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
    }

    public static String solution(String input) {
        String answer = null;
        StringBuilder sb = new StringBuilder();

        for (char unit : input.toCharArray()) {
            if(unit >= 65 && unit <= 90) {
                sb.append((char) (unit + 32));
            } else if(unit >= 97 && unit <= 122) {
                sb.append((char) (unit - 32));
            }
        }
        return sb.toString();
    }
}
