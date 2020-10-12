package com.example.sample.java8.optional;

import com.example.sample.java8.stream.OnlineClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {

    static List<OnlineClass> springClasses = new ArrayList<>();
    static List<OnlineClass> javaClasses = new ArrayList<>();

//    @BeforeAll
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

    public static void main(String[] args) {

        setList();

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        System.out.println("스프링으로 시작하는 강의가 있습니까? : " + spring.isPresent());

        Optional<OnlineClass> jpa = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        System.out.println("JPA으로 시작하는 강의가 없습니까? : " + jpa.isEmpty()); //java 11

        OnlineClass ocSpring = spring.get(); // 있을 때는 상관 없지만
        System.out.println(ocSpring);

        // 없는 경우에는 RuntimeException 발생 (NoSuchElementException)
        try {
            OnlineClass ocJpa = jpa.get();  // <- 여기서 오류 발생
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(ocJpa);
        //그래서 그냥 꺼내지 말고 isPresent()를 사용 한 후 꺼내거나
        //Optional에서 제공하는 다른 메소드를 사용해서 꺼내기. 아래와 같이.
        jpa.ifPresent(oc -> System.out.println(oc.getTitle())); // 있는 경우에만 출력해라

        // 꼭 인스턴스를 꺼내 와야겠다면
        // 있으면 리턴 없으면 ()안에 인스턴스를 넣어 주어야 함 (보통 메소드 호출해서 처리)
        // FunctionalInterface가 아니라 해당 인스턴스를 파라미터로 넣어 주어야함.
        OnlineClass jpa_new_class = jpa.orElse(new OnlineClass(10, "jpa new class", true));

        // orElse는 있건 없건 무조건 파라미터에 넣어주는 인스턴스를 생성/가지고 와야한다.
        // 없는 경우에만 생성하고 싶다면 아래의 메소드 사용
        OnlineClass jpa_new_class2 =
                jpa.orElseGet(() -> new OnlineClass(10, "jpa new class", true));

        // 결국 orElse는 상수로 만들어 진 것을 넣어 줄 때 적합하고
        // orElseGet은 동적으로 인스턴스를 만들어서 넣어 주어야 할 때 적합.


        // 그리고 만들어 줄 수 없을 때는 오류를 던져 줄 수 있다
        try {
            OnlineClass jpa_new_class3 = jpa.orElseThrow(); // RuntimeException 발생 (NoSuchElementException)
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
//        OnlineClass jpa_new_class4 = jpa.orElseThrow(() -> new NullPointerException("JPA강의가 없습니다")); // 원하는 Exception 던지기
            OnlineClass jpa_new_class5 = jpa.orElseThrow(NullPointerException::new);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // 있다는 가정하에 처리 (없는 경우 처리 안함)
        Optional<OnlineClass> onlineClass = spring.filter(oc -> oc.getId() > 5);
        System.out.println("Id가 5보다 큰 온라인클래스가 없습니까? " + onlineClass.isEmpty());

        // map도 Optional로 리턴해준다.
        Optional<Integer> optionalInteger = onlineClass.map(OnlineClass::getId);
        System.out.println(optionalInteger.isPresent());

        // flatMap을 사용하면 Optional이 이중으로 감싸져 있는 경우 안에 있는 옵셔널에서 객체를 꺼내와준다.
        // stream의 flatMap과 조금 다르다
        Optional<Optional<OnlineClass>> doubleOptional = onlineClass.map(oc -> Optional.of(oc));
        Optional<OnlineClass> flatmapOptional = onlineClass.flatMap(oc -> Optional.of(oc));

    }
}
