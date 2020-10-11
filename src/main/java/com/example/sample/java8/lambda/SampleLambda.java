package com.example.sample.java8.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class SampleLambda {

    public static void main(String[] args) {

        FunctionImpl function = new FunctionImpl();
        log.debug(function.apply(10));

//        Function<Integer, String> function2 = (number) -> {return number + "!";};
        Function<Integer, String> function2 = (number) -> number + "!";
        log.debug(function2.apply(10));

    }

}
