package fr.lacombe.socrates.covers_participants;

import fr.lacombe.socrates.diets.Diet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Participant {

    private final LocalDateTime checkIn;

    public Participant(final LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public static Participant of(final Email email, final Diet diet, final LocalDateTime checkIn, final LocalDateTime checkOut) {
        return new Participant(checkIn);
    }

    boolean isPresent(final LocalDate day) {
        return checkIn.toLocalDate().isEqual(day);
    }

    boolean arrivesAfter(final LocalTime time) {
        return checkIn.toLocalTime().isAfter(time);
    }
}
