package fr.lacombe.socrates.price;

import java.time.LocalTime;

class TimePeriod {

    private final LocalTime start;
    private final LocalTime end;

    TimePeriod(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    boolean contains(LocalTime time) {
        return time.isAfter(start) && time.isBefore(end) || time.equals(start);
    }
}
