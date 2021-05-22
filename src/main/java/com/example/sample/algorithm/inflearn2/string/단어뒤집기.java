package com.example.sample.algorithm.inflearn2.string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 단어뒤집기 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        String[] input = new String[size];
        for (int i = 0; i < size; i++) {
            input[i] = in.nextLine();
        }

        Arrays.stream(solution(input)).forEach(System.out::println);
    }

    public static String[] solution(String[] input) {
        String answer = null;

        for (int i = 0; i < input.length; i++) {
            input[i] = reverse(input[i]);
        }

        return input;
    }

    public static String reverse(String unit) {
        Stack<Character> chars = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char character : unit.toCharArray()) {
             chars.push(character);
        }

        while (!chars.isEmpty()) {
            sb.append(chars.pop());
        }

        return sb.toString();
    }
}
