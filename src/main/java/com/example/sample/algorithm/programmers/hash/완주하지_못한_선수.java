package com.example.sample.algorithm.programmers.hash;

import org.springframework.util.StopWatch;

import java.util.*;

public class 완주하지_못한_선수 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Solution_완주하지_못한_선수 solution = new Solution_완주하지_못한_선수();
        System.out.println(solution.solution(new String[]{"mislav", "stanko", "mislav", "ana"}
                                            , new String[]{"stanko", "mislav", "ana"}));;
        stopWatch.stop();
        System.out.println("solution task time : " + stopWatch.getTotalTimeSeconds());
    }
}

class Solution_완주하지_못한_선수 {

    public String solution(String[] participant, String[] completion) {
        return this.solutionB(participant, completion);
    }

    // 0.005 ~ 0.006
    // 중복 데이터에 대한 처리가 안됨!
    @Deprecated
    public String solutionA(String[] participant, String[] completion) {
        return Arrays.stream(participant)
                .filter(part -> Arrays.stream(completion).noneMatch(part::equals))
                .findFirst().get();
    }

    // 0.001 ~ 0.002
    public String solutionB(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> participants = new HashMap<>();
        for (String player : participant) {
            participants.put(player, participants.getOrDefault(player, 0) + 1);
        }
        for (String player : completion) {
            participants.put(player, participants.get(player) - 1);
        }

        for (String key : participants.keySet()) {
            if (participants.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}