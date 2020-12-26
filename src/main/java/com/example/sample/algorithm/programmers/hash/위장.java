package com.example.sample.algorithm.programmers.hash;

import java.util.*;

public class 위장 {
    public static void main(String[] args) {
        Solution_위장 solution = new Solution_위장();
        System.out.println(solution.solution(new String[][]{
                {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}
        }));
    }
}

class Solution_위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            if(!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext()) {
            answer *= it.next().intValue()+1;
        }
        return answer - 1;
    }
}