package fr.lacombe.socrates;

import java.time.LocalDateTime;

class CheckInDate {

    private final Venue venue;
    private final LocalDateTime arrivedDate;

    private CheckInDate(LocalDateTime arrivedDate, Venue venue) {
        this.arrivedDate = arrivedDate;
        this.venue = venue;
    }

    static CheckInDate of(LocalDateTime date, Venue venue) {
        return new CheckInDate(date, venue);
    }

    boolean isAfterStartAndBeforeEndOfColdMealDistribution() {
        return venue.arrivedDateIsAfterStartColdMealDistribution(arrivedDate)
            && venue.arrivedDateIsBeforeEndColdMealDistribution(arrivedDate);
    }
}
