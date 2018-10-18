package fr.lacombe.socrates.pricecalculation;

import fr.lacombe.socrates.pricecalculation.Journey.JourneyBuilder;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceCalculationTest {

    @Test
    public void should_return_accomodation_price_when_complete_price_single_room() {
        LocalDateTime checkInAtFirstDayOfConf = LocalDateTime.of(2018, Month.OCTOBER, 18, 18, 0);
        LocalDateTime checkOutAtLastDayOfConf = LocalDateTime.of(2018, Month.OCTOBER, 21, 14, 0);
        Journey completeJourney = new JourneyBuilder()
                .from(checkInAtFirstDayOfConf)
                .to(checkOutAtLastDayOfConf)
                .build();
        Participant participant = Participant.of(completeJourney, HostelBill.SINGLE);

        int totalPrice = participant.computeParticipationPrice();

        assertThat(totalPrice).isEqualTo(610);
    }

    @Test
    public void should_return_accomodation_price_when_complete_price_double_room() {
        LocalDateTime checkInAtFirstDayOfConf = LocalDateTime.of(2018, Month.OCTOBER, 18, 18, 0);
        LocalDateTime checkOutAtLastDayOfConf = LocalDateTime.of(2018, Month.OCTOBER, 21, 14, 0);
        Journey completeJourney = new JourneyBuilder()
                .from(checkInAtFirstDayOfConf)
                .to(checkOutAtLastDayOfConf)
                .build();
        Participant participant = Participant.of(completeJourney, HostelBill.DOUBLE);

        int totalPrice = participant.computeParticipationPrice();

        assertThat(totalPrice).isEqualTo(510);
    }

    @Test
    public void should_return_accomodation_price_minus_40_without_one_meal() {
        LocalDateTime checkInOneDayAfterConfBeginning = LocalDateTime.of(2018, Month.OCTOBER, 19, 12, 0);
        LocalDateTime checkOutAtLastDayOfConf = LocalDateTime.of(2018, Month.OCTOBER, 21, 14, 0);
        Journey journeyMinusOneDay = new JourneyBuilder()
                .from(checkInOneDayAfterConfBeginning)
                .to(checkOutAtLastDayOfConf)
                .build();
        Participant participant = Participant.of(journeyMinusOneDay, HostelBill.SINGLE);

        int totalPrice = participant.computeParticipationPrice();

        assertThat(totalPrice).isEqualTo(610 - 40);
    }

    @Test
    public void should_return_accomodation_price_minus_40_without_one_meal2() {
        LocalDateTime checkInAtFirstDayOfConf = LocalDateTime.of(2018, Month.OCTOBER, 18, 18, 0);
        LocalDateTime checkOutOneDayBeforeConfEnding = LocalDateTime.of(2018, Month.OCTOBER, 20, 18, 0);
        Journey journeyMinusOneDay = new JourneyBuilder()
                .from(checkInAtFirstDayOfConf)
                .to(checkOutOneDayBeforeConfEnding)
                .build();
        Participant participant = Participant.of(journeyMinusOneDay, HostelBill.SINGLE);

        int totalPrice = participant.computeParticipationPrice();

        assertThat(totalPrice).isEqualTo(610 - 40);
    }
}
