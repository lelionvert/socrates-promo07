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
}
