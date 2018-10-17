package fr.lacombe.socrates;

import java.time.LocalDateTime;

class EventLocation {
    EventLocation(final LocalDateTime kitchenClosingTime, final LocalDateTime deskClosingTime) {

    }

    boolean isDeskOpen(final LocalDateTime dateTime) {
        return true;
    }
}
