package fr.lacombe.socrates.covers_participants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.time.Month.NOVEMBER;

class CoversCalculator {

    private static final LocalDate FIRST_DAY_OF_CONFERENCE = LocalDate.of(2018, NOVEMBER, 1);
    private static final LocalTime THURSDAY_COLD_MEAL_START_HOUR = LocalTime.of(22, 0);
    private static final LocalDateTime END_OF_LAST_MEAL_OF_CONFERENCE = LocalDateTime.of(2018, NOVEMBER, 4, 14, 0);

    Covers compute(final Participant participant) {
        int numberOfColdMeals = 0;
        int numberOfHotMeals = 4;

        if (!participant.leavesAfter(END_OF_LAST_MEAL_OF_CONFERENCE)) {
            numberOfColdMeals++;
        } else {
            numberOfHotMeals++;
        }

        if (participant.isPresent(FIRST_DAY_OF_CONFERENCE)) {
            if (participant.arrivesAfter(THURSDAY_COLD_MEAL_START_HOUR)) {
                numberOfColdMeals++;
            } else {
                numberOfHotMeals++;
            }
        }

        return Covers.of(numberOfColdMeals, numberOfHotMeals);
    }
}
