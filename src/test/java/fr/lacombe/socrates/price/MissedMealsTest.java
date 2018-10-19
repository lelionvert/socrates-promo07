package fr.lacombe.socrates.price;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MissedMealsTest {

    @Test
    @Parameters({"18, 15, 0", "19, 10, 1", "19, 11, 1", "19, 12, 1", "19, 0, 1", "19, 14, 2", "20, 0, 3", "20, 15, 4"})
    public void should_calculate_the_number_of_missed_meals_with_varying_check_in_in_given_period(int dayOfMonth, int hour, int numberOfMissedMeals) {
        final LocalDateTime checkIn = LocalDateTime.of(2018, Month.OCTOBER, dayOfMonth, hour, 0, 0);
        final LocalDateTime checkOut = LocalDateTime.of(2018, Month.OCTOBER, 21, 15, 0, 0);
        final LocalTime endOfLunchService = LocalTime.of(13, 59, 59);

        Period conferencePeriod = new Period(
            LocalDateTime.of(2018, Month.OCTOBER, 18, 10, 0, 0),
            LocalDateTime.of(2018, Month.OCTOBER, 21, 18, 0, 0)
            );

        Period participantSojourn = new Period(checkIn, checkOut);

        final MissedMeals missedMeals = MissedMeals.of(conferencePeriod, participantSojourn, endOfLunchService);

        assertThat(missedMeals).isEqualTo(new MissedMeals(numberOfMissedMeals));
    }

    @Test
    @Parameters({"21, 15, 0", "21, 10, 1", "20, 15, 2", "20, 10, 3"})
    public void should_calculate_the_number_of_missed_meals_with_varying_check_out_in_given_period(int dayOfMonth, int hour, int numberOfMissedMeals) {
        final LocalDateTime checkIn = LocalDateTime.of(2018, Month.OCTOBER, 18, 15, 0, 0);
        final LocalDateTime checkOut = LocalDateTime.of(2018, Month.OCTOBER, dayOfMonth, hour, 0, 0);
        final LocalTime endOfLunchService = LocalTime.of(13, 59, 59);

        Period conferencePeriod = new Period(
            LocalDateTime.of(2018, Month.OCTOBER, 18, 10, 0, 0),
            LocalDateTime.of(2018, Month.OCTOBER, 21, 18, 0, 0)
        );

        Period participantSojourn = new Period(checkIn, checkOut);

        final MissedMeals missedMeals = MissedMeals.of(conferencePeriod, participantSojourn, endOfLunchService);

        assertThat(missedMeals).isEqualTo(new MissedMeals(numberOfMissedMeals));
    }

    @Test
    @Parameters({"19, 10, 20, 18, 3"})
    public void should_calculate_the_number_of_missed_meals_with_varying_check_out_and_check_in(int checkInDay, int checkInHour, int checkOutDay, int checkOutHour, int numberOfMissedMeals) {
        final LocalDateTime checkIn = LocalDateTime.of(2018, Month.OCTOBER, checkInDay, checkInHour, 0, 0);
        final LocalDateTime checkOut = LocalDateTime.of(2018, Month.OCTOBER, checkOutDay, checkOutHour, 0, 0);
        final LocalTime endOfLunchService = LocalTime.of(13, 59, 59);

        Period conferencePeriod = new Period(
            LocalDateTime.of(2018, Month.OCTOBER, 18, 10, 0, 0),
            LocalDateTime.of(2018, Month.OCTOBER, 21, 18, 0, 0)
        );

        Period participantSojourn = new Period(checkIn, checkOut);

        final MissedMeals missedMeals = MissedMeals.of(conferencePeriod, participantSojourn, endOfLunchService);

        assertThat(missedMeals).isEqualTo(new MissedMeals(numberOfMissedMeals));
    }
}