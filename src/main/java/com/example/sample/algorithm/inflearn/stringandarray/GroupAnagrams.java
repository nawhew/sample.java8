package com.example.sample.algorithm.inflearn.stringandarray;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(list));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<Set<String>, List<String>> tempResult = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String anagram : strs) {
            Set<String> key = Arrays.stream(anagram.split("")).collect(Collectors.toSet());

            List<String> group = tempResult.getOrDefault(key, new ArrayList<>());
            group.add(anagram);
            tempResult.put(key, group);
        }

        // map to list
        for (Set<String> key : tempResult.keySet()) {
            result.add(tempResult.get(key));
        }

        return result;
    }

}
