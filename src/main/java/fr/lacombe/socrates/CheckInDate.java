package fr.lacombe.socrates;

import java.time.LocalDateTime;

class CheckInDate {

    private final LocalDateTime arrivedDate;

    private CheckInDate(LocalDateTime arrivedDate) {
        this.arrivedDate = arrivedDate;
    }

    static CheckInDate of(LocalDateTime date) {
        return new CheckInDate(date);
    }

    boolean isBetween(LocalDateTime start, LocalDateTime end) {
        return arrivedDate.isAfter(start)
            && arrivedDate.isBefore(end);
    }
}
