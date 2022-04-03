package com.olexyn.about.java.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class PeriodDemo {

    public static void main(String... args){
        Period ok = Period.ofDays(3);
        Period nok = Period.ofMonths(1).ofWeeks(1);


        LocalDate localDate = LocalDate.now().plus(Period.ofDays(2));
        LocalTime localTime = LocalTime.now().plus(Period.ofDays(2));

        int br =0;
    }
}
