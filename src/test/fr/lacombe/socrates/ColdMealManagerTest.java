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
    public void should_return_0_cold_meal_when_checkin_time_thursday_before_9_PM_00() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 18, 20, 1);

        int result = ColdMealManager.getColdMeals(checkinDate);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_0_cold_meal_when_checkin_time_thursday_equal_9_PM_00() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 18, 21, 0);

        int result = ColdMealManager.getColdMeals(checkinDate);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_1_cold_meal_when_checkin_time_thursday_after_9_PM() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 18, 21, 1);

        int result = ColdMealManager.getColdMeals(checkinDate);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_1_cold_meal_when_checkin_time_thursday_22_PM_00() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 18, 22, 0);

        int result = ColdMealManager.getColdMeals(checkinDate);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_1_cold_meal_when_checkin_time_thursday_23_PM_00() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 18, 23, 0);

        int result = ColdMealManager.getColdMeals(checkinDate);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_1_cold_meal_when_checkin_time_friday_00_PM_00() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 19, 0, 0);

        int result = ColdMealManager.getColdMeals(checkinDate);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_0_cold_meal_when_checkin_time_friday_00_PM_01() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 19, 0, 1);

        int result = ColdMealManager.getColdMeals(checkinDate);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_0_cold_meal_when_checkin_time_friday_01_PM_00() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 19, 1, 0);

        int result = ColdMealManager.getColdMeals(checkinDate);

        assertThat(result).isEqualTo(0);
    }
}
