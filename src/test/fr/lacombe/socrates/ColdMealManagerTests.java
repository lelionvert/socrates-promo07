package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ColdMealManagerTests {

    class ParticipantHasColdMeal extends Participant {

        public ParticipantHasColdMeal() {
            super(null, null);
        }

        @Override
        public boolean hasColdMeal(LocalDateTime kitchenCloseStartTime, LocalDateTime kitchenCloseEndTime) {
            return true;
        }
    }

    class ParticipantHasNoColdMeal extends Participant {

        public ParticipantHasNoColdMeal() {
            super(null, null);
        }

        @Override
        public boolean hasColdMeal(LocalDateTime kitchenCloseStartTime, LocalDateTime kitchenCloseEndTime) {
            return false;
        }
    }

    private TestKitchenCloseTimeProvider provider = new TestKitchenCloseTimeProvider();

    @Test
    public void should_return_0_cold_meal_when_no_participant() {
        ColdMealManager coldMealManager = ColdMealManager.of(provider);

        long result = coldMealManager.getNumberOfColdMeals();

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_1_cold_meal_when_one_participant_has_cold_meal() {
        Participant participant = new ParticipantHasColdMeal();
        ColdMealManager coldMealManager = ColdMealManager.of(provider, participant);

        long result = coldMealManager.getNumberOfColdMeals();

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_0_cold_meal_when_one_participant_has_no_cold_meal() {
        Participant participant = new ParticipantHasNoColdMeal();
        ColdMealManager coldMealManager = ColdMealManager.of(provider, participant);

        long result = coldMealManager.getNumberOfColdMeals();

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_2_cold_meals_when_2_participants_have_cold_meal() {
        Participant participant1 = new ParticipantHasColdMeal();
        Participant participant2 = new ParticipantHasColdMeal();
        ColdMealManager coldMealManager = ColdMealManager.of(provider, participant1, participant2);

        long result = coldMealManager.getNumberOfColdMeals();

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void should_return_1_cold_meals_when_1_participant_has_cold_meal_and_1_participant_has_no_cold_meal() {
        Participant participant1 = new ParticipantHasColdMeal();
        Participant participant2 = new ParticipantHasNoColdMeal();
        ColdMealManager coldMealManager = ColdMealManager.of(provider, participant1, participant2);

        long result = coldMealManager.getNumberOfColdMeals();

        assertThat(result).isEqualTo(1);
    }


}
