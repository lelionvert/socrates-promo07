package fr.lacombe.socrates;

import java.time.LocalDateTime;

public class CheckInDate {

    private final Location location;
    private final LocalDateTime arrivedDate;

    private CheckInDate(LocalDateTime arrivedDate, Location location) {
        this.arrivedDate = arrivedDate;
        this.location = location;
    }

    public static CheckInDate of(LocalDateTime date, Location location) {
        return new CheckInDate(date, location);
    }

    public boolean isKitchenClosedAndReceptionOpened() {
        return arrivedDate.isAfter(location.getStartColdMealDistribution()) && arrivedDate.isBefore(location.getEndColdMealDistribution());
    }
}
