package fr.lacombe.socrates.coldmeal;

import java.time.LocalDateTime;

public class CheckIn {

    private final LocalDateTime time;

    public CheckIn(LocalDateTime time) {
        this.time = time;
    }

    boolean isInKitchenClosePeriod(LocalDateTime kitchenCloseStartTime, LocalDateTime kitchenCloseEndTime) {
        return null != time
                && time.isAfter(kitchenCloseStartTime)
                && time.isBefore(kitchenCloseEndTime);
    }
}
