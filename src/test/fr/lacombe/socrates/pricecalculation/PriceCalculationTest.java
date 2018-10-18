package fr.lacombe.socrates.pricecalculation;

import fr.lacombe.socrates.pricecalculation.Journey.JourneyBuilder;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceCalculationTest {

    @Test
    public void should_return_accomodation_price_when_complete_price() {
        LocalDateTime checkInAtFirstDayOfConf = LocalDateTime.of(2018, Month.OCTOBER, 18, 18, 0);
        LocalDateTime checkOutAtLastDayOfConf = LocalDateTime.of(2018, Month.OCTOBER, 21, 14, 0);
        Journey completeJourney = new JourneyBuilder()
                .from(checkInAtFirstDayOfConf)
                .to(checkOutAtLastDayOfConf)
                .build();
        Participant participant = Participant.of(completeJourney, RoomChoice.SINGLE);

        int totalPrice = participant.computeParticipationPrice();

        assertThat(totalPrice).isEqualTo(610);
    }

    @Test
    public void should_return_accomodation_price_minus_40_without_one_meal() {
        LocalDateTime checkInOneDayAfterConfBeginning = LocalDateTime.of(2018, Month.OCTOBER, 19, 12, 0);
        LocalDateTime checkOutAtLastDayOfConf = LocalDateTime.of(2018, Month.OCTOBER, 21, 14, 0);
        Journey journey = new JourneyBuilder()
                .from(checkInOneDayAfterConfBeginning)
                .to(checkOutAtLastDayOfConf)
                .build();
        Participant participant = Participant.of(journey, RoomChoice.SINGLE);

        int totalPrice = participant.computeParticipationPrice();

        assertThat(totalPrice).isEqualTo(610 - 40);
    }
}
