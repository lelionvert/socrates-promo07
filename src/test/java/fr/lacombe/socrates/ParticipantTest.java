package fr.lacombe.socrates;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {

    @Test
    public void should_calculate_price() {
        Participant participant = new Participant();

        Price price = participant.duePrice();

        assertThat(price).isEqualTo(Price.of(610));

    }
}
