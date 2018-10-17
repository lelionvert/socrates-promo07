package fr.lacombe.socrates;

import java.time.LocalDateTime;

class Period {
    private final LocalDateTime start;
    private final LocalDateTime end;

    Period(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    boolean contains(CheckInDate checkInDate) {
        return checkInDate.isBetween(start, end);
    }

}
