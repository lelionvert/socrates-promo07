package fr.lacombe.socrates.covers;

import org.junit.Test;

import java.time.LocalDateTime;

import static fr.lacombe.socrates.covers.Diet.VEGAN;
import static fr.lacombe.socrates.covers.Diet.VEGETARIAN;
import static java.time.Month.OCTOBER;
import static org.assertj.core.api.Assertions.assertThat;

public class MealsTest {

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_when_a_vegetarian_participant_is_present() {
        final Period meal = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        );
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 15, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGETARIAN);

        final int result = Meals.calculateNumberOfVegetarianCovers(participant, meal);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_when_a_non_vegetarian_participant_is_present() {
        final Period meal = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        );
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 15, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGAN);

        final int result = Meals.calculateNumberOfVegetarianCovers(participant, meal);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_no_vegetarian_participant_is_present() {
        final Period meal = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        );
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 23, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGETARIAN);

        final int result = Meals.calculateNumberOfVegetarianCovers(participant, meal);

        assertThat(result).isEqualTo(0);
    }
}
