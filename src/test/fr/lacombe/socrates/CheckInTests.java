package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckInTests {
    
    private TestKitchenCloseTimeProvider provider = new TestKitchenCloseTimeProvider();

    @Test
    public void should_return_false_when_checkin_time_is_null() {
        CheckIn checkIn = new CheckIn(null);

        boolean result = checkIn.isInKitchenClosePeriod(provider.getStartTime(), provider.getEndTime());

        assertThat(result).isFalse();
    }

    @Test
    public void should_return_false_when_checkin_time_is_before_kitchen_close_start_time() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 18, 20, 1);
        CheckIn checkIn = new CheckIn(checkinDate);

        boolean result = checkIn.isInKitchenClosePeriod(provider.getStartTime(), provider.getEndTime());

        assertThat(result).isFalse();
    }

    @Test
    public void should_return_false_when_checkin_time_is_equal_to_kitchen_close_start_time() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 18, 21, 0);
        CheckIn checkIn = new CheckIn(checkinDate);

        boolean result = checkIn.isInKitchenClosePeriod(provider.getStartTime(), provider.getEndTime());

        assertThat(result).isFalse();
    }

    @Test
    public void should_return_true_when_checkin_time_is_between_kitchen_close_time() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 18, 21, 1);
        CheckIn checkIn = new CheckIn(checkinDate);

        boolean result = checkIn.isInKitchenClosePeriod(provider.getStartTime(), provider.getEndTime());

        assertThat(result).isTrue();
    }

    @Test
    public void should_return_true_when_checkin_time_is_equal_to_kitchen_close_end_time() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 19, 0, 0);
        CheckIn checkIn = new CheckIn(checkinDate);

        boolean result = checkIn.isInKitchenClosePeriod(provider.getStartTime(), provider.getEndTime());

        assertThat(result).isTrue();
    }

    @Test
    public void should_return_false_when_checkin_time_is_after_kitchen_close_end_time() {
        LocalDateTime checkinDate = LocalDateTime.of(2018, 10, 19, 0, 1);
        CheckIn checkIn = new CheckIn(checkinDate);

        boolean result = checkIn.isInKitchenClosePeriod(provider.getStartTime(), provider.getEndTime());

        assertThat(result).isFalse();
    }
}
