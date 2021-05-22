package com.example.sample.algorithm.inflearn2.string;

import java.util.*;

public class 중복문자제거 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println(solution(in.nextLine()));
    }

    public static String solution(String input) {
        String answer = null;
        StringBuilder sb = new StringBuilder();
        Set<Character> chars = new HashSet<>();

        for (char unit : input.toCharArray()) {
            if(!chars.contains(unit)) {
                chars.add(unit);
                sb.append(unit);
            }
        }

        return sb.toString();
    }
}
