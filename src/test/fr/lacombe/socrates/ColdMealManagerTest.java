package fr.lacombe.socrates;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ColdMealManagerTest {

    @Test
    public void should_return_0_cold_meal_when_0_participant() {
        //when
        int result = ColdMealManager.getColdMeals();

        //then
        assertThat(result).isEqualTo(0);
    }
}
