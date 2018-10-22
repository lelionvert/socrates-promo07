package fr.lacombe.socrates.covers;

import java.time.LocalDateTime;

class Period {

    final LocalDateTime start;
    final LocalDateTime end;

    private Period(final LocalDateTime start, final LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    static Period of(final LocalDateTime start, final LocalDateTime end) {
        return new Period(start, end);
    }
}
