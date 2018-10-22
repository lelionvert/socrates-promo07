package fr.lacombe.socrates.covers;

import org.junit.Test;

import java.time.LocalDateTime;

import static fr.lacombe.socrates.covers.Diet.VEGAN;
import static fr.lacombe.socrates.covers.Diet.VEGETARIAN;
import static java.time.Month.OCTOBER;
import static org.assertj.core.api.Assertions.assertThat;

public class MealsTest {

    @Test
    public void should_calculate_the_number_of_vegetarian_covers() {
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 15, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGETARIAN);
        final Period meal = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        );

        final int result = Meals.calculateNumberOfVegetarianCovers(participant, meal);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_2() {
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 15, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGAN);
        final Period meal = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        );

        final int result = Meals.calculateNumberOfVegetarianCovers(participant, meal);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_3() {
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 23, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGETARIAN);
        final Period meal = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        );

        final int result = Meals.calculateNumberOfVegetarianCovers(participant, meal);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_4() {
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 22, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGETARIAN);
        final Period meal = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        );

        final int result = Meals.calculateNumberOfVegetarianCovers(participant, meal);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_5() {
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGETARIAN);
        final Period meal = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        );

        final int result = Meals.calculateNumberOfVegetarianCovers(participant, meal);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_6() {
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 20, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGETARIAN);
        final Period meal = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        );

        final int result = Meals.calculateNumberOfVegetarianCovers(participant, meal);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_7() {
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 19, 16, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGETARIAN);
        final LocalDateTime mealEnd = LocalDateTime.of(2018, OCTOBER, 19, 14, 0);
        final Period meal = Period.of(
                LocalDateTime.of(2018, OCTOBER, 19, 12, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 19, 14, 0, 0)
        );

        final int result = Meals.calculateNumberOfVegetarianCovers(participant, meal);

        assertThat(result).isEqualTo(0);
    }
}
