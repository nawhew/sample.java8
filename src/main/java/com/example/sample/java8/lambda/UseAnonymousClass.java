package com.example.sample.java8.lambda;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UseAnonymousClass {

    public static void beforeJava8() {
        SampleFunctionalInterface sfi = new SampleFunctionalInterface() {
            @Override
            public void doIt() {
                log.debug("before java 8. using anonymous class");
            }
        };
    }

    public static void afterJava8() {
        SampleFunctionalInterface sfi = () -> {
            log.debug("after java 8. using anonymous class for lambda");
        };

        SampleFunctionalInterface sfi2 = () -> log.debug("after java 8. using anonymous class for lambda");
    }

    public static void sampleLambda() {
        SampleFunctionalInterface sfi2 = () -> {};
        SampleParamFunctionalInterface spfi = (param) -> {return param + 10;};
    }
}
