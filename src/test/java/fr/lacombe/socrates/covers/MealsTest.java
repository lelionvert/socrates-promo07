package fr.lacombe.socrates.covers;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static fr.lacombe.socrates.covers.Diet.VEGAN;
import static fr.lacombe.socrates.covers.Diet.VEGETARIAN;
import static java.time.Month.OCTOBER;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class MealsTest {

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_when_a_vegetarian_participant_is_present() {
        final List<Period> meals = singletonList(Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        ));
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 15, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGETARIAN);

        final int result = Meals.calculateNumberOfVegetarianCovers(participant, meals);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_when_a_non_vegetarian_participant_is_present() {
        final List<Period> meals = singletonList(Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        ));
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 15, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGAN);

        final int result = Meals.calculateNumberOfVegetarianCovers(participant, meals);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_no_vegetarian_participant_is_present() {
        final List<Period> meals = singletonList(Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        ));
        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 23, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGETARIAN);

        final int result = Meals.calculateNumberOfVegetarianCovers(participant, meals);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_for_a_vegetarian_participant_in_numerous_meals() {
        final List<Period> meals = asList(
                Period.of(
                        LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                        LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
                ),
                Period.of(
                        LocalDateTime.of(2018, OCTOBER, 19, 12, 0, 0),
                        LocalDateTime.of(2018, OCTOBER, 19, 14, 0, 0)
                )
        );

        final Period participantSojourn = Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 15, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
        );
        final Participant participant = Participant.of(participantSojourn, VEGETARIAN);

        final int result = Meals.calculateNumberOfVegetarianCovers(participant, meals);

        assertThat(result).isEqualTo(2);
    }
}
