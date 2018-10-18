package fr.lacombe.socrates.meals;

import java.util.List;

import static java.util.Arrays.asList;

class CheckInList {

    private final Period period;
    private final List<CheckInDate> checkInDates;

    private CheckInList(Period period, List<CheckInDate> checkInDates) {
        this.period = period;
        this.checkInDates = checkInDates;
    }

    static CheckInList of(Period period, CheckInDate... checkInDates) {
        return new CheckInList(period, asList(checkInDates));
    }

    int getColdMealNumber() {
        return (int) checkInDates.stream()
            .filter(period::contains)
            .count();
    }
}
