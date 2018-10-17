package fr.lacombe.socrates;

import java.time.LocalDateTime;
import java.time.Month;

public class CheckInDate {
    private final int numberOfColdMeals;

    private CheckInDate(int numberOfColdMeals) {
        this.numberOfColdMeals = numberOfColdMeals;
    }

    public static CheckInDate of(LocalDateTime date) {

        if (date.isAfter(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 0, 0))
            && date.isBefore(LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 1, 0)))
            return new CheckInDate(1);

        return new CheckInDate(0);
    }

    public int getNumberOfColdMeals() {
        return numberOfColdMeals;
    }
}
