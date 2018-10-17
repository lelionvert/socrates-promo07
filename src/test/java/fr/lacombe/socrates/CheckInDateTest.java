package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckInDateTest {

    static class CheckInDateMock extends CheckInDate {

        private boolean isThursdayEvening;

        CheckInDateMock(final LocalDateTime dateTime) {
            super(dateTime);
        }

        void whenCallingIsThursdayEveningThenReturn(final boolean isThursdayEvening) {
            this.isThursdayEvening = isThursdayEvening;
        }

        @Override
        boolean isThursdayEvening() {
            return isThursdayEvening;
        }
    }

    @Test
    public void should_not_be_thursday_evening_before_starting_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 18, 19, 45));

        final boolean result = checkInDate.isThursdayEvening();

        assertThat(result).isFalse();
    }

    @Test
    public void should_not_be_thursday_evening_after_ending_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 19, 0, 1));

        final boolean result = checkInDate.isThursdayEvening();

        assertThat(result).isFalse();
    }

    @Test
    public void should_not_be_thursday_evening_at_exactly_starting_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 18, 21, 0));

        final boolean result = checkInDate.isThursdayEvening();

        assertThat(result).isFalse();
    }

    @Test
    public void should_not_be_thursday_evening_when_it_is_another_day_of_week() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 17, 23, 30));

        final boolean result = checkInDate.isThursdayEvening();

        assertThat(result).isFalse();
    }

    @Test
    public void should_be_thursday_evening_just_after_starting_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 18, 21, 1));

        final boolean result = checkInDate.isThursdayEvening();

        assertThat(result).isTrue();
    }

    @Test
    public void should_be_thursday_evening_just_before_ending_hour() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 19, 0, 0));

        final boolean result = checkInDate.isThursdayEvening();

        assertThat(result).isTrue();
    }
}