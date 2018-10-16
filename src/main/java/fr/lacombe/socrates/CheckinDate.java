package fr.lacombe.socrates;

import java.time.LocalDateTime;
import java.time.Month;

public class CheckinDate {
    private final int participantAfter9;

    public CheckinDate(int participantAfter9) {
        this.participantAfter9 = participantAfter9;
    }

    public static CheckinDate of(LocalDateTime date) {

        if (date.equals(LocalDateTime.of(2018, Month.OCTOBER, 18, 0, 0, 0))) {
            return new CheckinDate(1);
        }
        return new CheckinDate(0);
    }

    public int getParticipantAfter9() {
        return participantAfter9;
    }
}
