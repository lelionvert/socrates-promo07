package fr.lacombe.socrates;

import fr.lacombe.socrates.resources.TestKitchenCloseTimeProvider;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckInTests {
    
    private TestKitchenCloseTimeProvider kitchenCloseTimeProvider = new TestKitchenCloseTimeProvider();

    @Test
    public void should_return_false_when_checkIn_time_is_null() {
        CheckIn checkIn = new CheckIn(null);

        boolean result = checkIn.isInKitchenClosePeriod(kitchenCloseTimeProvider.getStartTime(), kitchenCloseTimeProvider.getEndTime());

        assertThat(result).isFalse();
    }

    @Test
    public void should_return_false_when_checkIn_time_is_before_kitchen_close_start_time() {
        LocalDateTime checkInDate = LocalDateTime.of(2018, 10, 18, 20, 1);
        CheckIn checkIn = new CheckIn(checkInDate);

        boolean result = checkIn.isInKitchenClosePeriod(kitchenCloseTimeProvider.getStartTime(), kitchenCloseTimeProvider.getEndTime());

        assertThat(result).isFalse();
    }

    @Test
    public void should_return_false_when_checkIn_time_is_equal_to_kitchen_close_start_time() {
        LocalDateTime checkInDate = LocalDateTime.of(2018, 10, 18, 21, 0);
        CheckIn checkIn = new CheckIn(checkInDate);

        boolean result = checkIn.isInKitchenClosePeriod(kitchenCloseTimeProvider.getStartTime(), kitchenCloseTimeProvider.getEndTime());

        assertThat(result).isFalse();
    }

    @Test
    public void should_return_true_when_checkIn_time_is_between_kitchen_close_time() {
        LocalDateTime checkInDate = LocalDateTime.of(2018, 10, 18, 21, 1);
        CheckIn checkIn = new CheckIn(checkInDate);

        boolean result = checkIn.isInKitchenClosePeriod(kitchenCloseTimeProvider.getStartTime(), kitchenCloseTimeProvider.getEndTime());

        assertThat(result).isTrue();
    }

    @Test
    public void should_return_true_when_checkIn_time_is_equal_to_kitchen_close_end_time() {
        LocalDateTime checkInDate = LocalDateTime.of(2018, 10, 19, 0, 0);
        CheckIn checkIn = new CheckIn(checkInDate);

        boolean result = checkIn.isInKitchenClosePeriod(kitchenCloseTimeProvider.getStartTime(), kitchenCloseTimeProvider.getEndTime());

        assertThat(result).isTrue();
    }

    @Test
    public void should_return_false_when_checkIn_time_is_after_kitchen_close_end_time() {
        LocalDateTime checkInDate = LocalDateTime.of(2018, 10, 19, 0, 1);
        CheckIn checkIn = new CheckIn(checkInDate);

        boolean result = checkIn.isInKitchenClosePeriod(kitchenCloseTimeProvider.getStartTime(), kitchenCloseTimeProvider.getEndTime());

        assertThat(result).isFalse();
    }
}
