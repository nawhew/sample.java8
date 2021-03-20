package com.example.sample.algorithm.etc;

import java.util.*;
import java.util.stream.Collectors;

public class StringFairSort {

    public static void main(String[] args) {
        List<Fair> fairs
                = Arrays.asList(new Fair("대야미역", "반월역")
                                , new Fair("산본역", "수리산역")
                                , new Fair("금정역", "산본역")
                                , new Fair("수리산역", "대야미역")
        );

        Set<String> heads = fairs.stream().map(Fair::getHead).collect(Collectors.toSet());
        Set<String> tails = fairs.stream().map(Fair::getTail).collect(Collectors.toSet());
        heads.removeAll(tails);

        String firstHead = heads.stream().findFirst().orElseGet(String::new);
        System.out.println(firstHead);

        List<Fair> orderedFair = new ArrayList<>();
        fairs.stream().filter(fair -> fair.getHead().equals(firstHead))
                .findFirst().ifPresent(orderedFair::add);

        for (int i = 0; i < fairs.size() - 1; i++) {
            String tail = orderedFair.get(i).getTail();
            fairs.stream().filter(fair -> fair.getHead().equals(tail))
                    .findFirst().ifPresent(orderedFair::add);
        }

        orderedFair.stream().forEach(System.out::println);

        List<String> all
        for (int i = 0; i < orderedFair.size(); i++) {

        }
    }
}

class Fair {
    String head;
    String tail;

    public Fair(String head, String tail) {
        this.head = head;
        this.tail = tail;
    }

    public String getHead() {
        return head;
    }

    public String getTail() {
        return tail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fair fair = (Fair) o;
        return Objects.equals(head, fair.head) &&
                Objects.equals(tail, fair.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail);
    }

    @Override
    public String toString() {
        return "Fair{" +
                "head='" + head + '\'' +
                ", tail='" + tail + '\'' +
                '}';
    }
}