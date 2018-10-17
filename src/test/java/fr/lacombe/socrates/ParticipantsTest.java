package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    private final LocalDateTime DISTRIBUTION_COLD_MEAL_START_TIME = LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 0, 0);

    private final LocalDateTime DISTRIBUTION_COLD_MEAL_END_TIME = LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 1, 0);

    private final Venue venue = new Venue(DISTRIBUTION_COLD_MEAL_START_TIME, DISTRIBUTION_COLD_MEAL_END_TIME);

    @Test
    public void should_return_no_cold_meal_when_all_participants_arrived_before_start_cold_meal_distribution() {
        //GIVEN
        Participant fred = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 0, 0), venue));
        Participant ginette = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 20, 7, 0), venue));

        final Participants participants = Participants.of(fred, ginette);

        //WHEN
        int result = participants.getColdMealNumber();

        //THEN
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

        //THEN
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void number_of_cold_meals_should_given_by_the_event_venue() {
        //GIVEN
        Participant fred = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 0, 0), venue));
        Participant ginette = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 1, 0), venue));
        Participant paulo = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 0, 0), venue));
        Participant marion = new Participant(CheckInDate.of(LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 1, 0), venue));

        final Participants participants = Participants.of(fred, ginette, paulo, marion);

        //WHEN
        int result = participants.getColdMealNumber();

        //THEN
        assertThat(result).isEqualTo(2);
    }
}
