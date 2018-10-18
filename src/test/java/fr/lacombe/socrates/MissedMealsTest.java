package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MissedMealsTest {

    @Test
    public void calculate_the_number_of_missed_meals() {
        final LocalDateTime fridayBeforeLunch = LocalDateTime.of(2018, 10, 19, 10, 0, 0);
        final LocalDateTime sundayAfterLunch = LocalDateTime.of(2018, 10, 19, 17, 0, 0);

        final MissedMeals missedMeals = MissedMeals.of(fridayBeforeLunch, sundayAfterLunch);

        assertThat(missedMeals).isEqualTo(new MissedMeals(1));
    }

    @Test
    public void calculate_the_number_of_missed_meals_2() {
        final LocalDateTime fridayAfterLunch = LocalDateTime.of(2018, 10, 19, 15, 0, 0);
        final LocalDateTime sundayAfterLunch = LocalDateTime.of(2018, 10, 19, 17, 0, 0);

        final MissedMeals missedMeals = MissedMeals.of(fridayAfterLunch, sundayAfterLunch);

        assertThat(missedMeals).isEqualTo(new MissedMeals(2));
    }
}