package fr.lacombe.socrates.pricecalculation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PriceCalculationTest {

    @Test
    public void should_return_accomodation_price_when_complete_price_single_room() {
        // GIVEN
        int accomodationPrice = 610;
        PriceCalculation priceCalculation = new PriceCalculation();

        // WHEN
        int result = priceCalculation.compute(accomodationPrice);

        // THEN
        Assertions.assertThat(result).isEqualTo(accomodationPrice);
    }
}
