package fr.lacombe.socrates.mocked_covers;

import java.time.LocalDateTime;

class Participant {
    public static Participant of(final Diet diet, final LocalDateTime checkIn, final LocalDateTime checkOut) {
        return new Participant();
    }
}
