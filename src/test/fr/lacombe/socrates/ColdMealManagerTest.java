package fr.lacombe.socrates;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ColdMealManagerTest {

    @Test
    public void should_return_0_cold_meal_without_checkin_time() {
        int result = ColdMealManager.getColdMeals();

        assertThat(result).isEqualTo(0);
    }
}
