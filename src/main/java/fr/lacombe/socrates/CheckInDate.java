package fr.lacombe.socrates;

import java.time.LocalDateTime;
import java.time.Month;

public class CheckInDate {
    private final boolean isKitchenClosed;

    private CheckInDate(boolean isKitchenClosed) {
        this.isKitchenClosed = isKitchenClosed;
    }

    public static CheckInDate of(LocalDateTime date) {

        if (date.isAfter(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 0, 0))
            && date.isBefore(LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 1, 0)))
            return new CheckInDate(true);

        return new CheckInDate(false);
    }

    public boolean isKitchenClosed() {
        return isKitchenClosed;
    }
}
