package fr.lacombe.socrates;

import fr.lacombe.socrates.CheckInDateTest.CheckInDateMock;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;
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
        final CheckInDateMock canHaveColdMeal = new CheckInDateMock(LocalDateTime.of(2018, 10, 18, 22, 0));
        final CheckInDateMock cannotHaveColdMeal = new CheckInDateMock(LocalDateTime.of(2018, 10, 19, 0, 30));

        canHaveColdMeal.whenCallingIsThursdayEveningThenReturn(true);
        cannotHaveColdMeal.whenCallingIsThursdayEveningThenReturn(false);

        final List<Participant> listParticipants = asList(
                new Participant("Fabien", canHaveColdMeal),
                new Participant("Ismaïl", canHaveColdMeal),
                new Participant("Houssam", cannotHaveColdMeal)
        );
        final Participants participants = Participants.of(listParticipants);

        final long result = participants.countColdMeals();

        assertThat(result).isEqualTo(2);
    }
}
