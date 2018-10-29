package fr.lacombe.socrates.mocked_covers;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.Collections.singletonMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CoversActionTest {

    @Test
    public void should_generate_empty_covers_by_diet_by_meal_when_no_participant_and_no_meal() {
        final IYoloDataSource iYoloDataSource = mock(IYoloDataSource.class);
        given(iYoloDataSource.getMeals()).willReturn(emptyList());
        given(iYoloDataSource.getParticipants()).willReturn(emptyList());

        final Covers covers = mock(Covers.class);

        final DietByMeal dietByMeal = mock(DietByMeal.class);

        final CoversAction coversAction = CoversAction.of(iYoloDataSource, covers, dietByMeal);

        final CoversByDietByMeal result = coversAction.execute();

        assertThat(result).isEqualTo(CoversByDietByMeal.of(emptyMap()));
    }

    @Test
    public void eefhzeh() {
        final IYoloDataSource iYoloDataSource = mock(IYoloDataSource.class);
        given(iYoloDataSource.getMeals()).willReturn(emptyList());
        given(iYoloDataSource.getParticipants()).willReturn(emptyList());

        final Covers covers = mock(Covers.class);

        final DietByMeal dietByMeal = mock(DietByMeal.class);

        final CoversAction coversAction = CoversAction.of(iYoloDataSource, covers, dietByMeal);

        final CoversByDietByMeal result = coversAction.execute();

        assertThat(result).isEqualTo(CoversByDietByMeal.of(singletonMap(Meal.of(
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2)
        ),CoversByDiet.of(emptyMap()))));
    }

    @Test
    public void eefhzeh2() {
        final IYoloDataSource iYoloDataSource = mock(IYoloDataSource.class);
        given(iYoloDataSource.getMeals()).willReturn(emptyList());
        given(iYoloDataSource.getParticipants()).willReturn(emptyList());

        final Covers covers = mock(Covers.class);

        final DietByMeal dietByMeal = mock(DietByMeal.class);

        final CoversAction coversAction = CoversAction.of(iYoloDataSource, covers, dietByMeal);

        final CoversByDietByMeal result = coversAction.execute();

        assertThat(result).isNotEqualTo(CoversByDietByMeal.of(emptyMap()));
    }
}