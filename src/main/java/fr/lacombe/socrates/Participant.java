package fr.lacombe.socrates;

class Participant {
    private final CheckInDate checkInTime;

    Participant(CheckInDate checkInTime) {
        this.checkInTime = checkInTime;
    }

    boolean hasColdMeal() {
        return checkInTime.isAfterStartAndBeforeEndOfColdMealDistribution();
    }
}
