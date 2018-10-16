package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ColdMealManagerTest {

    @Test
    public void should_return_0_cold_meal_without_checkin_time() {
        int result = ColdMealManager.getColdMeals(null);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_1_cold_meal_when_checkin_time_thursday_9_PM_01() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 18, 21, 1);

        int result = ColdMealManager.getColdMeals(checkinDate);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_0_cold_meal_when_checkin_time_thursday_9_PM_00() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 18, 21, 0);

        int result = ColdMealManager.getColdMeals(checkinDate);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_1_cold_meal_when_checkin_time_thursday_9_PM_02() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 18, 21, 2);

        int result = ColdMealManager.getColdMeals(checkinDate);

        assertThat(result).isEqualTo(1);
    }
}
