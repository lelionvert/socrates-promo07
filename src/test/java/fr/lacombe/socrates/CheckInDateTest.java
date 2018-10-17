package fr.lacombe.socrates;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckInDateTest {

    private Venue venue;

    @Before
    public void setUp() {
        this.venue = new Venue(
                LocalDateTime.of(2018, 10, 18, 21, 0),
                LocalDateTime.of(2018, 10, 19, 0, 1)
        );
    }

    @Test
    public void should_not_be_thursday_evening_before_starting_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 18, 19, 45));

        final boolean result = checkInDate.isColdMealTime(venue);

        assertThat(result).isFalse();
    }

    @Test
    public void should_not_be_thursday_evening_after_ending_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 19, 0, 1));

        final boolean result = checkInDate.isColdMealTime(venue);

        assertThat(result).isFalse();
    }

    @Test
    public void should_not_be_thursday_evening_at_exactly_starting_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 18, 21, 0));

        final boolean result = checkInDate.isColdMealTime(venue);

        assertThat(result).isFalse();
    }

    @Test
    public void should_not_be_thursday_evening_when_it_is_another_day_of_week() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 17, 23, 30));

        final boolean result = checkInDate.isColdMealTime(venue);

        assertThat(result).isFalse();
    }

    @Test
    public void should_be_thursday_evening_just_after_starting_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 18, 21, 1));

        final boolean result = checkInDate.isColdMealTime(venue);

        assertThat(result).isTrue();
    }

    @Test
    public void should_be_thursday_evening_just_before_ending_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 19, 0, 0));

        final boolean result = checkInDate.isColdMealTime(venue);

        assertThat(result).isTrue();
    }
}