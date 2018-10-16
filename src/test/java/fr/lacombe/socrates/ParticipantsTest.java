package fr.lacombe.socrates;

import org.junit.Test;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    @Test
    public void should_not_serve_any_meal_when_there_is_no_participants() {
        final Participants participants = Participants.of(emptyList());

        final int result = participants.countColdMeals();

        assertThat(result).isEqualTo(0);

    }
}
