package fr.lacombe.socrates.pricecalculation;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class ConferenceTest {

    @Test
    public void should_compute_number_of_meals_in_a_period_of_one_day(){
        LocalDateTime start = LocalDateTime.of(2018, Month.OCTOBER, 18, 0, 0);
        LocalDateTime end = LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 0);
        PeriodWithTime period = PeriodWithTime.between(start, end);
        Conference conf = new Conference();

        int numberOfMeals = conf.computeNumberOfMeals(period);

        assertThat(numberOfMeals).isEqualTo(2);
    }

    @Test
    public void should_compute_number_of_meals_in_a_period_of_two_days(){
        LocalDateTime start = LocalDateTime.of(2018, Month.OCTOBER, 18, 0, 0);
        LocalDateTime end = LocalDateTime.of(2018, Month.OCTOBER, 20, 0, 0);
        PeriodWithTime period = PeriodWithTime.between(start, end);
        Conference conf = new Conference();

        int numberOfMeals = conf.computeNumberOfMeals(period);

        assertThat(numberOfMeals).isEqualTo(4);
    }

    @Test
    public void should_compute_number_of_meals_in_a_period_of_two_days_including_time(){
        LocalDateTime start = LocalDateTime.of(2018, Month.OCTOBER, 18, 0, 0);
        LocalDateTime end = LocalDateTime.of(2018, Month.OCTOBER, 20, 14, 0);
        PeriodWithTime period = PeriodWithTime.between(start, end);
        Conference conf = new Conference();

        int numberOfMeals = conf.computeNumberOfMeals(period);

        assertThat(numberOfMeals).isEqualTo(5);
    }
}