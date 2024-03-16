package org.java.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

public class GetNextWed {
    public static void main(String[] args) {
        LocalDate localDate=LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        LocalDate firstDayOfNextMonth=LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        LocalDate firstDayOfNextYear=LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear());
        LocalDate firstDayOfMonth=LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate firstDayOfYear=LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
        System.out.println(localDate);
        System.out.println(firstDayOfNextMonth);
        System.out.println(firstDayOfNextYear);
        System.out.println(firstDayOfMonth);
        System.out.println(firstDayOfYear);
    }
}
