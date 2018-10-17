package fr.lacombe.socrates;

import fr.lacombe.socrates.mock.VenueMock;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckInDateTest {

    private VenueMock venue;

    @Before
    public void setUp() {
        this.venue = new VenueMock(
                LocalDateTime.of(2018, 10, 18, 21, 0),
                LocalDateTime.of(2018, 10, 19, 0, 1)
        );
    }

    @Test
    public void should_not_be_thursday_evening_before_starting_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 18, 19, 45));
        venue.whenCallingIsDeskOpenThenReturn(true);
        venue.whenCallingIsKitchenClosedThenReturn(false);

        final boolean result = checkInDate.isColdMealTime(venue);

        assertThat(result).isFalse();
    }

    @Test
    public void should_not_be_thursday_evening_after_ending_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 19, 0, 1));
        venue.whenCallingIsDeskOpenThenReturn(false);
        venue.whenCallingIsKitchenClosedThenReturn(true);

        final boolean result = checkInDate.isColdMealTime(venue);

        assertThat(result).isFalse();
    }

    @Test
    public void should_not_be_thursday_evening_at_exactly_starting_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 18, 21, 0));
        venue.whenCallingIsDeskOpenThenReturn(true);
        venue.whenCallingIsKitchenClosedThenReturn(false);

        final boolean result = checkInDate.isColdMealTime(venue);

        assertThat(result).isFalse();
    }

    @Test
    public void should_not_be_thursday_evening_when_it_is_another_day_of_week() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 17, 23, 30));
        venue.whenCallingIsDeskOpenThenReturn(true);
        venue.whenCallingIsKitchenClosedThenReturn(false);

        final boolean result = checkInDate.isColdMealTime(venue);

        assertThat(result).isFalse();
    }

    @Test
    public void should_be_thursday_evening_just_after_starting_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 18, 21, 1));
        venue.whenCallingIsDeskOpenThenReturn(true);
        venue.whenCallingIsKitchenClosedThenReturn(true);

        final boolean result = checkInDate.isColdMealTime(venue);

        assertThat(result).isTrue();
    }

    @Test
    public void should_be_thursday_evening_just_before_ending_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 19, 0, 0));
        venue.whenCallingIsDeskOpenThenReturn(true);
        venue.whenCallingIsKitchenClosedThenReturn(true);

        final boolean result = checkInDate.isColdMealTime(venue);

        assertThat(result).isTrue();
    }
}