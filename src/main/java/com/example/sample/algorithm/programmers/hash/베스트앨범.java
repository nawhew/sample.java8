package com.example.sample.algorithm.programmers.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 베스트앨범 {
    public static void main(String[] args) {
        Solution_베스트앨범 solution = new Solution_베스트앨범();
        solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}
                        , new int[]{500, 600, 150, 800, 2500});
    }
}
class Solution_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> answers = new ArrayList<>();

        // 장르 별 플레이 수 합계
        Map<String, Integer> genrePlays = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            genrePlays.put(genre, genrePlays.getOrDefault(genre, 0) + plays[i]);
        }
        // 플레이 수 가 많은 장르부터 내림차순 정렬
        List<String> orderedGenres = genrePlays.entrySet().stream()
                                            .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                                            .map(Map.Entry::getKey)
                                            .collect(Collectors.toList());

        for (String gen : orderedGenres) {
            Map<Integer, Integer> indexPlays = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if(gen.equals(genres[i])) {
                    indexPlays.put(i, plays[i]);
                }
            }
            indexPlays.entrySet().stream()
                    .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                    .map(Map.Entry::getKey)
                    .limit(2)
                    .forEach(answers::add);
        }
        return answers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}