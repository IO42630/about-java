package com.olexyn.about.java.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeDemo {

    public static void main(String... args) {

        LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        LocalDateTime nowDateTime = LocalDateTime.of(nowDate, nowTime);

        System.out.println(nowDateTime);

        nowDateTime = LocalDateTime.now();

        LocalDate someDate = LocalDate.of(2020, 4, 1);
        someDate = LocalDate.parse("2020-02-01"); // iso-8601

        Instant instant = Instant.now();
        instant.plus(1, ChronoUnit.DAYS);
        instant.plus(1, ChronoUnit.WEEKS);

        int br = 0;



    }
}
