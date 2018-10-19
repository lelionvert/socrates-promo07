package fr.lacombe.socrates.price;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.DAYS;

class Period {

    private final LocalDateTime start;
    private final LocalDateTime end;

    Period(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    boolean startIsAfter(final LocalTime time) {
        return start.toLocalTime().isAfter(time);
    }

    boolean endIsBefore(final LocalTime time) {
        return end.toLocalTime().isBefore(time);
    }

    int daysDifferenceWith(final Period period) {
        final int daysBeforeStart = (int) DAYS.between(start.toLocalDate().plusDays(1), period.start.toLocalDate());
        final int daysAfterEnd = (int) DAYS.between(period.end.toLocalDate(), end.toLocalDate());

        return daysBeforeStart + daysAfterEnd;
    }
}
