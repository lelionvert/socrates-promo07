package fr.lacombe.socrates;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

class CheckInDate {

    private final LocalDateTime dateTime;

    CheckInDate(final LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    boolean isThursdayEvening() {
        final boolean isThursdayEvening = dateTime.getDayOfWeek() == DayOfWeek.THURSDAY && (dateTime.getHour() == 21 && dateTime.getMinute() > 0 || dateTime.getHour() >= 22);
        final boolean isFridayMidnight = dateTime.getDayOfWeek() == DayOfWeek.FRIDAY && dateTime.getHour() == 0 && dateTime.getMinute() == 0;

        return isThursdayEvening || isFridayMidnight;
    }
}
