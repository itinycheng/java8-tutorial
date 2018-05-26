package com.tiny.java8.samples.time;

import java.time.Clock;
import java.time.Instant;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * @author tiny.wang
 */
public class Instant0 {

    public static void main(String[] args) {
        Instant now = Instant.now();
        Instant now1 = Instant.now(Clock.system(ZoneId.systemDefault()));
        //TODO Instant.from(tmproral);
        Instant parse = Instant.parse("2007-12-03T10:15:30.00Z");
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        Instant instant1 = Instant.ofEpochSecond(System.currentTimeMillis() / 1000);
        Instant instant2 = Instant.ofEpochSecond(System.currentTimeMillis() / 1000, 324_000_000);
        Instant max = Instant.MAX;
        Instant min = Instant.MIN;
        Instant epoch = Instant.EPOCH;

        int i = max.compareTo(min);
        int nano = max.getNano();
        int i1 = epoch.get(ChronoField.NANO_OF_SECOND);
        long aLong = epoch.getLong(ChronoField.INSTANT_SECONDS);
        ZonedDateTime time = epoch.atZone(ZoneId.systemDefault());
        boolean before = epoch.isBefore(min);
        //todo add ，month
        epoch.plus(1, ChronoUnit.DAYS);
        System.out.println(Instant.now());
    }
}
