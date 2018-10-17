package fr.lacombe.socrates;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class VenueTest {

    private Venue venue;

    @Before
    public void setUp() {
        this.venue = new Venue(
                LocalDateTime.of(2018, 10, 18, 21, 0),
                LocalDateTime.of(2018, 10, 19, 0, 1)
        );
    }

    @Test
    public void should_return_true_when_the_time_is_before_desk_closing_time() {
        final LocalDateTime dateTime = LocalDateTime.of(2018, 10, 18, 21, 30);

        final boolean result = venue.isDeskOpen(dateTime);

        assertThat(result).isTrue();
    }

    @Test
    public void should_return_false_when_the_time_is_after_desk_closing_time() {
        final LocalDateTime dateTime = LocalDateTime.of(2018, 10, 19, 1, 0);

        final boolean result = venue.isDeskOpen(dateTime);

        assertThat(result).isFalse();
    }

    @Test
    public void should_return_true_when_the_time_is_after_kitchen_closing_time() {
        final LocalDateTime dateTime = LocalDateTime.of(2018, 10, 18, 21, 30);

        final boolean result = venue.isKitchenClosed(dateTime);

        assertThat(result).isTrue();
    }

    @Test
    public void should_return_false_when_the_time_is_before_kitchen_closing_time() {
        final LocalDateTime dateTime = LocalDateTime.of(2018, 10, 18, 21, 0);

        final boolean result = venue.isKitchenClosed(dateTime);

        assertThat(result).isFalse();
    }
}
