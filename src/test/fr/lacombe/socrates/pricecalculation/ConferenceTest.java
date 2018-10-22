package fr.lacombe.socrates.pricecalculation;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class ConferenceTest {

    private Conference conference;

    @Before
    public void initTest() {
        conference = Conference.of(2, 12, 14, 18);
    }

    @Test
    public void should_compute_number_of_meals_in_a_period_of_one_day(){
        LocalDateTime start = LocalDateTime.of(2018, Month.OCTOBER, 18, 0, 0);
        LocalDateTime end = LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 0);
        PeriodWithTime period = PeriodWithTime.between(start, end);

        int numberOfMeals = conference.computeNumberOfMeals(period);

        assertThat(numberOfMeals).isEqualTo(2);
    }

    @Test
    public void should_compute_number_of_meals_in_a_period_of_two_days(){
        LocalDateTime start = LocalDateTime.of(2018, Month.OCTOBER, 18, 0, 0);
        LocalDateTime end = LocalDateTime.of(2018, Month.OCTOBER, 20, 0, 0);
        PeriodWithTime period = PeriodWithTime.between(start, end);

        int numberOfMeals = conference.computeNumberOfMeals(period);

        assertThat(numberOfMeals).isEqualTo(4);
    }

    @Test
    public void should_compute_number_of_meals_in_a_period_of_two_days_plus_one_meal_last_day(){
        LocalDateTime start = LocalDateTime.of(2018, Month.OCTOBER, 18, 0, 0);
        LocalDateTime end = LocalDateTime.of(2018, Month.OCTOBER, 20, 12, 0);
        PeriodWithTime period = PeriodWithTime.between(start, end);

        int numberOfMeals = conference.computeNumberOfMeals(period);

        assertThat(numberOfMeals).isEqualTo(5);
    }

    @Test
    public void should_compute_number_of_meals_in_a_period_of_two_days_plus_two_meals_last_day(){
        LocalDateTime start = LocalDateTime.of(2018, Month.OCTOBER, 18, 0, 0);
        LocalDateTime end = LocalDateTime.of(2018, Month.OCTOBER, 20, 18, 0);
        PeriodWithTime period = PeriodWithTime.between(start, end);

        int numberOfMeals = conference.computeNumberOfMeals(period);

        assertThat(numberOfMeals).isEqualTo(6);
    }

    @Test
    public void should_compute_number_of_meals_in_a_period_of_two_days_minus_one_meal_first_day(){
        LocalDateTime start = LocalDateTime.of(2018, Month.OCTOBER, 18, 14, 0);
        LocalDateTime end = LocalDateTime.of(2018, Month.OCTOBER, 20, 0, 0);
        PeriodWithTime period = PeriodWithTime.between(start, end);

        int numberOfMeals = conference.computeNumberOfMeals(period);

        assertThat(numberOfMeals).isEqualTo(3);
    }
}