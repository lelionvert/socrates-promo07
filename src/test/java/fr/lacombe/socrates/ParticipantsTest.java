package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    @Test
    public void should_return_no_cold_meal_when_participants_arrived_before_09PM() {
        //GIVEN
        Participant fred = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 0, 0)));
        Participant ginette = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 20, 7, 0)));

        final Participants participants = Participants.of(fred, ginette);

        //WHEN
        int result = participants.getColdMealNumber();

        assertThat(result).isEqualTo(0);

    }

    @Test
    public void should_return_one_cold_meal_when_one_participant_arrived_after_09PM() {
        //GIVEN
        Participant fred = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 0, 0)));
        Participant ginette = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 1, 0)));

        final Participants participants = Participants.of(fred, ginette);

        //WHEN
        int result = participants.getColdMealNumber();

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_cold_meal_with_multiple_participant() {
        //GIVEN
        Participant fred = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 0, 0)));
        Participant ginette = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 1, 0)));
        Participant paulo = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 0, 0)));
        Participant marion = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 1, 0)));

        final Participants participants = Participants.of(fred, ginette, paulo, marion);

        //WHEN
        int result = participants.getColdMealNumber();

        assertThat(result).isEqualTo(2);
    }
}
