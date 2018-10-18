package fr.lacombe.socrates;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {



    @Test
    public void should_return_the_price_for_single_accommodation() {
        Participant participant = new Participant(Accommodation.SINGLE);

        Price price = participant.duePrice(0);

        assertThat(price).isEqualTo(Price.of(610));
    }

    @Test
    public void should_return_the_price_for_double_accommodation() {
        Participant participant = new Participant(Accommodation.DOUBLE);

        Price price = participant.duePrice(0);

        assertThat(price).isEqualTo(Price.of(510));
    }

    @Test
    public void should_return_the_price_for_triple_accommodation() {
        Participant participant = new Participant(Accommodation.TRIPLE);

        Price price = participant.duePrice(0);

        assertThat(price).isEqualTo(Price.of(410));
    }

    @Test
    public void should_return_the_price_for_no_accommodation() {
        Participant participant = new Participant(Accommodation.NONE);

        Price price = participant.duePrice(0);

        assertThat(price).isEqualTo(Price.of(240));
    }

    @Test
    public void should_return_the_price_for_single_accommodation_minus_one_meal() {
        Participant participant = new Participant(Accommodation.SINGLE);

        Price price = participant.duePrice(1);

        assertThat(price).isEqualTo(Price.of(610 - 40));
    }

    @Test
    public void should_return_the_price_for_single_accommodation_minus_two_meals() {
        Participant participant = new Participant(Accommodation.SINGLE);

        Price price = participant.duePrice(2);

        assertThat(price).isEqualTo(Price.of(610 - 2*40));
    }
}
