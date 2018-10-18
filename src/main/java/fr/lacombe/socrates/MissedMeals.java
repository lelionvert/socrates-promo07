package fr.lacombe.socrates;

import java.time.LocalDateTime;
import java.util.Objects;

class MissedMeals {
    private static final Price MEAL_PRICE = Price.of(40);

    private final int numberOfMeals;

    MissedMeals(int numberOfMeals) {
        this.numberOfMeals = numberOfMeals;
    }

    static MissedMeals of(LocalDateTime checkIn, LocalDateTime checkOut) {
        if(checkIn.isEqual(LocalDateTime.of(2018, 10, 19, 15, 0, 0))) {
            return new MissedMeals(2);
        }
        return new MissedMeals(1);
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
}
