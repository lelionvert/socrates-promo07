package fr.lacombe.socrates.diets;

import org.junit.Test;

import static fr.lacombe.socrates.diets.Diet.*;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class CoversTest {

    @Test
    public void should_count_zero_covers_when_there_is_no_diet() {
        final Covers covers = Covers.of(emptyList());

        final CoversByDiet result = covers.countByDiet();

        assertThat(result.getCoversBy(OMNIVOROUS)).isEqualTo(0);
    }

    @Test
    public void should_count_one_cover_when_there_is_one_diet() {
        final Covers covers = Covers.of(singletonList(OMNIVOROUS));

        final CoversByDiet result = covers.countByDiet();

        assertThat(result.getCoversBy(OMNIVOROUS)).isEqualTo(1);
    }

    @Test
    public void should_count_two_covers_when_there_are_two_diets() {
        final Covers covers = Covers.of(asList(
                OMNIVOROUS,
                OMNIVOROUS
        ));

        final CoversByDiet result = covers.countByDiet();

        assertThat(result.getCoversBy(OMNIVOROUS)).isEqualTo(2);
    }

    @Test
    public void should_count_one_cover_by_diet_when_there_are_two_different_diets() {
        final Covers covers = Covers.of(asList(
                VEGETARIAN,
                OMNIVOROUS
        ));

        final CoversByDiet result = covers.countByDiet();

        assertThat(result.getCoversBy(VEGETARIAN)).isEqualTo(1);
        assertThat(result.getCoversBy(OMNIVOROUS)).isEqualTo(1);
    }

    @Test
    public void should_count_one_cover_by_diet_when_there_are_three_different_diets() {
        final Covers covers = Covers.of(asList(
                PESCETARIAN,
                VEGETARIAN,
                OMNIVOROUS
        ));

        final CoversByDiet result = covers.countByDiet();

        assertThat(result.getCoversBy(PESCETARIAN)).isEqualTo(1);
        assertThat(result.getCoversBy(VEGETARIAN)).isEqualTo(1);
        assertThat(result.getCoversBy(OMNIVOROUS)).isEqualTo(1);
    }
}