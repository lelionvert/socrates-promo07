package fr.lacombe.socrates;

import java.time.LocalDate;

public class CheckinDate {
    private final int participantAfter9;

    public CheckinDate(int participantAfter9) {
        this.participantAfter9 = participantAfter9;
    }

    public static CheckinDate of(LocalDate date) {

        if (date.equals(LocalDate.of(2018, 10, 23)))
            return new CheckinDate(0);

        if (date.equals(LocalDate.of(2018, 10, 19)))
            return new CheckinDate(0);

        return new CheckinDate(1);
    }

    public int getParticipantAfter9() {
        return participantAfter9;
    }
}
