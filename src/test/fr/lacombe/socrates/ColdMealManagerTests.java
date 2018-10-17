package fr.lacombe.socrates;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ColdMealManagerTests {

    class ParticipantHasColdMeal extends Participant {

        public ParticipantHasColdMeal() {
            super(null, null);
        }

        @Override
        public boolean hasColdMeal() {
            return true;
        }
    }

    class ParticipantHasNoColdMeal extends Participant {

        public ParticipantHasNoColdMeal() {
            super(null, null);
        }

        @Override
        public boolean hasColdMeal() {
            return false;
        }
    }

    @Test
    public void should_return_0_cold_meal_when_no_participant() {
        ColdMealManager coldMealManager = ColdMealManager.of();

        int result = coldMealManager.getNumberOfColdMeals();

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_1_cold_meal_when_one_participant_has_cold_meal() {
        Participant participant = new ParticipantHasColdMeal();
        ColdMealManager coldMealManager = ColdMealManager.of(participant);

        int result = coldMealManager.getNumberOfColdMeals();

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_0_cold_meal_when_one_participant_has_no_cold_meal() {
        Participant participant = new ParticipantHasNoColdMeal();
        ColdMealManager coldMealManager = ColdMealManager.of(participant);

        int result = coldMealManager.getNumberOfColdMeals();

        assertThat(result).isEqualTo(0);
    }
}
