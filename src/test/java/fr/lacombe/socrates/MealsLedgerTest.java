package fr.lacombe.socrates;

import fr.lacombe.socrates.mock.CheckInDateMock;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

public class MealsLedgerTest {

    private Venue venue;

    @Before
    public void setUp() {
        this.venue = new Venue(
                LocalDateTime.of(2018, 10, 18, 21, 0),
                LocalDateTime.of(2018, 10, 19, 0, 1)
        );
    }

    @Test
    public void should_not_serve_any_meal_when_there_is_no_participants() {
        final MealsLedger mealsLedger = MealsLedger.of(emptyList());

        final long result = mealsLedger.countColdMeals(venue);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_correct_number_of_cold_meals() {
        final CheckInDateMock canHaveColdMeal = new CheckInDateMock(LocalDateTime.of(2018, 10, 18, 22, 0));
        final CheckInDateMock cannotHaveColdMeal = new CheckInDateMock(LocalDateTime.of(2018, 10, 19, 0, 30));

        canHaveColdMeal.whenCallingIsThursdayEveningThenReturn(true);
        cannotHaveColdMeal.whenCallingIsThursdayEveningThenReturn(false);

        final List<CheckInDate> checkInDates = asList(canHaveColdMeal, canHaveColdMeal, cannotHaveColdMeal);
        final MealsLedger mealsLedger = MealsLedger.of(checkInDates);

        final long result = mealsLedger.countColdMeals(venue);

        assertThat(result).isEqualTo(2);
    }
}
