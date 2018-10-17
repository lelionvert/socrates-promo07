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

    public boolean isKitchenClosedAndReceptionOpened(LocalDateTime kitchenCloseTime, LocalDateTime receptionCloseTime) {
        return arrivedDate.isAfter(kitchenCloseTime) && arrivedDate.isBefore(receptionCloseTime);

    }
}
