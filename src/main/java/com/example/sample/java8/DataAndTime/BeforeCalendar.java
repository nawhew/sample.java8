package com.example.sample.java8.DataAndTime;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class BeforeCalendar {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(1990, 6, 19);
        Calendar calendar2 = new GregorianCalendar(1990, Calendar.JULY, 19);
    }
}
