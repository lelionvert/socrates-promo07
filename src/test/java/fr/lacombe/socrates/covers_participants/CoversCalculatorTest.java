package fr.lacombe.socrates.covers_participants;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoversCalculatorTest {

    @Test
    public void should_calculate_the_number_of_covers_for_one_participant() {
        final Email email = Email.of("toto@toto.fr");

        final int result = new CoversCalculator().calculateCovers(email);

        assertThat(result).isEqualTo(5);
    }
}
