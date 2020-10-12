package com.example.sample.java8.stream;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OnlineClassTest {

    static List<OnlineClass> springClasses = new ArrayList<>();
    static List<OnlineClass> javaClasses = new ArrayList<>();

    @BeforeAll
    public static void setList() {
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));
        System.out.println("set spring class data.");

        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));
        System.out.println("set java class data.");
    }

    @Test
    public void stream() {

        System.out.println("1. 스프링 강좌 중 spring으로 시작하는 수업");
        springClasses.stream()
                    .filter(oc -> oc.getTitle().startsWith("spring"))
//                    .forEach(System.out::println);
                    .forEach(oc -> System.out.println("title : " + oc.getTitle()));

        System.out.println("2. 스프링 강좌 중 close 되지 않은 수업");
        springClasses.stream()
                    //.filter(oc -> !oc.isClosed()) // 조금 더 간단하게 줄이면 OnlineClass에 있는 isClosed를 바로 사용한다
                    //.filter(!OnlineClass::isClosed) //이 방법은 불가능. not은 아래와 같이 처리해주어야 함
                    .filter(Predicate.not(OnlineClass::isClosed)) // 불특정 인스턴스의 메소드 레퍼런스 사용 예제
                    .forEach(System.out::println);

        System.out.println("3. 스프링 강좌 중 수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                    //.map(oc -> oc.getTitle()) // 중계형 map을 사용하여 OnlineClass로 들어온 값을 String으로 반환해준다.
                    .map(OnlineClass::getTitle)
                    .forEach(System.out::println); // 여기서는 String으로 받은 Title이 찍히게 됨.

        System.out.println("4. 두 수업 목록에 들어 있는 모든 수업 아이디 출력");
        List<List<OnlineClass>> onlineEvents = new ArrayList<>();
        onlineEvents.add(springClasses);
        onlineEvents.add(javaClasses);

        onlineEvents.stream()
                    //.flatMap(list -> list.stream())  // 특수한 형태의 map오퍼레이션으로 안에 있는 데이터를 flatting 시킨다
                    .flatMap(Collection::stream)       // 즉 두개의 컬렉션에 담긴 OnlineClass로 쭉 펴줌
                    .map(OnlineClass::getId)
                    .forEach(System.out::println);
        

        System.out.println("5. 10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개까지만");
        Stream.iterate(10, i -> i + 1) //Stream에서 제공하는 static 중계형 오퍼레이션
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("6. 자바 수업 중에 Test가 들어 있는 수업이 있는지 확인");
        boolean containsTest = javaClasses.stream()
                    .anyMatch(oc -> oc.getTitle().contains("Test")); // match 종료형
        System.out.println(containsTest);

        System.out.println("7. 스프링 수업 중에 제목에 spring이 들어 간 제목만 모아서 List로 만들기");
        List<String> springTitles =
                springClasses.stream()
                            .filter(oc -> oc.getTitle().contains("spring"))
                            .map(OnlineClass::getTitle)
                            .collect(Collectors.toList())
                            ;
        springTitles.stream()
                    .forEach(System.out::println);
    }

}