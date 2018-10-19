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

    static MissedMeals of(LocalDateTime checkIn, LocalDateTime checkOut) {
        final LocalTime checkInTime = checkIn.toLocalTime();
        final LocalDate checkInDate = checkIn.toLocalDate();

        TimePeriod afternoon = new TimePeriod(
            LocalTime.of(14, 0, 0),
            LocalTime.of(23, 59, 59)
        );

        int number = 0;
        final int NUMBER_OF_MEAL_ON_FIRST_DAY = 1;
        final int NUMBER_OF_MEALS_PER_DAY = 2;

        final LocalDate firstDayOfConference = LocalDate.of(2018, Month.OCTOBER, 18);
        final int daysSinceConferenceStart = (int) DAYS.between(firstDayOfConference, checkInDate) - NUMBER_OF_MEAL_ON_FIRST_DAY;

        number += NUMBER_OF_MEALS_PER_DAY * daysSinceConferenceStart + NUMBER_OF_MEAL_ON_FIRST_DAY;
        if (afternoon.contains(checkInTime)) {
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
