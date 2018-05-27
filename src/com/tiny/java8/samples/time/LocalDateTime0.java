package com.tiny.java8.samples.time;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.Chronology;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author tiny.wang
 */
public class LocalDateTime0 {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now1 = LocalDateTime.now(ZoneId.systemDefault());
        LocalDateTime now2 = LocalDateTime.now(Clock.systemDefaultZone());
        LocalDateTime of = LocalDateTime.of(2017, Month.JULY, 31, 3, 4);
        LocalDateTime of1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime time = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDateTime z = LocalDateTime.ofEpochSecond(1, 1, ZoneOffset.of("Z"));
        LocalDateTime parse = LocalDateTime.parse("2019-01-02T22:22:33");
        LocalDateTime max = LocalDateTime.MAX;
        LocalDateTime min = LocalDateTime.MIN;

        // left
//        now.format()

        int i = now.get(ChronoField.HOUR_OF_DAY);
        long aLong = now.getLong(ChronoField.SECOND_OF_MINUTE);
        int year = now.getYear();
        Month month = now.getMonth();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        int dayOfMonth = now.getDayOfMonth();
        int dayOfYear = now.getDayOfYear();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        int nano = now.getNano();
        int monthValue = now.getMonthValue();
        Chronology chronology = now.getChronology();

        int i1 = now.compareTo(max);
        boolean before = now.isBefore(max);
        boolean after = now.isAfter(max);

        LocalDateTime localDateTime = now.truncatedTo(ChronoUnit.DAYS);
        LocalDateTime minus = now.minus(Duration.ofDays(1));
        LocalDateTime localDateTime1 = now.minusYears(1);
        LocalDateTime localDateTime2 = now.plusYears(1);
        LocalDateTime plus = now.plus(1, ChronoUnit.YEARS);
        LocalDateTime localDateTime3 = now.withHour(1);
        Instant instant = now.toInstant(ZoneOffset.of("+8"));
        Instant instant1 = now.toInstant(ZoneOffset.of("-8"));
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.of("+8"));
        LocalDate localDate = now.toLocalDate();
        LocalTime localTime = now.toLocalTime();
        ZonedDateTime ctt = now.atZone(ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime ctt1 = now.atZone(ZoneId.of("Asia/Shanghai"));
        // etc.
        System.out.println(LocalDateTime.now());
    }
}
