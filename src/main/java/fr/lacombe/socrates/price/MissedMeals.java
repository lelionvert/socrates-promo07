package fr.lacombe.socrates.price;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Objects;

class MissedMeals {

    private static final Price MEAL_PRICE = Price.of(40);

    static final MissedMeals NONE = new MissedMeals(0);

    private final int numberOfMeals;

    MissedMeals(int numberOfMeals) {
        this.numberOfMeals = numberOfMeals;
    }

    static MissedMeals of(LocalDateTime checkIn, LocalDateTime checkOut) {
        LocalDate secondDayOfConference = LocalDate.of(2018, Month.OCTOBER, 19);

        final LocalTime checkInTime = checkIn.toLocalTime();
        final LocalDate checkInDate = checkIn.toLocalDate();

        if (checkInDate.equals(secondDayOfConference) &&
            (checkInTime.equals(LocalTime.of(14, 0, 0)))) {
            return new MissedMeals(2);
        }

        if (checkInDate.equals(secondDayOfConference) &&
            (checkInTime.equals(LocalTime.of(0, 0, 0))
                || checkInTime.equals(LocalTime.of(12, 0, 0))
                || checkInTime.equals(LocalTime.of(11, 0, 0))
                || checkInTime.equals(LocalTime.of(10, 0, 0)))) {
            return new MissedMeals(1);
        }
        return new MissedMeals(0);
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
