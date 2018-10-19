package fr.lacombe.socrates.price;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(JUnitParamsRunner.class)
public class PriceCalculatorTest {

    @Parameters({"SINGLE, 610", "DOUBLE, 510", "TRIPLE, 410", "NONE, 240"})
    @Test
    public void should_calculate_accommodation_price_without_missed_meal(Accommodation accommodation, int accommodationPrice) {
        PriceCalculator priceCalculator = new PriceCalculator(accommodation, MissedMeals.NONE);

        Price price = priceCalculator.calculatePrice();

        assertThat(price).isEqualTo(Price.of(accommodationPrice));
    }

    @Parameters({"1, 570", "2, 530"})
    @Test
    public void should_calculate_the_price_for_single_accommodation_with_missed_meals(int numberOfMeals, int expectedPrice) {
        PriceCalculator priceCalculator = new PriceCalculator(Accommodation.SINGLE, new MissedMeals(numberOfMeals));

        Price price = priceCalculator.calculatePrice();

        assertThat(price).isEqualTo(Price.of(expectedPrice));
    }
}
