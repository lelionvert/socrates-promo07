package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class EventLocationTest {

    @Test
    public void should_return_true_when_the_desk_is_open() {
        final LocalDateTime dateTime = LocalDateTime.of(2018, 10, 18, 21, 30);
        final EventLocation eventLocation = new EventLocation(
                LocalDateTime.of(2018, 10, 18, 21, 0),
                LocalDateTime.of(2018, 10, 19, 0, 1)
        );

        final boolean result = eventLocation.isDeskOpen(dateTime);

        assertThat(result).isTrue();
    }
}
