package com.example.sample.java8.lambda;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {

    @Test
    void hi() {
        // test static method
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("we"));
    }

    @Test
    void hello() {
        // test instance method
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("wewe"));
    }

    @Test
    void constructor() {
        // test constructor
        Function<String, Greeting> greet = Greeting::new; // call string param constructor
        System.out.println(greet.apply("NEWGREET").getName());

        Supplier<Greeting> supplier = Greeting::new; // call no param constructor
        System.out.println(supplier.get().getName());
    }

}