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
    public void calculate_the_price_without_missed_meal_reduction(Accommodation accommodation, int accommodationPrice) {
        Participant participant = new Participant(accommodation);

        Price price = participant.duePrice(new MissedMeals(0));

        assertThat(price).isEqualTo(Price.of(accommodationPrice));
    }

    @Parameters({"1, 570", "2, 530"})
    @Test
    public void calculate_the_price_for_single_accommodation_with_missed_meal_reduction(int numberOfMeals, int expectedPrice) {
        Participant participant = new Participant(Accommodation.SINGLE);

        Price price = participant.duePrice(new MissedMeals(numberOfMeals));

        assertThat(price).isEqualTo(Price.of(expectedPrice));
    }
}
