package fr.lacombe.socrates.mock;

import fr.lacombe.socrates.CheckInDate;
import fr.lacombe.socrates.Venue;

import java.time.LocalDateTime;

public class CheckInDateMock extends CheckInDate {

    private boolean isThursdayEvening;

    public CheckInDateMock(final LocalDateTime dateTime) {
        super(dateTime);
    }

    public void whenCallingIsThursdayEveningThenReturn(final boolean isThursdayEvening) {
        this.isThursdayEvening = isThursdayEvening;
    }

    @Override
    public boolean isColdMealTime(final Venue venue) {
        return isThursdayEvening;
    }
}
