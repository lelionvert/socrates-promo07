package fr.lacombe.socrates;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    @Test
    public void should_return_zero_meals_if_no_participants() {
        int numberParticipants = 0;
        int expectedColdMeals = 0;

        int coldMeals = Participants.getColdMealsCount(numberParticipants);

        assertThat(coldMeals).isEqualTo(expectedColdMeals);
    }

    @Test
    public void should_return_one_meal_when_one_participant() {
        int numberParticipants = 1;
        int expectedColdMeals = 1;

        int coldMeals = Participants.getColdMealsCount(numberParticipants);

        assertThat(coldMeals).isEqualTo(expectedColdMeals);
    }
}
