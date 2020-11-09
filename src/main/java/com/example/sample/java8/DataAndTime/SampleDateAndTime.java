package com.example.sample.java8.DataAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class SampleDateAndTime {

    /**
     * Sample to Instant : Time for Machine
     */
    public static void printMachineTime() {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.atZone(ZoneId.of("UTC")));

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("zone : " + zoneId);
        ZonedDateTime zonedDateTime = now.atZone(zoneId);
        System.out.println("get Instant to zone : " + zonedDateTime);
    }

    /**
     * Sample to LocalDateTime : time for Human
     */
    public static void printHumanTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("getNow : " + now);

        LocalDateTime ldt =
                LocalDateTime.of(2020, 11, 9, 0 , 0, 0);
        System.out.println("getOf : " + ldt);

        ZonedDateTime nowSeoul = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("getNow of Seoul : " + nowSeoul);

        // machine time to human time
        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.of("Asia/Seoul"));
        System.out.println("machine time to human time : " + zonedDateTime);
    }

    public static void printPeriod() {
        // given
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1990, 6, 19);

        Period between = Period.between(birthday, today);
        System.out.println("between : " + between.getDays());

        Period until = today.until(birthday);
        System.out.println("until : " + until.get(ChronoUnit.DAYS));
    }

    public static void printDuration() {
        // given
        Instant now = Instant.now();
        Instant end = now.plus(1000L, ChronoUnit.SECONDS);

        Duration between = Duration.between(now, end);
        System.out.println("between " + between.getSeconds());
    }

    public static void printForFormat() {
        DateTimeFormatter customFormatter =
                DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        LocalDate date = LocalDate.parse("07/15/1982", customFormatter);
        System.out.println("no format : " + date);
        System.out.println("use custom format : " + date.format(customFormatter));
        System.out.println("use ISO_DATE format : " + date.format(formatter));

        LocalDate parse = LocalDate.parse("09/11/20202", customFormatter);
        System.out.println("parsed String : " + parse);
    }

    public static void changeLegacyToNewTimes() {

        Date today = new Date();
        // Date to Instant
        Instant instant = today.toInstant();
        // Instant to Date
        Date newDate = today.from(instant);

        Calendar calendar = new GregorianCalendar();
        // Calendar to Instant
        Instant instant1 = calendar.toInstant();

        // ZoneId <-> TimeZone
        ZoneId newZoneAPI = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone legacyZoneAPI = TimeZone.getTimeZone(newZoneAPI);

        Instant newInstant = new Date().toInstant();
        Date legacyInstant = Date.from(newInstant);

    }

    public static void main(String[] args) {
        printForFormat();
    }
}
