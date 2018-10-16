package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class ColdMealTest {

    @Test
    public void should_return_participant_when_it_is_thursday() {
        // Given LocalTime
        LocalDateTime day = LocalDateTime.of(2018, Month.OCTOBER, 18, 0, 0, 0);

        // When
        int result = ColdMeal.getColdMealCounter(CheckinDate.of(day));

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_no_participant_when_it_is_after_thursday() {
        // Given LocalTime
        LocalDateTime day = LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 0, 0);

        // When
        int result = ColdMeal.getColdMealCounter(CheckinDate.of(day));

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_no_participant_when_it_is_before_thursday() {
        // Given LocalTime
        LocalDateTime day = LocalDateTime.of(2018, Month.OCTOBER, 17, 0, 0, 0);

        // When
        int result = ColdMeal.getColdMealCounter(CheckinDate.of(day));

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_no_participant_when_it_is_thursday_after_9_PM() {
        // Given LocalTime
        LocalDateTime day = LocalDateTime.of(2018, Month.OCTOBER, 18, 21, 45, 0);

        // When
        int result = ColdMeal.getColdMealCounter(CheckinDate.of(day));

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_no_participant_when_it_is_thursday_after_9_PM_2() {
        // Given LocalTime
        LocalDateTime day = LocalDateTime.of(2018, Month.OCTOBER, 19, 0, 0, 0);

        // When
        int result = ColdMeal.getColdMealCounter(CheckinDate.of(day));

        // Then
        assertThat(result).isEqualTo(1);
    }
}
