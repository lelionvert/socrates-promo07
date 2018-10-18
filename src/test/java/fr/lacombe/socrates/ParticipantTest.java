package fr.lacombe.socrates;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(JUnitParamsRunner.class)
public class ParticipantTest {


    @Parameters({"SINGLE, 610", "DOUBLE, 510", "TRIPLE, 410", "NONE, 240"})
    @Test
    public void calculate_the_price_without_meal_reduction(Accommodation accommodation, int accommodationPrice ) {
        Participant participant = new Participant(accommodation);

        Price price = participant.duePrice(0);

        assertThat(price).isEqualTo(Price.of(accommodationPrice));
    }

    @Test
    public void should_return_the_price_for_single_accommodation_minus_one_meal() {
        Participant participant = new Participant(Accommodation.SINGLE);

        Price price = participant.duePrice(1);

        assertThat(price).isEqualTo(Price.of(570));
    }

    @Test
    public void should_return_the_price_for_single_accommodation_minus_two_meals() {
        Participant participant = new Participant(Accommodation.SINGLE);

        Price price = participant.duePrice(2);

        assertThat(price).isEqualTo(Price.of(530));
    }
}
