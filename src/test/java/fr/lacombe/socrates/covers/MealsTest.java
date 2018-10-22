package fr.lacombe.socrates.covers;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

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

        final int result = Meals.calculateNumberOfVegetarianCovers(participant);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_2() {
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 15, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGAN);

        final int result = Meals.calculateNumberOfVegetarianCovers(participant);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_3() {
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 23, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGETARIAN);

        final int result = Meals.calculateNumberOfVegetarianCovers(participant);

        assertThat(result).isEqualTo(0);
    }
}
