package fr.lacombe.socrates;

import java.time.LocalDate;

public class CheckinDate {
    private final int participantAfter9;

    public CheckinDate(int participantAfter9) {
        this.participantAfter9 = participantAfter9;
    }

    public static CheckinDate of(LocalDate date) {
        return new CheckinDate(1);
    }

    public int getParticipantAfter9() {
        return participantAfter9;
    }
}
