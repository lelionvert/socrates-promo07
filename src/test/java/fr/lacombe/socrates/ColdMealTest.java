package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class ColdMealTest {



    @Test
    public void should_return_no_participant_when_it_is_between_9PM_00AM() {
        // Given LocalTime
        LocalDateTime day = LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 45, 0);

        // When
        int result = ColdMeal.getColdMealCounter(CheckInDate.of(day));

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_no_participant_when_it_is_before_9PM() {
        // Given LocalTime
        LocalDateTime day = LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 1, 0);

        // When
        int result = ColdMeal.getColdMealCounter(CheckInDate.of(day));

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_no_participant_when_it_is_after_00_AM() {
        // Given LocalTime
        LocalDateTime day = LocalDateTime.of(2018, Month.OCTOBER, 18, 20, 59, 0);

        // When
        int result = ColdMeal.getColdMealCounter(CheckInDate.of(day));

        // Then
        assertThat(result).isEqualTo(0);
    }
}
