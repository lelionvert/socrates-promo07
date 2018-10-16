package fr.lacombe.socrates;

import java.time.LocalDateTime;

class CheckInDate {

    private final LocalDateTime dateTime;

    CheckInDate(final LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    boolean isThursdayEvening() {
        if(dateTime.getHour() == 22 && dateTime.getMinute() == 0)
            return true;
        if(dateTime.getHour() == 0 && dateTime.getMinute() == 0)
            return true;
        if(dateTime.getHour() == 0)
            return false;
        if(dateTime.getMinute() == 1)
            return true;
        return false;
    }
}
