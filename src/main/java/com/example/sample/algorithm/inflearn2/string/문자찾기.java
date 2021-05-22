package com.example.sample.algorithm.inflearn2.string;

import java.util.Scanner;

public class 문자찾기 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println(solution(in.nextLine(), in.nextLine()));
        return ;
    }

    private static int solution(String input1, String input2) {
        int answer = 0;

        String origin = input1.toUpperCase();
        String find = input2.toUpperCase();
        while (origin.contains(find) ) {
            answer++;
            origin = origin.substring(origin.indexOf(find) + find.length());
        }
        return answer;
    }
}
