package com.example.sample.java8.lambda;

import java.util.function.Function;

public class FunctionImpl implements Function<Integer, String> {

    @Override
    public String apply(Integer integer) {
        return integer + "";
    }
}
