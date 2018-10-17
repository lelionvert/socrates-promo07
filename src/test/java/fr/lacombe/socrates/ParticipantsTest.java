package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    private final LocalDateTime KITCHEN_CLOSE_TIME = LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 0, 0);

    private final LocalDateTime RECEPTION_CLOSE_TIME = LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 1, 0);

    private final Venue venue = new Venue(KITCHEN_CLOSE_TIME, RECEPTION_CLOSE_TIME);

    @Test
    public void should_return_no_cold_meal_when_participants_arrived_before_start_cold_meal_distribution() {
        //GIVEN
        Participant fred = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 0, 0), venue));
        Participant ginette = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 20, 7, 0), venue));

        final Participants participants = Participants.of(fred, ginette);

        //WHEN
        int result = participants.getColdMealNumber();

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_one_cold_meal_when_one_participant_arrived_before_start_cold_meal_distribution() {
        //GIVEN
        Participant fred = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 0, 0), venue));
        Participant ginette = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 1, 0), venue));

        final Participants participants = Participants.of(fred, ginette);

        //WHEN
        int result = participants.getColdMealNumber();

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_cold_meal_with_multiple_participants() {
        //GIVEN
        Participant fred = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 0, 0), venue));
        Participant ginette = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 1, 0), venue));
        Participant paulo = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 0, 0), venue));
        Participant marion = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 1, 0), venue));

        final Participants participants = Participants.of(fred, ginette, paulo, marion);

        //WHEN
        int result = participants.getColdMealNumber();

        assertThat(result).isEqualTo(2);
    }
}
