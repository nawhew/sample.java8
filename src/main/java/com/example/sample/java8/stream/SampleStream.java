package com.example.sample.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SampleStream {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("we hwan");
        names.add("keesun");
        names.add("toby");

//        names.stream()
//             .filter(name -> name.length() > 4)
//             .forEach(System.out::println);


        Stream<String> stream = names.stream()
                .filter(name -> name.length() > 4)
                ;
        System.out.println("=============");
        stream.forEach(System.out::println);

    }
}
