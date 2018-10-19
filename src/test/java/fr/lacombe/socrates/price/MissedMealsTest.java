package fr.lacombe.socrates.price;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MissedMealsTest {

    @Parameters({"18, 15, 0", "19, 10, 1", "19, 11, 1", "19, 12, 1", "19, 0, 1", "19, 14, 2", "20, 0, 3", "20, 15, 4"})
    @Test
    public void should_calculate_the_number_of_missed_meals_with_varying_check_in_in_given_period(int dayOfMonth, int hour, int numberOfMissedMeals) {
        final LocalDate firstDayOfConference = LocalDate.of(2018, Month.OCTOBER, 18);
        final LocalDateTime checkIn = LocalDateTime.of(2018, Month.OCTOBER, dayOfMonth, hour, 0, 0);
        final LocalDateTime checkOut = LocalDateTime.of(2018, 10, 21, 15, 0, 0);
        final LocalTime endOfLunchService = LocalTime.of(13, 59, 59);

        final MissedMeals missedMeals = MissedMeals.of(firstDayOfConference, checkIn, checkOut, endOfLunchService);

        assertThat(missedMeals).isEqualTo(new MissedMeals(numberOfMissedMeals));
    }
}