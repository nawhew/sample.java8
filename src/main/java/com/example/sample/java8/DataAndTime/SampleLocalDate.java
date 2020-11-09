package com.example.sample.java8.DataAndTime;

import java.time.LocalDate;

public class SampleLocalDate {

    /**
     * immutable example.
     * @return
     */
    public LocalDate getFirstBirth() {
        LocalDate localDate = LocalDate.of(2020, 11, 9);
        LocalDate firstBirth = localDate.plusYears(1);  // return new LocalDate instance

        return firstBirth;
    }
}
