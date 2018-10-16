package fr.lacombe.socrates;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ColdMealTest {

    @Test
    public void should_return_number_of_cold_meal() {
        //GIVEN
        int nbParticipant = 0;

        //WHEN
        int result = ColdMeal.getColdMealCounter(nbParticipant);

        //THEN
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_number_of_cold_meal_when_empty_list_of_participant() {
        //GIVEN
        int participantBefore9 = 0;
        int participantAfter9 = 0;

        //WHEN
        int result = ColdMeal.getColdMealCounter2(participantBefore9, participantAfter9);

        // THEN
        Assertions.assertThat(result).isEqualTo(0);
    }
}
