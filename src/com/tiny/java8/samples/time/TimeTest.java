package com.tiny.java8.samples.time;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author tiny.wang
 */
public class TimeTest {

    /**
     * convert instant to date
     */
    @Test
    public void test0() {
        Instant now = Instant.now();
        Date from = Date.from(now);
        System.out.println(from);
    }

    /**
     * date to instant
     */
    @Test
    public void test1(){
        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println(instant);
    }

    /**
     * convert instant to other object
     */
    @Test
    public void test2() {
        Instant instant = Instant.now();
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.of("+8"));
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println("end");
    }

    @Test
    public void test3(){
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        ZonedDateTime now3 = ZonedDateTime.now();
        OffsetDateTime now4 = OffsetDateTime.now();

        Instant instant1 = now.atStartOfDay(ZoneId.of("Asia/Shanghai")).toInstant();
        Instant instant2 = now1.atDate(LocalDate.from(LocalDateTime.now())).toInstant(ZoneOffset.of("+9"));
        ZonedDateTime zonedDateTime = now.atStartOfDay(ZoneOffset.of("+8"));
        Instant instant = now2.toInstant(ZoneOffset.of("+8"));
        Instant from3 = Instant.from(now3);
        Instant from4 = Instant.from(now4);
        System.out.println("end");
    }

}
