package fr.lacombe.socrates.covers_participants;

import java.time.LocalDate;

import static java.time.Month.NOVEMBER;

class CoversCalculator {

    private static final LocalDate FIRST_DAY_OF_CONFERENCE = LocalDate.of(2018, NOVEMBER, 1);

    int calculateCovers(final Participant participant) {
        if (participant.isPresent(FIRST_DAY_OF_CONFERENCE)) {
            return 6;
        }

        return 5;
    }

    Covers compute(final Participant participant) {
        return Covers.of(0, calculateCovers(participant));
    }
}
