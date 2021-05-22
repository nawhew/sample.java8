package com.example.sample.algorithm.inflearn2.string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 특정문자뒤집기 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println(solution(in.nextLine()));
    }

    public static String solution(String input) {
        return reverse(input);
    }

    public static boolean isAlphabet(char unit) {
        return (unit >= 65 && unit <= 90)
                || (unit >= 97 && unit <= 122);
    }

    public static String reverse(String unit) {
        Stack<Character> chars = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char character : unit.toCharArray()) {
            if(isAlphabet(character)) {
                chars.push(character);
            }
        }

        for (char character : unit.toCharArray()) {
            if(isAlphabet(character)) {
                sb.append(chars.pop());
                continue;
            }
            sb.append(character);
        }

        return sb.toString();
    }
}
