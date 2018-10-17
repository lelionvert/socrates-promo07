package fr.lacombe.socrates;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.THURSDAY;

class CheckInDate {

    private static final LocalTime KITCHEN_CLOSING_TIME = LocalTime.of(21, 0);
    private static final LocalTime DESK_CLOSING_TIME = LocalTime.of(0, 1);

    private final LocalDateTime dateTime;

    CheckInDate(final LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    boolean isThursdayEvening() {
        return isKitchenClosed() || isDeskOpen();
    }

    private boolean isDeskOpen() {
        return dateTime.getDayOfWeek() == FRIDAY
                && dateTime.toLocalTime().isBefore(DESK_CLOSING_TIME);
    }

    private boolean isKitchenClosed() {
        return dateTime.getDayOfWeek() == THURSDAY
                && dateTime.toLocalTime().isAfter(KITCHEN_CLOSING_TIME);
    }
}
