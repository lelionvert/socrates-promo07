package fr.lacombe.socrates;

import java.time.LocalDateTime;

public class Venue {
    private final LocalDateTime kitchenClosingTime;
    private final LocalDateTime deskClosingTime;

    Venue(final LocalDateTime kitchenClosingTime, final LocalDateTime deskClosingTime) {
        this.kitchenClosingTime = kitchenClosingTime;
        this.deskClosingTime = deskClosingTime;
    }

    boolean isDeskOpen(final LocalDateTime dateTime) {
        return dateTime.isBefore(deskClosingTime);
    }

    boolean isKitchenClosed(final LocalDateTime dateTime) {
        return dateTime.isAfter(kitchenClosingTime);
    }
}
