package fr.lacombe.socrates;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckInDateTest {

    @Test
    public void should_not_be_thursday_evening() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 18, 19, 45));

        final boolean result = checkInDate.isThursdayEvening();

        assertThat(result).isFalse();
    }

    @Test
    public void should_not_be_thursday_evening_1() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 19, 0, 1));

        final boolean result = checkInDate.isThursdayEvening();

        assertThat(result).isFalse();
    }

    @Test
    public void should_not_be_thursday_evening_2() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 18, 21, 0));

        final boolean result = checkInDate.isThursdayEvening();

        assertThat(result).isFalse();
    }

    @Test
    public void should_not_be_thursday_evening_3() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 18, 20, 1));

        final boolean result = checkInDate.isThursdayEvening();

        assertThat(result).isFalse();
    }

    @Test
    public void should_be_thursday_evening() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 18, 21, 1));

        final boolean result = checkInDate.isThursdayEvening();

        assertThat(result).isTrue();
    }

    @Test
    public void should_be_thursday_evening_1() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 19, 0, 0));

        final boolean result = checkInDate.isThursdayEvening();

        assertThat(result).isTrue();
    }

    @Test
    public void should_be_thursday_evening_2() {
        final CheckInDate checkInDate = new CheckInDate(LocalDateTime.of(2018, 10, 18, 22, 0));

        final boolean result = checkInDate.isThursdayEvening();

        assertThat(result).isTrue();

    }
}