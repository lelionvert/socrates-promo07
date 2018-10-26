package fr.lacombe.socrates.diets;

import org.junit.Test;

import static fr.lacombe.socrates.diets.Diet.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class CoversAcceptanceTest {

    @Test
    public void should_return_the_number_of_covers_by_diet_for_a_meal() {
        final Covers covers = Covers.of(asList(
                VEGAN,
                VEGETARIAN,
                PESCETARIAN,
                OMNIVOROUS,
                PESCETARIAN
        ));

        final CoversByDiet result = covers.countByDiet();

        assertThat(result.getCoversBy(VEGAN)).isEqualTo(1);
        assertThat(result.getCoversBy(VEGETARIAN)).isEqualTo(1);
        assertThat(result.getCoversBy(PESCETARIAN)).isEqualTo(2);
        assertThat(result.getCoversBy(OMNIVOROUS)).isEqualTo(1);
    }
}
