package fr.lacombe.socrates.covers_participants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

class CoversCalculator {

    private static final int NUMBER_OF_MEAL_PER_DAY = 2;

    private final LocalDate startDay;
    private final LocalTime endHourOfDiner;
    private final LocalDateTime startHourOfLastLunch;
    private final int minNumberOfHotMeals;

    CoversCalculator(ConferenceConfiguration conferenceConfiguration) {
        this.startHourOfLastLunch = LocalDateTime.of(
                conferenceConfiguration.getEndDay(),
                conferenceConfiguration.getStartHourOfLunch()
        );
        this.startDay = conferenceConfiguration.getStartDay();
        this.endHourOfDiner = conferenceConfiguration.getEndHourOfDiner();
        final Period conferencePeriod = Period.between(
                conferenceConfiguration.getStartDay(),
                conferenceConfiguration.getEndDay()
        );
        this.minNumberOfHotMeals = (conferencePeriod.getDays() - 1) * NUMBER_OF_MEAL_PER_DAY;
    }

    Covers compute(final Participant participant) {
        int numberOfColdMeals = 0;
        int numberOfHotMeals = minNumberOfHotMeals;

        if (participant.leavesBefore(startHourOfLastLunch)) {
            numberOfColdMeals++;
        } else {
            numberOfHotMeals++;
        }

        if (participant.isPresent(startDay)) {
            if (participant.arrivesAfter(endHourOfDiner)) {
                numberOfColdMeals++;
            } else {
                numberOfHotMeals++;
            }
        }

        return Covers.of(numberOfColdMeals, numberOfHotMeals);
    }
}
