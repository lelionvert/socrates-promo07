package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {

    @Test
    public void francis_should_not_have_a_cold_meal_at_19h45() {
        final Participant participant = new Participant(
                "Francis",
                new CheckInDate(LocalDateTime.of(2018, 10, 18, 19, 45))
        );

        final boolean result = participant.hasColdMeal();

        assertThat(result).isFalse();
    }

    @Test
    public void paula_should_have_a_cold_meal_at_21h01() {
        final Participant participant = new Participant(
                "Paula",
                new CheckInDate(LocalDateTime.of(2018, 10, 18, 21, 1))
        );

        final boolean result = participant.hasColdMeal();

        assertThat(result).isTrue();
    }

    @Test
    public void bernadette_should_have_a_cold_meal_at_00h00() {
        final Participant participant = new Participant(
                "Bernadette",
                new CheckInDate(LocalDateTime.of(2018, 10, 19, 0, 0))
        );

        final boolean result = participant.hasColdMeal();

        assertThat(result).isTrue();
    }

    @Test
    public void victor_should_not_have_a_cold_meal_at_00h01() {
        final Participant participant = new Participant(
                "Victor",
                new CheckInDate(LocalDateTime.of(2018, 10, 19, 0, 1))
        );

        final boolean result = participant.hasColdMeal();

        assertThat(result).isFalse();
    }


    @Test
    public void benoit_should_not_have_a_cold_meal_at_21h00() {
        final Participant participant = new Participant(
                "Benoît",
                new CheckInDate(LocalDateTime.of(2018, 10, 18, 21, 0))
        );

        final boolean result = participant.hasColdMeal();

        assertThat(result).isFalse();
    }
}
