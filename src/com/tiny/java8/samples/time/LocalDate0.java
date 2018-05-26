package com.tiny.java8.samples.time;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.Era;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.Locale;

/**
 * @author tiny.wang
 */
public class LocalDate0 {
    public static void main(String[] args) {
        // static
        LocalDate now = LocalDate.now();
        LocalDate now1 = LocalDate.now(ZoneId.systemDefault());
        LocalDate now2 = LocalDate.now(Clock.systemDefaultZone());
        LocalDate of = LocalDate.of(1998, Month.JUNE, 1);
        LocalDate localDate0 = LocalDate.ofYearDay(2012, 75);
        LocalDate localDate1 = LocalDate.ofEpochDay(1);
        LocalDate parse = LocalDate.parse("2011-12-03");
        LocalDate parse1 = LocalDate.parse("2016-01-18", DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.CHINA));
        LocalDate max = LocalDate.MAX;
        LocalDate min = LocalDate.MIN;
        // left
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        int dayOfMonth = now.getDayOfMonth();
        int dayOfYear = now.getDayOfYear();
        Month month = now.getMonth();
        int year = now.getYear();
        IsoChronology chronology = now.getChronology();
        Era era = now.getEra();
        int i = now.get(ChronoField.ALIGNED_WEEK_OF_MONTH);
        LocalDate minus = now.minusDays(1);
        LocalDate minusMonths = now.minusMonths(1);
        LocalDate minusYears = now.minusYears(1);
        LocalDate plus = now.plusDays(1);
        LocalDate plusMonths = now.plusMonths(1);
        LocalDate plusYears = now.plusYears(1);
        LocalDate localDate = now.minusYears(1);
        int i1 = now.compareTo(max);
        boolean before = now.isBefore(max);
        boolean after = now.isAfter(max);
        String format = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        String format1 = now.format(DateTimeFormatter.ISO_WEEK_DATE);
        String format2 = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
//      now.range()
//      now.adjustInto()
        int i2 = now.lengthOfMonth();
        int i3 = now.lengthOfYear();
        boolean leapYear = now.isLeapYear();
        LocalDateTime localDateTime = now.atStartOfDay();
        ZonedDateTime zonedDateTime = now.atStartOfDay(ZoneId.systemDefault());
        LocalDateTime localDateTime1 = now.atTime(2, 23);
//      now.query()
//      now.until()
        ValueRange range = now.range(ChronoField.DAY_OF_MONTH);
        LocalDate with = now.with(ChronoField.DAY_OF_MONTH, 1);
        LocalDate localDate2 = now.withMonth(1);
        LocalDate localDate3 = now.withDayOfMonth(1);
        LocalDate localDate5 = now.withYear(1);
        LocalDate localDate6 = now.withDayOfYear(1);
        long l = now.toEpochDay();
        System.out.println(LocalDate.now());
    }
}
