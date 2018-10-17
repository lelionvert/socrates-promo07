package fr.lacombe.socrates;

import java.time.LocalDateTime;

public class CheckInDate {

    private final LocalDateTime arrivedDate;

    private CheckInDate(LocalDateTime arrivedDate) {
        this.arrivedDate = arrivedDate;
    }

    public static CheckInDate of(LocalDateTime date) {
        return new CheckInDate(date);
    }

    public boolean isKitchenClosedAndReceptionOpened(LocalDateTime startingTime, LocalDateTime endingTime) {

        if (arrivedDate.isAfter(startingTime) && arrivedDate.isBefore(endingTime))
            return true;

        return false;
    }
}
