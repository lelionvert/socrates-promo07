package fr.lacombe.socrates.covers_participants;

import java.time.LocalDate;
import java.time.LocalTime;

import static java.time.Month.NOVEMBER;

class CoversCalculator {

    private static final LocalDate FIRST_DAY_OF_CONFERENCE = LocalDate.of(2018, NOVEMBER, 1);
    private static final LocalTime THURSDAY_COLD_MEAL_START_HOUR = LocalTime.of(22, 0);

    int calculateCovers(final Participant participant) {
        if (participant.isPresent(FIRST_DAY_OF_CONFERENCE)) {
            return 6;
        }

        return 5;
    }

    Covers compute(final Participant participant) {
        if (participant.isPresent(FIRST_DAY_OF_CONFERENCE)
                && participant.arrivesAfter(THURSDAY_COLD_MEAL_START_HOUR)) {
            return Covers.of(1, 5);
        }

        return Covers.of(0, calculateCovers(participant));
    }
}
