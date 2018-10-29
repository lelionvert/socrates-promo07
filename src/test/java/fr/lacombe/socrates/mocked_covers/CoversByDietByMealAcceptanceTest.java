package fr.lacombe.socrates.mocked_covers;


import org.junit.Test;
import org.mockito.BDDMockito;

import java.time.LocalDateTime;
import java.time.Month;

import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CoversByDietByMealAcceptanceTest {

    private final IYoloDataSource iYoloDataSource = mock(IYoloDataSource.class);

    @Test
    public void given_acceptance_test() {
        final Covers covers = givenCoversForAllMeals(Diet.OMNIVOROUS, 1);

        final DietByMeal dietByMeal = givenDietForAllMeals(Diet.OMNIVOROUS);

        final Meal thursdayDiner = Meal.of(
                LocalDateTime.of(2018, Month.OCTOBER, 25, 19, 0, 0),
                LocalDateTime.of(2018, Month.OCTOBER, 25, 21, 0, 0)
        );
        givenMeals(thursdayDiner);
        givenParticipantsAlwaysPresentWithDiet(Diet.OMNIVOROUS);

        final CoversAction coversAction = CoversAction.of(this.iYoloDataSource, covers, dietByMeal);

        CoversByDietByMeal result = coversAction.execute();

        assertThat(result).isEqualTo(CoversByDietByMeal.of(
                singletonMap(
                        thursdayDiner,
                        CoversByDiet.of(singletonMap(Diet.OMNIVOROUS, 1))
                )))
        ;
    }

    private void givenMeals(final Meal meal) {
        BDDMockito.given(this.iYoloDataSource.getMeals()).willReturn(singletonList(meal));
    }

    private void givenParticipantsAlwaysPresentWithDiet(final Diet diet) {
        BDDMockito.given(this.iYoloDataSource.getParticipants()).willReturn(singletonList(Participant.of(
                diet,
                LocalDateTime.of(2018, Month.OCTOBER, 25, 18, 0, 0),
                LocalDateTime.of(2018, Month.OCTOBER, 28, 16, 0, 0)
        )));
    }

    private DietByMeal givenDietForAllMeals(final Diet diet) {
        final DietByMeal dietByMeal = mock(DietByMeal.class);
        BDDMockito.given(dietByMeal.get(any(), anyList())).willReturn(singletonList(diet));
        return dietByMeal;
    }

    private Covers givenCoversForAllMeals(final Diet diet, final int nbCoversForDiet) {
        final Covers covers = mock(Covers.class);
        BDDMockito.given(covers.get(anyList())).willReturn(CoversByDiet.of(singletonMap(diet, nbCoversForDiet)));
        return covers;
    }
}
