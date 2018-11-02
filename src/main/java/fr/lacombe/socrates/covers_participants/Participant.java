package fr.lacombe.socrates.covers_participants;

import fr.lacombe.socrates.diets.Diet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Participant {

    private final LocalDateTime checkIn;
    private final LocalDateTime checkOut;

    public Participant(final LocalDateTime checkIn, final LocalDateTime checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public static Participant of(final Email email, final Diet diet, final LocalDateTime checkIn, final LocalDateTime checkOut) {
        return new Participant(checkIn, checkOut);
    }

    boolean isPresent(final LocalDate day) {
        return checkIn.toLocalDate().isEqual(day);
    }

    boolean arrivesAfter(final LocalTime time) {
        return checkIn.toLocalTime().isAfter(time);
    }

    boolean leavesBefore(final LocalDateTime dateTime) {
        return checkOut.isBefore(dateTime);
    }
}
