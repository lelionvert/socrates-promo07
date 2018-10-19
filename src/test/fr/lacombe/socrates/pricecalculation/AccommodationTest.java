package fr.lacombe.socrates.pricecalculation;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AccommodationTest {



    @Parameters({
            "SINGLE, 610",
            "DOUBLE, 510",
            "TRIPLE, 410",
            "NO_ACCOMMODATION, 240"
    })
    @Test
    public void should_compute_accommodation_price_with_all_meals(Accommodation accommodation, int accommodationPrice) {
        int numberOfMissingMeals = 0;
        int mealPrice = 40;

        int totalPrice = accommodation.computeParticipationPrice(numberOfMissingMeals, mealPrice);

        assertThat(totalPrice).isEqualTo(accommodationPrice);
    }

    @Test
    public void should_compute_accommodation_price_without_first_meal() {
        int numberOfMissingMeals = 1;
        int mealPrice = 40;
        Accommodation singleAccommodation = Accommodation.SINGLE;

        int totalPrice = singleAccommodation.computeParticipationPrice(numberOfMissingMeals, mealPrice);

        assertThat(totalPrice).isEqualTo(610 - 40);
    }

    @Test
    public void should_compute_accommodation_price_without_first_and_last_meals() {
        int numberOfMissingMeals = 2;
        int mealPrice = 40;
        Accommodation singleAccommodation = Accommodation.SINGLE;

        int totalPrice = singleAccommodation.computeParticipationPrice(numberOfMissingMeals, mealPrice);

        assertThat(totalPrice).isEqualTo(610 - (2 * 40));
    }
}
