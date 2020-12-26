package com.example.sample.algorithm.programmers.hash;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class 전화번호_목록 {

    public static void main(String[] args) {
        Solution_전화번호_목록 solution = new Solution_전화번호_목록();
        String[] case_false = {"119", "97674223", "1195524421"};
        String[] case_true = {"123", "456", "789"};
        System.out.println(solution.solution2(case_false));
    }
}

class Solution_전화번호_목록 {
    
    // 효율성 테스트 시간 초과
    @Deprecated
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> phoneNumbers = Arrays.stream(phone_book).collect(Collectors.toSet());

        for (String phoneNumber : phone_book) {
            if(phoneNumbers.stream().filter(s -> !s.equals(phoneNumber))
                    .anyMatch(s -> s.startsWith(phoneNumber))) {
                answer = false;
            }
        }
        return answer;
    }

    public boolean solution2(String[] phone_book) {
        boolean answer = true;

        for (String phoneNumber : phone_book) {
            for (String phoneNumber2 : phone_book) {
                if(phoneNumber.equals(phoneNumber2)) {
                    continue;
                }
                if (phoneNumber.startsWith(phoneNumber2)) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }

    // 대표 풀이
    public boolean solution3(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
}