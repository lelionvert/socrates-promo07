package fr.lacombe.socrates.covers;

import java.time.LocalDateTime;
import java.util.Objects;

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

    boolean contains(final Period period) {
        return start.isBefore(period.start) && end.isAfter(period.end);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Period period = (Period) o;
        return Objects.equals(start, period.start) &&
                Objects.equals(end, period.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "Period{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}