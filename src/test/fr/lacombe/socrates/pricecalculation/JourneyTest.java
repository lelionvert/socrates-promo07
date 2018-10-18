package fr.lacombe.socrates.pricecalculation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import javax.print.attribute.standard.JobHoldUntil;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.*;

public class JourneyTest {

    private Journey getJourney(LocalDateTime checkIn, LocalDateTime checkOut) {
        return new Journey.JourneyBuilder()
                .from(checkIn)
                .to(checkOut)
                .build();
    }

    @Test
    public void should_have_0_missing_meal_when_checkin_at_conf_beginning_and_checkout_at_conf_ending() {
        LocalDateTime checkInAtConfBeginning = LocalDateTime.of(2018, Month.OCTOBER, 18, 15, 0);
        LocalDateTime checkOutAtConfEnding = LocalDateTime.of(2018, Month.OCTOBER, 21, 15, 0);
        Journey completeJourney = getJourney(checkInAtConfBeginning, checkOutAtConfEnding);

        int numberOfMissingMeals = completeJourney.getNumberOfMissingMeals();

        Assertions.assertThat(numberOfMissingMeals).isEqualTo(0);
    }

    @Test
    public void should_have_1_missing_meal_when_checkin_one_day_after_conf_beginning_and_checkout_at_conf_ending() {
        LocalDateTime checkInOneDayAfterConfBeginning = LocalDateTime.of(2018, Month.OCTOBER, 19, 12, 0);
        LocalDateTime checkOutAtConfEnding = LocalDateTime.of(2018, Month.OCTOBER, 21, 15, 0);
        Journey completeJourney = getJourney(checkInOneDayAfterConfBeginning, checkOutAtConfEnding);

        int numberOfMissingMeals = completeJourney.getNumberOfMissingMeals();

        Assertions.assertThat(numberOfMissingMeals).isEqualTo(1);
    }

    @Test
    public void should_have_1_missing_meal_when_checkin_at_conf_beginning_and_checkout_one_day_before_conf_ending() {
        LocalDateTime checkInAtConfBeginning = LocalDateTime.of(2018, Month.OCTOBER, 18, 15, 0);
        LocalDateTime checkOutOneDayBeforeConfEnding = LocalDateTime.of(2018, Month.OCTOBER, 20, 18, 0);
        Journey completeJourney = getJourney(checkInAtConfBeginning, checkOutOneDayBeforeConfEnding);

        int numberOfMissingMeals = completeJourney.getNumberOfMissingMeals();

        Assertions.assertThat(numberOfMissingMeals).isEqualTo(1);
    }

    @Test
    public void should_have_2_missing_meals_when_checkin_one_day_after_conf_beginning_and_checkout_one_day_before_conf_ending() {
        LocalDateTime checkInOneDayAfterConfBeginning = LocalDateTime.of(2018, Month.OCTOBER, 19, 12, 0);
        LocalDateTime checkOutOneDayBeforeConfEnding = LocalDateTime.of(2018, Month.OCTOBER, 20, 18, 0);
        Journey completeJourney = getJourney(checkInOneDayAfterConfBeginning, checkOutOneDayBeforeConfEnding);

        int numberOfMissingMeals = completeJourney.getNumberOfMissingMeals();

        Assertions.assertThat(numberOfMissingMeals).isEqualTo(2);
    }
}