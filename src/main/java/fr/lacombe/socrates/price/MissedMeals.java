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
        final int NUMBER_OF_MEALS_PER_DAY = 2;
        final int numberOfMissedDays = conferencePeriod.daysDifferenceWith(participantSojourn);

        return new MissedMeals(numberOfMissedDays)
            .multiply(NUMBER_OF_MEALS_PER_DAY)
            .increment()
            .incrementIf(participantSojourn.startIsAfter(endOfLunchService))
            .incrementIf(participantSojourn.endIsBefore(endOfLunchService));
    }

    private MissedMeals increment() {
        return new MissedMeals(numberOfMeals + 1);
    }

    private MissedMeals incrementIf(final boolean shouldIncrement) {
        return shouldIncrement ? this.increment() : this;
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
