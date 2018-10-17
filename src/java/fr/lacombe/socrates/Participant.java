package fr.lacombe.socrates;

import java.time.LocalDateTime;

public class Participant {

    private final String name;
    private final CheckIn checkIn;

    public Participant(String name, CheckIn checkIn) {
        this.name = name;
        this.checkIn = checkIn;
    }

    public boolean hasColdMeal(LocalDateTime kitchenCloseStartTime, LocalDateTime kitchenCloseEndTime) {
        return checkIn.isInKitchenClosePeriod(kitchenCloseStartTime, kitchenCloseEndTime);
    }
}
