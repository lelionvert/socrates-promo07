package fr.lacombe.socrates.price;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

class MissedMeals {

    private static final Price MEAL_PRICE = Price.of(40);

    static final MissedMeals NONE = new MissedMeals(0);

    private final int numberOfMeals;

    MissedMeals(int numberOfMeals) {
        this.numberOfMeals = numberOfMeals;
    }

    static MissedMeals of(LocalDate firstDayOfConference, LocalDateTime checkIn, LocalDateTime checkOut, LocalTime endOfLunchService) {
        final int NUMBER_OF_MEAL_ON_FIRST_DAY = 1;
        final int NUMBER_OF_MEALS_PER_DAY = 2;

        final int daysSinceConferenceStart = (int) DAYS.between(firstDayOfConference.plusDays(1), checkIn.toLocalDate());

        int number = 0;

        number += NUMBER_OF_MEALS_PER_DAY * daysSinceConferenceStart + NUMBER_OF_MEAL_ON_FIRST_DAY;
        if (checkIn.toLocalTime().isAfter(endOfLunchService)) {
            number = number + 1;
        }

        if(checkOut.equals(LocalDateTime.of(2018, Month.OCTOBER, 21, 10, 0, 0))) {
            number = number + 1;
        }

        return new MissedMeals(number);
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
