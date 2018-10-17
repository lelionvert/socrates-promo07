package fr.lacombe.socrates;

import fr.lacombe.socrates.CheckInDateTest.CheckInDateMock;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {

    @Test
    public void francis_should_not_have_a_cold_meal_at_19h45() {
        final CheckInDateMock checkInDate = new CheckInDateMock(LocalDateTime.of(2018, 10, 18, 19, 45));
        final Participant participant = new Participant("Francis", checkInDate);

        checkInDate.whenCallingIsThursdayEveningThenReturn(false);

        final boolean result = participant.hasColdMeal();

        assertThat(result).isFalse();
    }

    @Test
    public void paula_should_have_a_cold_meal_at_21h01() {
        final CheckInDateMock checkInDate = new CheckInDateMock(LocalDateTime.of(2018, 10, 18, 21, 1));
        final Participant participant = new Participant("Paula", checkInDate);

        checkInDate.whenCallingIsThursdayEveningThenReturn(true);

        final boolean result = participant.hasColdMeal();

        assertThat(result).isTrue();
    }

}
