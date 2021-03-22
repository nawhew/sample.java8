package com.example.sample.algorithm.inflearn.stringandarray;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinct {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("cacbbb"));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {

        Map<String, Integer> unitCount = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int max = 0, index = 0, start = 0;
        String[] splitString = s.split("");
        for (String unit : splitString) {
            if(unitCount.containsKey(unit)) {
               unitCount.put(unit, unitCount.get(unit) + 1);
            } else {
                while (unitCount.size() >= 2) {
                    String temp = splitString[start];
                    unitCount.put(temp, unitCount.get(temp) - 1);
                    if(unitCount.get(temp) == 0) {
                        unitCount.remove(temp);
                    }
                    start++;
                }
                unitCount.put(unit, 1);
            }
            index++;
            max = Math.max(max, index - start);
        }
        return max;
    }

    public static int lengthOfLongestSubstringTwoDistinct2(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int start = 0, end = 0, counter = 0, len = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) == 1) counter++;//new char
            end++;
            while(counter > 2){
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);
                if(map.get(cTemp) == 0){
                    counter--;
                }
                start++;
            }
            len = Math.max(len, end-start);
        }
        return len;
    }
}
