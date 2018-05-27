package com.tiny.java8.samples.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalQueries;

/**
 * @author tiny.wang
 */
public class LocalTime0 {

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime now1 = LocalTime.now(ZoneId.systemDefault());
        LocalTime of = LocalTime.of(10, 12, 12);
        LocalTime localTime0 = LocalTime.ofSecondOfDay(60 * 60);
        LocalTime localTime1 = LocalTime.ofNanoOfDay(1_000_000_000);
        LocalTime parse = LocalTime.parse("09:12:43", DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTime max = LocalTime.MAX;
        LocalTime min = LocalTime.MIN;
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalTime noon = LocalTime.NOON;

        boolean before = max.isBefore(min);
        boolean after = max.isAfter(min);
        int i1 = max.compareTo(min);
        boolean supported = max.isSupported(ChronoField.DAY_OF_MONTH);
        int i = max.get(ChronoField.HOUR_OF_DAY);
        long aLong = max.getLong(ChronoField.NANO_OF_SECOND);
        int nano = max.getNano();
        int second = max.getSecond();
        int minute = max.getMinute();
        int hour = max.getHour();

        LocalTime localTime = max.minusNanos(1_000_000_000);
        LocalTime localTime2 = max.minusSeconds(1);
        LocalTime localTime3 = max.minusMinutes(1);
        LocalTime localTime4 = max.minusHours(1);
        LocalTime minus = max.minus(1, ChronoUnit.HOURS);
        LocalTime plus = max.plus(1, ChronoUnit.HOURS);
        LocalTime plus1 = max.plus(Duration.ofHours(1));
        LocalTime localTime5 = max.plusNanos(1_000_000_000);
        LocalTime localTime6 = max.plusSeconds(1);
        LocalTime localTime7 = max.plusMinutes(1);
        LocalTime localTime8 = max.plusHours(1);
        long l = max.toNanoOfDay();
        int i2 = max.toSecondOfDay();
        LocalTime localTime9 = max.truncatedTo(ChronoUnit.HOURS);
        LocalTime localTime14 = max.truncatedTo(ChronoUnit.MINUTES);
        LocalTime with = max.with(ChronoField.HOUR_OF_DAY, 22);
        LocalTime localTime10 = max.withHour(22);
        LocalTime localTime11 = max.withMinute(11);
        LocalTime localTime12 = max.withSecond(1);
        LocalTime localTime13 = max.withNano(1);

        LocalTime query = max.query(TemporalQueries.localTime());
        Chronology query1 = max.query(TemporalQueries.chronology());
        Integer query2 = max.query(temporal -> temporal.get(ChronoField.MINUTE_OF_DAY));

        Temporal temporal = max.adjustInto(now);
        long until = max.until(now, ChronoUnit.HOURS);
        OffsetTime time = max.atOffset(ZoneOffset.ofHours(1));
        LocalDateTime dateTime = max.atDate(LocalDate.now());
        System.out.println(LocalTime.now());
    }
}
