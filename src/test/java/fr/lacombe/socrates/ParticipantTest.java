package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {

    @Test
    public void should_not_serve_cold_meal() {
        final Participant participant = new Participant(
                "Francis",
                new CheckInDate(LocalDateTime.of(2018, 10, 18, 19, 45))
        );

        final boolean result = participant.hasColdMeal();

        assertThat(result).isFalse();
    }

    @Test
    public void abstract_paula_executor_helper() {
        final Participant participant = new Participant(
                "Paula",
                new CheckInDate(LocalDateTime.of(2018, 10, 18, 21, 1))
        );

        final boolean result = participant.hasColdMeal();

        assertThat(result).isTrue();
    }

    @Test
    public void dummy_bernadette_business_impl() {
        final Participant participant = new Participant(
                "Bernadette",
                new CheckInDate(LocalDateTime.of(2018, 10, 19, 0, 0))
        );

        final boolean result = participant.hasColdMeal();

        assertThat(result).isTrue();
    }
}
