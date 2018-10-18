package fr.lacombe.socrates;

import org.junit.Test;

import static fr.lacombe.socrates.Participant.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {



    @Test
    public void should_return_the_price_for_single_accommodation() {
        Participant participant = new Participant(SINGLE_ACCOMMODATION);

        Price price = participant.duePrice();

        assertThat(price).isEqualTo(Price.of(610));
    }

    @Test
    public void should_return_the_price_for_double_accommodation() {
        Participant participant = new Participant(DOUBLE_ACCOMMODATION);

        Price price = participant.duePrice();

        assertThat(price).isEqualTo(Price.of(510));
    }

    @Test
    public void should_return_the_price_for_triple_accommodation() {
        Participant participant = new Participant(TRIPLE_ACCOMMODATION);

        Price price = participant.duePrice();

        assertThat(price).isEqualTo(Price.of(410));
    }

    @Test
    public void should_return_the_price_for_no_accommodation() {
        Participant participant = new Participant(NO_ACCOMMODATION);

        Price price = participant.duePrice();

        assertThat(price).isEqualTo(Price.of(240));
    }
}
