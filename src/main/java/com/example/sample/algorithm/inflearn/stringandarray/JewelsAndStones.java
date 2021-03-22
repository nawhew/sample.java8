package com.example.sample.algorithm.inflearn.stringandarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public static void main(String[] args) {
        System.out.println(solve2("aA", "aAAbbBb"));
    }

    @Deprecated
    public static int solve(String jew, String stone) {
        Set<String> stones = new HashSet<>();

        // jew
        stones.add(jew);
        stone = stone.replace(jew, "");

        for (String oneStone : stone.split("")) {
            stones.add(oneStone);
            stone = stone.replace(oneStone, "");
        }
        return stones.size();
    }

    public static int solve2(String jew, String stone) {
        Set<String> jewStones = new HashSet<>();

        // jew
        jewStones.addAll(Arrays.asList(jew.split("")));

        // find jew stone
        int count = 0;
        for (String oneStone : stone.split("")) {
            if(jewStones.contains(oneStone)) {
                count++;
            }
        }
        return count;
    }
}
