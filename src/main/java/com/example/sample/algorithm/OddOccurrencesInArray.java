package com.example.sample.algorithm;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

    public static int solution(int[] inputs) {
        Set<Integer> temp = new HashSet<>();
        for (int input : inputs) {
            if(temp.contains(input)) {
                temp.remove(input);
            } else {
                temp.add(input);
            }
        }
        return temp.iterator().next();
    }

    public static void main(String[] args) {
        System.out.println(OddOccurrencesInArray.solution(new int[] {9,3,9,3,9,7,9}));;
    }
}
