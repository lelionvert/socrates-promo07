package fr.lacombe.socrates;

import fr.lacombe.socrates.resources.TestKitchenCloseTimeProvider;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class KitchenTests {

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

    private TestKitchenCloseTimeProvider kitchenCloseTimeProvider = new TestKitchenCloseTimeProvider();

    @Test
    public void should_return_0_cold_meal_when_no_checkIns() {
        Kitchen kitchen = Kitchen.of(kitchenCloseTimeProvider);

        long result = kitchen.getNumberOfColdMeals();

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_1_cold_meal_when_one_checkIn_is_in_kitchen_close_period() {
        CheckIn checkIn = new CheckInTrueMock();
        Kitchen kitchen = Kitchen.of(kitchenCloseTimeProvider, checkIn);

        long result = kitchen.getNumberOfColdMeals();

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_0_cold_meal_when_one_checkIn_is_not_in_kitchen_close_period() {
        CheckIn checkIn = new CheckInFalseMock();
        Kitchen kitchen = Kitchen.of(kitchenCloseTimeProvider, checkIn);

        long result = kitchen.getNumberOfColdMeals();

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_2_cold_meals_when_2_checkIns_are_in_kitchen_close_period() {
        CheckIn checkIn1 = new CheckInTrueMock();
        CheckIn checkIn2 = new CheckInTrueMock();
        Kitchen kitchen = Kitchen.of(kitchenCloseTimeProvider, checkIn1, checkIn2);

        long result = kitchen.getNumberOfColdMeals();

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void should_return_1_cold_meals_when_1_checkIn_is_in_kitchen_close_period_and_one_is_not() {
        CheckIn checkInTrue = new CheckInTrueMock();
        CheckIn checkInFalse = new CheckInFalseMock();
        Kitchen kitchen = Kitchen.of(kitchenCloseTimeProvider, checkInTrue, checkInFalse);

        long result = kitchen.getNumberOfColdMeals();

        assertThat(result).isEqualTo(1);
    }


}
