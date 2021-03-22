package com.example.sample.algorithm.inflearn.stringandarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindAllAnagrams {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }

    public static List<Integer> findAnagrams(String txt, String pat) {
        List<Integer> indexes = new ArrayList<>();
        Set<String> pats = Arrays.stream(pat.split(""))
                .collect(Collectors.toSet());

        String[] texts = txt.split("");
        for (int i = pats.size() - 1; i < texts.length; i++) {
            String a = texts[i-2];
            String b = texts[i-1];
            String c = texts[i];
            if( !a.equals(b) && !b.equals(c) && !c.equals(a)
                    && pats.contains(a) && pats.contains(b) && pats.contains(c)) {
                indexes.add(i-2);
            }
        }
        return indexes;
    }

}