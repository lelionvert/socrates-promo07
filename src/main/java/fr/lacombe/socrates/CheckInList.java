package fr.lacombe.socrates;

import java.util.List;

import static java.util.Arrays.asList;

class CheckInList {

    private final List<CheckInDate> checkInDates;

    private CheckInList(List<CheckInDate> checkInDates) {
        this.checkInDates = checkInDates;
    }

    static CheckInList of(CheckInDate... participants) {
        return new CheckInList(asList(participants));
    }

    int getColdMealNumber() {
        return (int) checkInDates.stream()
            .filter(CheckInDate::isAfterStartAndBeforeEndOfColdMealDistribution)
            .count();
    }
}
