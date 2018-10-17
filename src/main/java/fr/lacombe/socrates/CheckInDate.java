package fr.lacombe.socrates;

import java.time.LocalDateTime;

public class CheckInDate {

    private final LocalDateTime dateTime;

    public CheckInDate(final LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isColdMealTime(final Venue venue) {
        return venue.isKitchenClosed(dateTime) && venue.isDeskOpen(dateTime);
    }
}
