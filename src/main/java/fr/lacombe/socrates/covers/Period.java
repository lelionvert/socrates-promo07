package fr.lacombe.socrates.covers;

import java.time.LocalDateTime;

class Period {

    private final LocalDateTime start;
    private final LocalDateTime end;

    private Period(final LocalDateTime start, final LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    static Period of(final LocalDateTime start, final LocalDateTime end) {
        return new Period(start, end);
    }

    boolean intersects(final Period period) {
        return start.isAfter(period.start) && start.isBefore(period.end)
                || end.isAfter(period.start) && end.isBefore(period.end)
                || start.isEqual(period.start) && end.isEqual(period.end)
                || start.isAfter(period.start) && end.isBefore(period.end)
                || start.isBefore(period.start) && end.isAfter(period.end);
    }
}