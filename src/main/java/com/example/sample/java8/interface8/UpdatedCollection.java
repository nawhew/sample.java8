package com.example.sample.java8.interface8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class UpdatedCollection {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("we1");
        names.add("we2");
        names.add("we3");

        // for문을 간단하게 변경 가능
        names.forEach(System.out::println);
        names.forEach(name -> System.out.println("name : " + name));


        //이터레이터와 기본적으로 같은데.. split 기능이 있는 이터레이터이다.
        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator2 = spliterator.trySplit(); // 기존의 spliterator에서 반을 가지고 옴
        while (spliterator.tryAdvance(System.out::println)); // consumer를 넣어줌
        System.out.println("======위에는 spliterator1======");
        System.out.println("======아래는 spliterator2======");
        while (spliterator2.tryAdvance(System.out::println)); // consumer를 넣어줌


        System.out.println("=================");
        names.removeIf(name -> name.endsWith("3"));
        names.forEach(System.out::println);

        System.out.println("=================");
        names.sort(String::compareToIgnoreCase);
        names.forEach(System.out::println);

        System.out.println("=================");
        Comparator<String> comparator = String::compareToIgnoreCase;
        names.sort(comparator.reversed());
//        names.sort(comparator.reversed().thenComparing(Comparator)...);
        names.forEach(System.out::println);


    }
}
