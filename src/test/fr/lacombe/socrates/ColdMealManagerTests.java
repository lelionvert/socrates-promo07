package fr.lacombe.socrates;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ColdMealManagerTests {

    @Test
    public void should_return_0_cold_meal_when_no_participant() {
        ColdMealManager coldMealManager = ColdMealManager.of();

        int result = coldMealManager.getNumberOfColdMeals();

        assertThat(result).isEqualTo(0);
    }
}
