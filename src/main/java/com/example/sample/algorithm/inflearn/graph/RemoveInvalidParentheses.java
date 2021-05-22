package com.example.sample.algorithm.inflearn.graph;

//import com.example.sample.algorithm.programmers.graph.Solution;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RemoveInvalidParentheses {

    public static void main(String[] args) {

        System.out.println("A".compareTo("B"));
        System.out.println("B".compareTo("A"));
        System.out.println("33".compareTo("30"));
    }
    public int[] solution(int[] answers) {
        int[] answer = {};
        return answer;
    }
}
class Doc{
    int a;
    boolean b;

    public Doc(int a, boolean b) {
        this.a = a;
        this.b = b;
    }
}

enum Student {

    s1 (1, new int[]{1,2,3,4,5})
    , s2 (2, new int[]{2,1,2,3,2,4,2,5})
    , s3 (3, new int[]{3,3,1,1,2,2,4,4,5,5})
    ;

    private final int number;
    private final int[] numbers;
    private final Queue<Integer> answers = new LinkedList<>();
    private int score;

    Student(int number, int[] numbers) {
        this.number = number;
        this.numbers = numbers;
        this.makeAnswers();
    }

    public int getScore() {
        return score;
    }

    public int getNumber() {
        return number;
    }

    private void makeAnswers() {
        for (int number : this.numbers) {
            this.answers.offer(number);
        }
    }

    static int[] getHighScoreStudent(int[] answers) {
        Arrays.stream(Student.values()).forEach(student -> student.matchNumbers(answers));
        int max = Arrays.stream(Student.values()).mapToInt(Student::getScore).max().orElse(0);
        return Arrays.stream(Student.values())
                .filter(student -> student.getScore() == max)
                .mapToInt(Student::getNumber)
                .toArray();
    }

    private void matchNumbers(int[] answers) {
        for (int i = 0; i < answers.length; i++) {
            Integer answer = this.answers.poll();
            if(answers[i] == answer) {
                this.score++;
            }
            this.answers.offer(answer);
        }
    }
}

class Solution {
    public String solution(String number, int k) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        // first number
        String[] numbers = number.split("");
        int maxNumber = this.findMaxNumber(numbers, k, 0);
        sb.append(maxNumber);
        int index = number.indexOf(String.valueOf(maxNumber));
        int removeCount = index;

        // find next
        // 4177252841  7 -2 7 -3
        while(removeCount < k) {
            System.out.println("k: " + k + " , rm: " + removeCount + ", idx: " + index);
            maxNumber = this.findMaxNumber(numbers, number.length() - removeCount, index + 1);

            System.out.println("idx: " + index + ", new number: " + number.substring(index + 1)
                    + ", new idx: " + number.substring(index + 1).indexOf(String.valueOf(maxNumber))
                    + ", max: " + maxNumber);

            index = index + 1 + number.substring(index + 1).indexOf(String.valueOf(maxNumber));
            removeCount++;
            sb.append(maxNumber);
            System.out.println("str: " + sb.toString());
        }

        List<Integer> lists = new ArrayList<>();
        int[] ints = lists.stream().mapToInt(Integer::intValue).toArray();


        return sb.toString();
    }

    public int findMaxNumber(String[] numbers, int k, int startIndex) {
        int max = 0;
        for(int i = startIndex; i < numbers.length - k -1; i++) {
            max = Math.max(max, Integer.parseInt(numbers[i]));
        }
        return max;
    }
}