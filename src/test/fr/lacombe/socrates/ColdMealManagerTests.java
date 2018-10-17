package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ColdMealManagerTests {

    class CheckInFalseMock extends CheckIn {

        public CheckInFalseMock() {
            super(null);
        }

        @Override
        boolean isInKitchenClosePeriod(LocalDateTime kitchenCloseStartTime, LocalDateTime kitchenCloseEndTime) {
            return false;
        }
    }

    class CheckInTrueMock extends CheckIn {

        public CheckInTrueMock() {
            super(null);
        }

        @Override
        boolean isInKitchenClosePeriod(LocalDateTime kitchenCloseStartTime, LocalDateTime kitchenCloseEndTime) {
            return true;
        }
    }

    private TestKitchenCloseTimeProvider provider = new TestKitchenCloseTimeProvider();

    @Test
    public void should_return_0_cold_meal_when_no_checkins() {
        ColdMealManager coldMealManager = ColdMealManager.of(provider);

        long result = coldMealManager.getNumberOfColdMeals();

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_1_cold_meal_when_checkin_is_in_kitchen_close_period() {
        CheckIn checkIn = new CheckInTrueMock();
        ColdMealManager coldMealManager = ColdMealManager.of(provider, checkIn);

        long result = coldMealManager.getNumberOfColdMeals();

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_0_cold_meal_when_checkin_is_not_in_kitchen_close_period() {
        CheckIn checkIn = new CheckInFalseMock();
        ColdMealManager coldMealManager = ColdMealManager.of(provider, checkIn);

        long result = coldMealManager.getNumberOfColdMeals();

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_2_cold_meals_when_2_participants_have_cold_meal() {
        CheckIn checkIn1 = new CheckInTrueMock();
        CheckIn checkIn2 = new CheckInTrueMock();
        ColdMealManager coldMealManager = ColdMealManager.of(provider, checkIn1, checkIn2);

        long result = coldMealManager.getNumberOfColdMeals();

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void should_return_1_cold_meals_when_1_participant_has_cold_meal_and_1_participant_has_no_cold_meal() {
        CheckIn checkInTrue = new CheckInTrueMock();
        CheckIn checkInFalse = new CheckInFalseMock();
        ColdMealManager coldMealManager = ColdMealManager.of(provider, checkInTrue, checkInFalse);

        long result = coldMealManager.getNumberOfColdMeals();

        assertThat(result).isEqualTo(1);
    }


}
