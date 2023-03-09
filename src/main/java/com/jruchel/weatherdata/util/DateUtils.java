package com.jruchel.weatherdata.util;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DateUtils {

    private DateUtils() {

    }

    public static LocalTime getTimeFromTimestamp(long timestamp, String timezone) {
        return LocalTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.of(timezone));
    }

    public static LocalDate getDateFromTimestamp(long timestamp, String timezone) {
        return LocalDate.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.of(timezone));
    }

    public static List<LocalDate> getWeekDays(LocalDate date, ZoneId zoneId) {
        List<LocalDate> result = new ArrayList<>();
        LocalDate monday =

                LocalDateTime.of(date, LocalTime.now())
                        .with(LocalTime.MIN)
                        .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                        .atZone(zoneId).toLocalDate();
        result.add(monday);

        for (int i = 0; i < 6; i++) {
            result.add(result.get(i).plusDays(1));
        }

        return result;
    }
}
