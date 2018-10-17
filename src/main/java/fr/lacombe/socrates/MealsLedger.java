package fr.lacombe.socrates;

import java.util.List;

class MealsLedger {

    private final List<CheckInDate> checkInDates;

    private MealsLedger(final List<CheckInDate> checkInDates) {
        this.checkInDates = checkInDates;
    }

    static MealsLedger of(final List<CheckInDate> participants) {
        return new MealsLedger(participants);
    }

    long countColdMeals(final Venue venue) {
        return checkInDates
                .stream()
                .filter(checkInDate -> checkInDate.isColdMealTime(venue))
                .count();
    }
}
