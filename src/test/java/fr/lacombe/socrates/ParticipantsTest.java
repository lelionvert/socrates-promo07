package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    @Test
    public void should_not_serve_any_meal_when_there_is_no_participants() {
        final Participants participants = Participants.of(emptyList());

        final long result = participants.countColdMeals();

        assertThat(result).isEqualTo(0);

    }

    @Test
    public void should_return_correct_number_of_cold_meals() {
        final List<Participant> listParticipants = Arrays.asList(
                new Participant("Fabien",
                        new CheckInDate(LocalDateTime.of(2018, 10, 18, 22, 0))),
                new Participant("Ismaïl",
                        new CheckInDate(LocalDateTime.of(2018, 10, 18, 22, 0))),
                new Participant("Houssam",
                        new CheckInDate(LocalDateTime.of(2018, 10, 19, 0, 30))));

        final Participants participants = Participants.of(listParticipants);

        final long result = participants.countColdMeals();

        assertThat(result).isEqualTo(2);

    }
}
