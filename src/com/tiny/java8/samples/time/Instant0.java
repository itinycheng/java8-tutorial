package com.tiny.java8.samples.time;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

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
        boolean before = epoch.isBefore(min);
        boolean after = epoch.isAfter(max);
        Instant plus = epoch.plus(1, ChronoUnit.DAYS);
        Instant plus1 = epoch.plus(Duration.ofDays(1).plusHours(1));
        Instant plus2 = epoch.plus(Duration.ofDays(-1).plusHours(-1));
        Instant minus = epoch.minus(Duration.ofDays(1).plusHours(1));
        // TODO
        // epoch.range(ChronoField.PROLEPTIC_MONTH);
        // epoch.adjustInto()
        // epoch.query(temporal -> )
        // epoch.until(ChronoUnit.DAYS, IsoFields.WEEK_BASED_YEARS);
        // epoch.with(temporal -> )
        // epoch.truncatedTo()
        long l = epoch.toEpochMilli();
        long epochSecond = epoch.getEpochSecond();
        int nano1 = epoch.getNano();
        OffsetDateTime offsetDateTime = epoch.atOffset(ZoneOffset.ofHours(1));
        ZonedDateTime time = epoch.atZone(ZoneId.systemDefault());
        OffsetDateTime offsetDateTime1 = epoch.atOffset(ZoneOffset.ofHours(18));
        System.out.println(Instant.now());
    }
}
