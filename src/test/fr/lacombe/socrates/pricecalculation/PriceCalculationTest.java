package fr.lacombe.socrates.pricecalculation;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceCalculationTest {

    @Test
    public void should_return_accomodation_price_when_complete_price_single_room() {
        LocalDateTime checkIn = LocalDateTime.of(2018, Month.OCTOBER, 18, 18, 0);
        LocalDateTime checkOut = LocalDateTime.of(2018, Month.OCTOBER, 21, 14, 0);
        Journey journey = Journey.of(checkIn, checkOut);
        Participant participant = Participant.of(journey, RoomChoice.SINGLE);

        int totalPrice = participant.getParticipationPrice();

        assertThat(totalPrice).isEqualTo(610);
    }

    @Test
    public void should_return_accomodation_price_when_complete_price_double_room() {
        LocalDateTime checkIn = LocalDateTime.of(2018, Month.OCTOBER, 18, 18, 0);
        LocalDateTime checkOut = LocalDateTime.of(2018, Month.OCTOBER, 21, 14, 0);
        Journey journey = Journey.of(checkIn, checkOut);
        Participant participant = Participant.of(journey, RoomChoice.DOUBLE);

        int totalPrice = participant.getParticipationPrice();

        assertThat(totalPrice).isEqualTo(510);
    }
}
