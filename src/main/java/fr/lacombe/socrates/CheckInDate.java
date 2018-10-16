package fr.lacombe.socrates;

import java.time.LocalDateTime;

class CheckInDate {

    private final LocalDateTime checkin;

    CheckInDate(final LocalDateTime checkin) {
        this.checkin = checkin;
    }


    boolean isThursdayEvening() {
        return false;
    }
}
