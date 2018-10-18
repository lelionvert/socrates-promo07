package fr.lacombe.socrates.price;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MissedMealsTest {

    @Test
    public void calculate_the_number_of_missed_meals() {
        final LocalDateTime checkIn = LocalDateTime.of(2018, 10, 18, 15, 0, 0);
        final LocalDateTime checkOut = LocalDateTime.of(2018, 10, 21, 15, 0, 0);

        final MissedMeals missedMeals = MissedMeals.of(checkIn, checkOut);

        assertThat(missedMeals).isEqualTo(new MissedMeals(0));
    }

    @Test
    public void calculate_the_number_of_missed_meals_2() {
        final LocalDateTime checkIn = LocalDateTime.of(2018, 10, 19, 10, 0, 0);
        final LocalDateTime checkOut = LocalDateTime.of(2018, 10, 21, 15, 0, 0);

        final MissedMeals missedMeals = MissedMeals.of(checkIn, checkOut);

        assertThat(missedMeals).isEqualTo(new MissedMeals(1));
    }

    @Test
    public void calculate_the_number_of_missed_meals_3() {
        final LocalDateTime checkIn = LocalDateTime.of(2018, 10, 19, 11, 0, 0);
        final LocalDateTime checkOut = LocalDateTime.of(2018, 10, 21, 15, 0, 0);

        final MissedMeals missedMeals = MissedMeals.of(checkIn, checkOut);

        assertThat(missedMeals).isEqualTo(new MissedMeals(1));
    }

    @Test
    public void calculate_the_number_of_missed_meals_4() {
        final LocalDateTime checkIn = LocalDateTime.of(2018, 10, 19, 12, 0, 0);
        final LocalDateTime checkOut = LocalDateTime.of(2018, 10, 21, 15, 0, 0);

        final MissedMeals missedMeals = MissedMeals.of(checkIn, checkOut);

        assertThat(missedMeals).isEqualTo(new MissedMeals(1));
    }

    @Test
    public void calculate_the_number_of_missed_meals_5() {
        final LocalDateTime checkIn = LocalDateTime.of(2018, 10, 19, 0, 0, 0);
        final LocalDateTime checkOut = LocalDateTime.of(2018, 10, 21, 15, 0, 0);

        final MissedMeals missedMeals = MissedMeals.of(checkIn, checkOut);

        assertThat(missedMeals).isEqualTo(new MissedMeals(1));
    }

    @Test
    public void calculate_the_number_of_missed_meals_6() {
        final LocalDateTime checkIn = LocalDateTime.of(2018, 10, 19, 14, 0, 0);
        final LocalDateTime checkOut = LocalDateTime.of(2018, 10, 21, 15, 0, 0);

        final MissedMeals missedMeals = MissedMeals.of(checkIn, checkOut);

        assertThat(missedMeals).isEqualTo(new MissedMeals(2));
    }
}