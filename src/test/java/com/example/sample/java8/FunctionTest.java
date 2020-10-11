package com.example.sample.java8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.*;

@RunWith(SpringRunner.class)
public class FunctionTest {

    @Test
    public void function() {
        Function<Integer, Integer> add10 = param -> param + 10;
        Function<Integer, Integer> mul10 = param -> param * 10;

        System.out.println("call add 10 : " + add10.apply(2));
        System.out.println("call mul 10 : " + mul10.apply(2));

        System.out.println("call andThem : " + add10.andThen(mul10).apply(2)); // add10 >> mul10
        System.out.println("call compose : " + add10.compose(mul10).apply(2)); // mul10 >> add10
    }

    @Test
    public void other() {
        Consumer<String> consumer = (message) -> System.out.println(message);
        consumer.accept("no return!");

        Supplier<String> stringSupplier = () -> "i'm string-supplier";
        System.out.println("supplier : " + stringSupplier.get());

        Predicate<Integer> predicate = number -> number > 10;
        System.out.println("predicate1 : " + predicate.test(15));
        System.out.println("predicate2 : " + predicate.test(5));

        UnaryOperator<Integer> add10 = number -> number + 10;
        System.out.println("unaryOperator : " + add10.apply(10));
    }
}
