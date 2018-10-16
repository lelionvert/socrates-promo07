package fr.lacombe.socrates;

import java.time.LocalDateTime;
import java.time.Month;

public class CheckInDate {
    private final int participantAfter9;

    private CheckInDate(int participantAfter9) {
        this.participantAfter9 = participantAfter9;
    }

    public static CheckInDate of(LocalDateTime date) {

        if (date.isAfter(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 0, 0))
            && date.isBefore(LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 1, 0)))
            return new CheckInDate(1);

        return new CheckInDate(0);
    }

    public int getParticipantAfter9() {
        return participantAfter9;
    }
}
