package fr.lacombe.socrates.covers_participants;

import fr.lacombe.socrates.diets.Diet;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class CoversCalculatorTest {

    @Test
    public void should_calculate_the_number_of_covers_for_one_participant() {
        final Participant participant = Participant.of(
                Email.of("toto@toto.fr"),
                Diet.PESCETARIAN,
                LocalDateTime.of(2018, Month.NOVEMBER, 2, 10, 0),
                LocalDateTime.of(2018, Month.NOVEMBER, 4, 15, 0)
        );

        final int result = new CoversCalculator().calculateCovers(participant);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void should_calculate_the_number_of_covers_for_one_participant_2() {
        final Participant participant = Participant.of(
                Email.of("toto@toto.fr"),
                Diet.PESCETARIAN,
                LocalDateTime.of(2018, Month.NOVEMBER, 1, 18, 0),
                LocalDateTime.of(2018, Month.NOVEMBER, 4, 15, 0)
        );

        final int result = new CoversCalculator().calculateCovers(participant);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void should_calculate_the_number_of_hot_and_cold_covers_for_one_participant() {
        final Participant participant = Participant.of(
                Email.of("toto@toto.fr"),
                Diet.PESCETARIAN,
                LocalDateTime.of(2018, Month.NOVEMBER, 2, 10, 0),
                LocalDateTime.of(2018, Month.NOVEMBER, 4, 15, 0)
        );

        final Covers result = new CoversCalculator().compute(participant);

        assertThat(result).isEqualTo(Covers.of(0, 5));
    }
}
