package fr.lacombe.socrates;

import java.time.LocalDateTime;

class Participant {
    private final CheckInDate checkInTime;

    public Participant(CheckInDate checkInTime) {
        this.checkInTime = checkInTime;
    }

    public boolean hasColdMeal(LocalDateTime kitchenCloseTime, LocalDateTime receptionCloseTime) {
        return checkInTime.isKitchenClosedAndReceptionOpened(kitchenCloseTime, receptionCloseTime);
    }
}
