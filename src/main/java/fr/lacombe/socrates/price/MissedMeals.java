package fr.lacombe.socrates.price;

import java.time.LocalTime;
import java.util.Objects;

class MissedMeals {

    private static final Price MEAL_PRICE = Price.of(40);

    static final MissedMeals NONE = new MissedMeals(0);

    private final int numberOfMeals;

    MissedMeals(int numberOfMeals) {
        this.numberOfMeals = numberOfMeals;
    }

    static MissedMeals of(Period conferencePeriod, Period participantSojourn, LocalTime endOfLunchService) {

        final int NUMBER_OF_MEAL_ON_FIRST_DAY = 1;
        final int NUMBER_OF_MEALS_PER_DAY = 2;

        final int numberOfMissedDays = conferencePeriod.daysDifferenceWith(participantSojourn);
        MissedMeals missedMeals = new MissedMeals(numberOfMissedDays)
            .multiply(NUMBER_OF_MEALS_PER_DAY)
            .add(NUMBER_OF_MEAL_ON_FIRST_DAY);

        if (participantSojourn.endIsBefore(endOfLunchService)) {
            missedMeals = missedMeals.add(NUMBER_OF_MEAL_ON_FIRST_DAY);
        }

        if (participantSojourn.startIsAfter(endOfLunchService)) {
            missedMeals = missedMeals.add(NUMBER_OF_MEAL_ON_FIRST_DAY);
        }

        return missedMeals;
    }

    private MissedMeals add(int quantity) {
        return new MissedMeals(numberOfMeals + quantity);
    }

    private MissedMeals multiply(int quantity) {
        return new MissedMeals(numberOfMeals * quantity);
    }

    Price calculatePrice() {
        return MEAL_PRICE.multiply(numberOfMeals);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MissedMeals that = (MissedMeals) o;
        return numberOfMeals == that.numberOfMeals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfMeals);
    }

    @Override
    public String toString() {
        return "MissedMeals{" +
            "numberOfMeals=" + numberOfMeals +
            '}';
    }
}
