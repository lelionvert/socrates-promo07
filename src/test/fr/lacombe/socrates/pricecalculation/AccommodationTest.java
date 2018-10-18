package fr.lacombe.socrates.pricecalculation;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccommodationTest {

    @Test
    public void should_compute_accommodation_price_with_all_meals_and_single_room() {
        int numberOfMissingMeals = 0;
        int mealPrice = 40;
        Accommodation singleAccommodation = Accommodation.SINGLE;

        int totalPrice = singleAccommodation.computeParticipationPrice(numberOfMissingMeals, mealPrice);

        assertThat(totalPrice).isEqualTo(610);
    }

    @Test
    public void should_compute_accommodation_price_with_all_meals_and_double_room() {
        int numberOfMissingMeals = 0;
        int mealPrice = 40;
        Accommodation doubleAccommodation = Accommodation.DOUBLE;

        int totalPrice = doubleAccommodation.computeParticipationPrice(numberOfMissingMeals, mealPrice);

        assertThat(totalPrice).isEqualTo(510);
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
