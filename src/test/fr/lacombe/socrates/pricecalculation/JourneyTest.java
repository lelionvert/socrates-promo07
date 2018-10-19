package fr.lacombe.socrates.pricecalculation;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

public class JourneyTest {

    private class ConferenceDatesProviderTest implements ConferenceDatesProvider {

        @Override
        public LocalDateTime getBeginning() {
            return LocalDateTime.of(2018, Month.OCTOBER, 18, 15, 0);
        }

        @Override
        public LocalDateTime getEnding() {
            return LocalDateTime.of(2018, Month.OCTOBER, 21, 15, 0);
        }
    }

    private ConferenceDatesProviderTest conferenceDatesProviderTest;

    @Before
    public void initTest() {
        conferenceDatesProviderTest = new ConferenceDatesProviderTest();
    }

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

        int numberOfMissingMeals = completeJourney.getNumberOfMissingMeals(conferenceDatesProviderTest);

        Assertions.assertThat(numberOfMissingMeals).isEqualTo(0);
    }

    @Test
    public void should_have_1_missing_meal_when_checkin_one_day_after_conf_beginning_and_checkout_at_conf_ending() {
        LocalDateTime confBeginning = LocalDateTime.of(2018, Month.OCTOBER, 18, 15, 0);
        LocalDateTime checkInOneDayAfterConfBeginning = confBeginning.plusDays(1).withHour(12);
        LocalDateTime checkOutAtConfEnding = LocalDateTime.of(2018, Month.OCTOBER, 21, 15, 0);
        Journey completeJourney = getJourney(checkInOneDayAfterConfBeginning, checkOutAtConfEnding);

        int numberOfMissingMeals = completeJourney.getNumberOfMissingMeals(conferenceDatesProviderTest);

        Assertions.assertThat(numberOfMissingMeals).isEqualTo(1);
    }

    @Test
    public void should_have_1_missing_meal_when_checkin_at_conf_beginning_and_checkout_one_day_before_conf_ending() {
        LocalDateTime checkInAtConfBeginning = LocalDateTime.of(2018, Month.OCTOBER, 18, 15, 0);
        LocalDateTime checkOutOneDayBeforeConfEnding = LocalDateTime.of(2018, Month.OCTOBER, 20, 18, 0);
        Journey completeJourney = getJourney(checkInAtConfBeginning, checkOutOneDayBeforeConfEnding);

        int numberOfMissingMeals = completeJourney.getNumberOfMissingMeals(conferenceDatesProviderTest);

        Assertions.assertThat(numberOfMissingMeals).isEqualTo(1);
    }

    @Test
    public void should_have_2_missing_meals_when_checkin_one_day_after_conf_beginning_and_checkout_one_day_before_conf_ending() {
        LocalDateTime checkInOneDayAfterConfBeginning = LocalDateTime.of(2018, Month.OCTOBER, 19, 12, 0);
        LocalDateTime checkOutOneDayBeforeConfEnding = LocalDateTime.of(2018, Month.OCTOBER, 20, 18, 0);
        Journey completeJourney = getJourney(checkInOneDayAfterConfBeginning, checkOutOneDayBeforeConfEnding);

        int numberOfMissingMeals = completeJourney.getNumberOfMissingMeals(conferenceDatesProviderTest);

        Assertions.assertThat(numberOfMissingMeals).isEqualTo(2);
    }

    @Test
    public void should_have_2_missing_meals_when_checkIn_one_day_after_lunch_of_conf_beginning_and_checkOut_at_conf_ending() {
        LocalDateTime confBeginning = LocalDateTime.of(2018, Month.OCTOBER, 18, 15, 0);
        LocalDateTime checkInOneDayAfterLunchOfConfBeginning = confBeginning.plusDays(1).withHour(12).plusHours(2);
        LocalDateTime checkOutAtConfEnding = LocalDateTime.of(2018, Month.OCTOBER, 21, 15, 0);
        Journey completeJourney = getJourney(checkInOneDayAfterLunchOfConfBeginning, checkOutAtConfEnding);

        int numberOfMissingMeals = completeJourney.getNumberOfMissingMeals(conferenceDatesProviderTest);

        int missedMealThursday = 1;
        int missedMealFridayLunch = 1;
        Assertions.assertThat(numberOfMissingMeals).isEqualTo(missedMealThursday + missedMealFridayLunch);
    }

    @Test
    public void should_have_2_missing_meals_when_checkIn_at_conf_beginning_and_checkOut_one_day_before_dinner_of_conf_ending() {
        LocalDateTime checkInAtConfBeginning = LocalDateTime.of(2018, Month.OCTOBER, 18, 15, 0);
        LocalDateTime confEnding = LocalDateTime.of(2018, Month.OCTOBER, 21, 15, 0);
        LocalDateTime checkOutOneDayBeforeDinnerOfConfEnding = confEnding.minusDays(1).withHour(18).minusHours(1);

        Journey completeJourney = getJourney(checkInAtConfBeginning, checkOutOneDayBeforeDinnerOfConfEnding);

        int numberOfMissingMeals = completeJourney.getNumberOfMissingMeals(conferenceDatesProviderTest);

        int missedMealSunday = 1;
        int missedMealSaturdayDinner = 1;
        Assertions.assertThat(numberOfMissingMeals).isEqualTo(missedMealSunday + missedMealSaturdayDinner);
    }

    @Test
    public void should_have_2_missing_meals_even_if_really_miss_more_than_2_meals() {
        LocalDateTime checkInAtConfBeginning = LocalDateTime.of(2018, Month.OCTOBER, 18, 15, 0);
        LocalDateTime confEnding = LocalDateTime.of(2018, Month.OCTOBER, 21, 15, 0);
        LocalDateTime checkOutOneDayBeforeLunchOfConfEnding = confEnding.minusDays(2);

        Journey completeJourney = getJourney(checkInAtConfBeginning, checkOutOneDayBeforeLunchOfConfEnding);

        int numberOfMissingMeals = completeJourney.getNumberOfMissingMeals(conferenceDatesProviderTest);

        Assertions.assertThat(numberOfMissingMeals).isEqualTo(2);
    }
}