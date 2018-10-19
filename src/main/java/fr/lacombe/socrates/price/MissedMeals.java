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
        final LocalTime checkInTime = checkIn.toLocalTime();
        final LocalDate checkInDate = checkIn.toLocalDate();

        LocalDate secondDayOfConference = LocalDate.of(2018, Month.OCTOBER, 19);
        LocalDate thirdDayOfConference = LocalDate.of(2018, Month.OCTOBER, 20);

        TimePeriod morning = new TimePeriod(
            LocalTime.of(0, 0, 0),
            LocalTime.of(14, 0, 0)
        );
        TimePeriod afternoon = new TimePeriod(
            LocalTime.of(14, 0, 0),
            LocalTime.of(23, 59, 59)
        );


        if (checkInDate.equals(thirdDayOfConference)
            && afternoon.contains(checkInTime)) {
            return new MissedMeals(4);
        }
        if (checkInDate.equals(thirdDayOfConference)
            && morning.contains(checkInTime)) {
            return new MissedMeals(3);
        }

        if (checkInDate.equals(secondDayOfConference)
            && afternoon.contains(checkInTime)) {
            return new MissedMeals(2);
        }
        if (checkInDate.equals(secondDayOfConference)
            && morning.contains(checkInTime)) {
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

    @Override
    public String toString() {
        return "MissedMeals{" +
            "numberOfMeals=" + numberOfMeals +
            '}';
    }
}
