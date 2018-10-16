package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ColdMealTest {

    @Test
    public void should_return_number_of_cold_meal() {
        //GIVEN
        int nbParticipant = 0;

        //WHEN
        int result = ColdMeal.getColdMealCounter(new CheckinDate(nbParticipant));

        //THEN
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_number_of_cold_meal_when_empty_list_of_participant() {
        //GIVEN
        int participantAfter9 = 0;

        //WHEN
        int result = ColdMeal.getColdMealCounter(new CheckinDate(participantAfter9));

        // THEN
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_number_of_cold_meal_when_empty_list_of_participant_1() {
        //GIVEN
        int participantAfter9 = 1;

        //WHEN
        int result = ColdMeal.getColdMealCounter(new CheckinDate(participantAfter9));

        // THEN
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_number_of_cold_meal_when_empty_list_of_participant_2() {
        //GIVEN
        int participantAfter9 = 2;

        //WHEN
        int result = ColdMeal.getColdMealCounter(new CheckinDate(participantAfter9));

        // THEN
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void should_return_number_of_cold_meal_when_empty_list_of_participant_3() {
        //GIVEN
        int participantAfter9 = 3;

        //WHEN
        int result = ColdMeal.getColdMealCounter(new CheckinDate(participantAfter9));

        // THEN
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void should_return_participant_when_add_in_checkin_date() {
        // Given LocalTime
        LocalDate date = LocalDate.of(2018, 10, 18);

        // When
        int result = ColdMeal.getColdMealCounter(CheckinDate.of(date));

        // Then
        assertThat(result).isEqualTo(1);
    }
}
