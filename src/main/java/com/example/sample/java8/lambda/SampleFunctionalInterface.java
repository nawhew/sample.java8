package com.example.sample.java8.lambda;

@FunctionalInterface
public interface SampleFunctionalInterface {
    // Functional interface have one abstract method
    void doIt();

    static void staticMethod() {
        System.out.println("java 8 interface can used static method.");
    }

    default void defaultMethod() {
        System.out.println("java 8 interface can used default method.");
    }
}
